import parcs.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        task curtask = new task();
        curtask.addJarFile("Vernam.jar");
        AMInfo info = new AMInfo(curtask, null);

        FileReader fileReader = new FileReader("input.txt");
        String line;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        long startTime = System.nanoTime();

        while ((line = bufferedReader.readLine()) != null) {
            point p = info.createPoint();
            channel c = p.createChannel();

            p.execute("Vernam");

            c.write(line);
            String result=(String) c.readObject();

            System.out.println("Original sentence:");
            System.out.println(line);
            System.out.println("Cipher text:");
            System.out.println(result);
        }

        double estimatedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("Total time: " + estimatedTime);

        curtask.end();
    }
}
