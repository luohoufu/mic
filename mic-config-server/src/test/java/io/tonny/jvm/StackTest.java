package io.tonny.jvm;

/**
 *
 * java -server -XX:+PrintFlagsFinal |grep DoEscapeAnalysis
 * java -server -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal Benchmark | grep ":"
 *
 * javac io/tonny/jvm/StatckTest.java
 *
 * java -server -Xmx20m -Xms20m -XX:+DoEscapeAnalysis -XX:+PrintGC io.tonny.jvm.StatckTest
 * java -server -Xmx20m -Xms20m -XX:-DoEscapeAnalysis -XX:+PrintGC io.tonny.jvm.StatckTest
 * Created by luohoufu on 2017/8/5.
 */
public class StatckTest {
    public static void alooc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alooc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}