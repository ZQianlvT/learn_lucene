package test.javaee.lucene.secondapp; 

import javaee.lucene.secondapp.SecondApp;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SecondApp Tester. 
* 
* @author <Authors name> 
* @since <pre>04/13/2018</pre> 
* @version 1.0 
*/ 
public class SecondAppTest {
    SecondApp secondApp;

@Before
public void before() throws Exception {
    secondApp = new SecondApp();
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: createIndexDB() 
* 
*/ 
@Test
public void testCreateIndexDB() throws Exception { 
//TODO: Test goes here...
    secondApp.createIndexDB();
} 

/** 
* 
* Method: findIndexDB() 
* 
*/ 
@Test
public void testFindIndexDB() throws Exception { 
//TODO: Test goes here...
    secondApp.findIndexDB();
} 


} 
