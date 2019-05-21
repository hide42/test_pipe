
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.management.ManagementFactory;


public class ByteArrayTest {
    public static void main(String[] args) throws Exception {
        long freeMemory = 0;
        long maxMemory =0;
        //System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        long start = System.currentTimeMillis();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int i = 0; i < 100000; i++) {
            out.write((i+" hello string strinasdhqlwkdhkqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjaaaaaaaaaaaaaaaaaaaaaaag gellowq akjsbdkjbqwjbdahbshbffkqwfkjhfskhsdlkjfhsdjkgbsdjbsdjfbs\n")
                    .getBytes());
        }
        out.close();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        IOUtils.copy(in, new FileOutputStream(new File("hello")));
        System.out.println("Finished for "+(System.currentTimeMillis()-start));

        freeMemory = Runtime.getRuntime().freeMemory() ;
        maxMemory = Runtime.getRuntime().maxMemory() ;

        System.out.println("Used Memory in JVM: " + (maxMemory - freeMemory));
    }
}