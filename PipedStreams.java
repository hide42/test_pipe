

import org.apache.commons.io.IOUtils;

import java.io.*;

public class PipedStreams {

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output,25*1024);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100000; i++) {
                        output.write((i+" hello string strinasdhqlwkdhkqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjaaaaaaaaaaaaaaaaaaaaaaag gellowq akjsbdkjbqwjbdahbshbffkqwfkjhfskhsdlkjfhsdjkgbsdjbsdjfbs\n")
                                .getBytes());
                    }
                    output.close();
                } catch(IOException io) {
                    io.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    IOUtils.copy(input, new FileOutputStream(new File("hello")));
                    input.close();

                } catch(IOException io) {
                    io.printStackTrace();
                }

            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("Finished for "+(System.currentTimeMillis()-start));

    }

}
