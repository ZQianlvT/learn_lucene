package test.javaee.lucene.curd; 

import javaee.lucene.curd.ArticleDao;
import javaee.lucene.entity.Article;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ArticleDao Tester. 
* 
* @author <Authors name> 
* @since <pre>04/13/2018</pre> 
* @version 1.0 
*/ 
public class ArticleDaoTest { 
    ArticleDao articleDao;
@Before
public void before() throws Exception {
    articleDao = new ArticleDao();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add() 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    Article article = new Article(1,"培训","甲骨文");
    articleDao.add(article);
} 

/** 
* 
* Method: addAll() 
* 
*/ 
@Test
public void testAddAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update() 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete() 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteAll() 
* 
*/ 
@Test
public void testDeleteAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAllByKeyword() 
* 
*/ 
@Test
public void testFindAllByKeyword() throws Exception { 
//TODO: Test goes here... 
} 


} 
