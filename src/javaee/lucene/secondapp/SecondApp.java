package javaee.lucene.secondapp;

import javaee.lucene.entity.Article;
import javaee.lucene.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.util.ArrayList;
import java.util.List;

/**
 * 重构FirstApp
 */
public class SecondApp {
    /**
     * 创建索引库
     */
    public void createIndexDB() throws Exception{
        Article article = new Article(2,"培训","云之梦是一家培训机构！");
        Document document = LuceneUtil.javaBean2Document(article);
        IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(),LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    /**
     * 根据关键字从索引库查询符合条件的数据
     */
    public void findIndexDB() throws Exception{
        String keyword = "机构";
        List<Article> articleList = new ArrayList<>();
        IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
        QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(),"content",LuceneUtil.getAnalyzer());
        Query query = queryParser.parse(keyword);
        TopDocs topDocs = indexSearcher.search(query, 100);
        for(int i=0;i<topDocs.scoreDocs.length;i++){
            ScoreDoc scoreDoc = topDocs.scoreDocs[i];
            int no = scoreDoc.doc;
            Document document = indexSearcher.doc(no);
            Article article = LuceneUtil.document2JavaBean(document, Article.class);
            articleList.add(article);
        }
        for (Article article: articleList) {
            System.out.println(article);
        }
    }
}
