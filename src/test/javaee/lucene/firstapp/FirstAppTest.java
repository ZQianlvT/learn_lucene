package test.javaee.lucene.firstapp; 

import javaee.lucene.firstapp.FirstApp;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* FirstApp Tester. 
* 
* @author <Authors name> 
* @since <pre>04/12/2018</pre> 
* @version 1.0 
*/ 
public class FirstAppTest { 

@Before
public void before() {
} 

@After
public void after() {
} 

/** 
* 
* Method: createIndexDB() 
* 
*/ 
@Test
public void testCreateIndexDB() throws Exception { 
//TODO: Test goes here...
    new FirstApp().createIndexDB();
}

/**
*
* Method: findIndexDB()
*
*/
@Test
public void testFindIndexDB() throws Exception {
//TODO: Test goes here...
    new FirstApp().findIndexDB();
} 


} 
