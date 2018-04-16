package javaee.lucene.firstapp;

import javaee.lucene.entity.Article;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstApp {
    /**
     * 创建索引库
     * 将Article对象放入索引库原始记录表中，从而形成词汇表
     */
    public void createIndexDB() throws IOException {
        Article article = new Article(1,"培训","甲骨文是一家培训机构");
        //创建Document对象
        Document document  = new Document();
        /*
        参数1：document 对象中的属性名
        参数2：document 对象中的属性值
        参数3：是否将此字段值转存到词汇表，项目中提倡将非id字段都存入词汇表
        参数4：是否进行词汇拆分
         */
        document.add(new Field("id",article.getId().toString(), Field.Store.YES, Field.Index.ANALYZED));
        document.add(new Field("title",article.getTitle(), Field.Store.YES, Field.Index.ANALYZED));
        document.add(new Field("content",article.getContent(), Field.Store.YES, Field.Index.ANALYZED));

        //将Document对象写入lucene索引库
        Directory d = FSDirectory.open(new File("E:/IndexDBDBDB"));
        Version v = Version.LUCENE_30;
        Analyzer a = new StandardAnalyzer(v);
        IndexWriter.MaxFieldLength m = IndexWriter.MaxFieldLength.LIMITED;
        /*
        参数1：lucene索引库最终对应在硬盘中的目录
        参数2：采用什么策略将文本拆分，一个策略就是一个具体的实现类
        参数3：最多将文本拆分出多少个词汇，LIMITED表示1w个
         */
        IndexWriter indexWriter = new IndexWriter(d,a,m);
        //将document写入lucene索引库
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    /**
     * 根据关键字从索引库中搜索符合条件的内容
     */
    public void findIndexDB() throws IOException, ParseException {
        //准备
        String keyword = "培";
        List<Article> articleList = new ArrayList<>();

        //创建IndexSearcher字符流对象
        Directory d = FSDirectory.open(new File("E:/IndexDBDBDB"));
        IndexSearcher indexSearcher = new IndexSearcher(d);

        /*
        创建查询解析器对象，并根据其获取Query对象
        参数1：使用分词器的版本，提倡使用最高
        参数2：指定对document对象的哪个属性进行搜索
        参数3：采用什么策略将文本拆分，一个策略就是一个具体的实现类
         */
        Version v = Version.LUCENE_30;
        Analyzer a = new StandardAnalyzer(v);
        QueryParser queryParser = new QueryParser(v,"content",a);
        Query query = queryParser.parse(keyword);
        /*
        根据关键字去索引库中的词汇表搜索
        参数1：表示封装关键字的查询对象
        参数2：表示查询的最大条数
         */
        TopDocs topDocs = indexSearcher.search(query,100);

        //迭代词汇表中符合条件的编号
        for (int i=0;i<topDocs.scoreDocs.length;i++){
            //取出封装编号和分数的ScoreDocs对象
            ScoreDoc scoreDoc = topDocs.scoreDocs[i];
            //取出编号
            int no = scoreDoc.doc;
            //根据编号去索引库中的原始记录表查询对应的document对象
            Document document = indexSearcher.doc(no);
            //获取document对象中的三个属性并封装成Article对象
            Article article = new Article();
            article.setId(Integer.parseInt(document.get("id")));
            article.setTitle(document.get("title"));
            article.setContent(document.get("content"));
            //将查询到的Article添加到集合中
            articleList.add(article);
        }
        //迭代打印结果集
        for (Article article:articleList) {
            System.out.print(article);
        }
    }
}
