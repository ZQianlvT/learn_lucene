package javaee.lucene.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 工具类
 * @author ZQianlvT
 */
public class LuceneUtil {
    private static Directory directory;
    private static Version version;
    private static Analyzer analyzer;
    private static IndexWriter.MaxFieldLength maxFieldLength;

    static {
        try {
            directory = FSDirectory.open(new File("E:/IndexDBDBDB"));
            version = Version.LUCENE_30;
            analyzer = new StandardAnalyzer(version);
            maxFieldLength = IndexWriter.MaxFieldLength.LIMITED;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //私有化构造函数
    private LuceneUtil(){}

    /**
     * 将JavaBean转化为Document对象
     */
    public static Document javaBean2Document(Object obj) throws Exception{
        Document document = new Document();
        //使用反射获取Document的add方法需要的参数
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            //通过字段人工拼接get方法
            String methodName = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method method = clazz.getMethod(methodName, null);
            String value = method.invoke(obj, null).toString();
            //添加到document对象中
            document.add(new org.apache.lucene.document.Field(fieldName,value, org.apache.lucene.document.Field.Store.YES, org.apache.lucene.document.Field.Index.ANALYZED));
        }
        return document;
    }

    /**
     * 将Document转化为JavaBean对象
     */
    public  static <T> T document2JavaBean(Document document,Class<T> clazz) throws Exception{
        T t = clazz.newInstance();
        //使用反射获取Document对象的get方法需要的参数
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            //使用document获取值
            String value = document.get(fieldName);
            BeanUtils.setProperty(t,fieldName,value);
        }
        return t;
    }

    public static Directory getDirectory() {
        return directory;
    }

    public static void setDirectory(Directory directory) {
        LuceneUtil.directory = directory;
    }

    public static Version getVersion() {
        return version;
    }

    public static void setVersion(Version version) {
        LuceneUtil.version = version;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public static void setAnalyzer(Analyzer analyzer) {
        LuceneUtil.analyzer = analyzer;
    }

    public static IndexWriter.MaxFieldLength getMaxFieldLength() {
        return maxFieldLength;
    }

    public static void setMaxFieldLength(IndexWriter.MaxFieldLength maxFieldLength) {
        LuceneUtil.maxFieldLength = maxFieldLength;
    }
}
