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

        point p = info.createPoint();
        channel c = p1.createChannel();
       
        p.execute("Vernam");
        c.write(text1+text2+text3+text4);

        String result=(String)c.readObject();
        System.out.println("Original sentence:");
        System.out.println(text1+text2+text3+text4);
        System.out.println("Cipher text:");
        System.out.println(result);

 
        double estimatedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("Total time: " + estimatedTime);

        curtask.end();
    }
}
