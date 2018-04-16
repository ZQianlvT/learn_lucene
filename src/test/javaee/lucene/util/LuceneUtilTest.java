package test.javaee.lucene.util; 

import javaee.lucene.entity.Article;
import javaee.lucene.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LuceneUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>04/13/2018</pre> 
* @version 1.0 
*/ 
public class LuceneUtilTest { 

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: javaBean2Document(Object obj) 
* 
*/ 
@Test
public void testJavaBean2Document() throws Exception { 
//TODO: Test goes here...
    Article article =new Article(2,"培训","甲骨文是一家培训机构");
    Document document = LuceneUtil.javaBean2Document(article);
    System.out.println(document.get("id")+"--------"+document.get("title")+"--------"+document.get("content"));
} 

/** 
* 
* Method: document2JavaBean() 
* 
*/ 
@Test
public void testDocument2JavaBean() throws Exception {
//TODO: Test goes here...
    Article article =new Article(2,"培训","甲骨文是一家培训机构");
    Document document = LuceneUtil.javaBean2Document(article);
    Article rsArticle = LuceneUtil.document2JavaBean(document, article.getClass());
    System.out.println(rsArticle);
} 

/** 
* 
* Method: getDirectory() 
* 
*/ 
@Test
public void testGetDirectory() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setDirectory(Directory directory) 
* 
*/ 
@Test
public void testSetDirectory() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getVersion() 
* 
*/ 
@Test
public void testGetVersion() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setVersion(Version version) 
* 
*/ 
@Test
public void testSetVersion() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAnalyzer() 
* 
*/ 
@Test
public void testGetAnalyzer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setAnalyzer(Analyzer analyzer) 
* 
*/ 
@Test
public void testSetAnalyzer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMaxFieldLength() 
* 
*/ 
@Test
public void testGetMaxFieldLength() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setMaxFieldLength(IndexWriter.MaxFieldLength maxFieldLength) 
* 
*/ 
@Test
public void testSetMaxFieldLength() throws Exception { 
//TODO: Test goes here... 
} 


} 
