package javaee.lucene.curd;

import javaee.lucene.entity.Article;
import javaee.lucene.util.LuceneUtil;
import org.apache.lucene.document.Document;

/**
 * 索引库增删改查
 * @author ZQianlvT
 */
public class ArticleDao {
    public void add(Article article) throws Exception{
        LuceneUtil.javaBean2Document(article);
        LuceneUtil.javaBean2Document(article);

    }
    public void addAll() throws Exception{

    }
    public void update() throws Exception{

    }
    public void delete() throws Exception{

    }
    public void deleteAll() throws Exception{

    }
    public void findAllByKeyword() throws Exception{

    }
}
