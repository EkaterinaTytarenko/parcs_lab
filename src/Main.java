import parcs.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        task curtask = new task();
        System.out.println("1");
        curtask.addJarFile("Negative.jar");
        AMInfo info = new AMInfo(curtask, null);

        long startTime = System.nanoTime();
        System.out.println("2");
        File dir = new File("images");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (int i=0;i<directoryListing.length;++i) {
                File img=directoryListing[i];
                point p = info.createPoint();
                channel c = p.createChannel();
                System.out.println("4");
                p.execute("Negative");
                c.write(img);
                BufferedImage result=(BufferedImage) c.readObject();
                File file = new File("images/negative"+i+".jpg");
                System.out.println(result);
                System.out.println(file);
                ImageIO.write( result, "jpg", file);
                System.out.println("5");

            }
        }
        System.out.println("6");
        double estimatedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("Total time: " + estimatedTime);

        System.out.println("Successfully converted colored images into negative images");
        curtask.end();
    }
}
