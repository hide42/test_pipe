
import org.apache.commons.io.IOUtils;

import java.io.*;


public class ByteArrayTest {
    public static void main(String[] args) throws Exception {
        long freeMemory = 0;
        long maxMemory =0;
        //System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        long start = System.currentTimeMillis();
        ByteArrayOutputStream out = new ByteArrayOutputStream(25*1024);
        for (int i = 0; i < 100000; i++) {
            out.write((i+" hello string strinasdhqlwkdhkqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjaaaaaaaaaaaaaaaaaaaaaaag gellowq akjsbdkjbqwjbdahbshbffkqwfkjhfskhsdlkjfhsdjkgbsdjbsdjfbs\n")
                    .getBytes());
        }
        out.close();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        IOUtils.copy(in, new FileOutputStream(new File("hello")));
        System.out.println("Finished for "+(System.currentTimeMillis()-start));
    }
}
