import parcs.*;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        task curtask = new task();
        curtask.addJarFile("Abbreviations.jar");
        AMInfo info = new AMInfo(curtask, null);
        long startTime = System.nanoTime();

        point p1 = info.createPoint();
        channel c1 = p1.createChannel();
        p1.execute("Negative");
        c1.write("ghsvhc GGHH fghjkfgh ING VFGH fghjklkjhgffgh");
        List<String> res= (List<String>)c1.readObject();
        for(String str: res)
            System.out.println(str);

        double estimatedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("Total time: " + estimatedTime);

        System.out.println("Successfully converted colored images into negative images");
        curtask.end();
    }
}
