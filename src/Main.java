import parcs.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        task curtask = new task();
        curtask.addJarFile("Vernam.jar");
        AMInfo info = new AMInfo(curtask, null);


        String text1 = new String ( Files.readAllBytes( Paths.get("input1.txt")));
        String text2=new String( Files.readAllBytes( Paths.get("input2.txt")));
        String text3=new String( Files.readAllBytes( Paths.get("input3.txt")));
        String text4=new String( Files.readAllBytes( Paths.get("input4.txt")));

        long startTime = System.nanoTime();

        point p1 = info.createPoint();
        channel c1 = p1.createChannel();
        point p2 = info.createPoint();
        channel c2 = p2.createChannel();
        point p3 = info.createPoint();
        channel c3 = p3.createChannel();
        point p4 = info.createPoint();
        channel c4 = p4.createChannel();

        p1.execute("Vernam");
        c1.write(text1);
        p2.execute("Vernam");
        c2.write(text2);
        p3.execute("Vernam");
        c3.write(text3);
        p4.execute("Vernam");
        c4.write(text4);

        String result1=(String)c1.readObject();
        System.out.println("Original sentence:");
        System.out.println(text1);
        System.out.println("Cipher text:");
        System.out.println(result1);

        String result2=(String)c2.readObject();
        System.out.println("Original sentence:");
        System.out.println(text2);
        System.out.println("Cipher text:");
        System.out.println(result2);

        String result3=(String)c3.readObject();
        System.out.println("Original sentence:");
        System.out.println(text3);
        System.out.println("Cipher text:");
        System.out.println(result3);
        
        String result4=(String)c4.readObject();
        System.out.println("Original sentence:");
        System.out.println(text4);
        System.out.println("Cipher text:");
        System.out.println(result4);

        double estimatedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("Total time: " + estimatedTime);

        curtask.end();
    }
}
