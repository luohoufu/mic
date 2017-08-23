package io.tonny.jvm;

import com.thoughtworks.xstream.XStream;

/**
 * cd /Users/luohoufu/mic/mic-config-server/src/test/java
 * javac -classpath /Users/luohoufu/.m2/repository/com/thoughtworks/xstream/xstream/1.4.9/xstream-1.4.9.jar io/tonny/jvm/XStreamTest.java
 * java -classpath .:/Users/luohoufu/.m2/repository/com/thoughtworks/xstream/xstream/1.4.9/xstream-1.4.9.jar:/Users/luohoufu/.m2/repository/xmlpull/xmlpull/1.1.3.1/xmlpull-1.1.3.1.jar -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -Xmn100m -XX:+UseConcMarkSweepGC io.tonny.jvm.XStreamTest
 * java -classpath .:/Users/luohoufu/.m2/repository/com/thoughtworks/xstream/xstream/1.4.9/xstream-1.4.9.jar:/Users/luohoufu/.m2/repository/xmlpull/xmlpull/1.1.3.1/xmlpull-1.1.3.1.jar -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -Xmn100m -XX:+UseConcMarkSweepGC -XX:+PrintClassHistogramBeforeFullGC -XX:+PrintClassHistogramAfterFullGC io.tonny.jvm.XStreamTest
 *
 * Created by luohoufu on 2017/8/13.
 */
public class XStreamTest {

    public static void main(String[] args) {
        int i =0 ;
        while (true) {
            XStream xs = new XStream();
            xs.toString();
            xs = null;
            while (i++ % 10000 == 0 ){
                System.out.println("==========================================================");
                System.gc();
            }
        }
    }
}
