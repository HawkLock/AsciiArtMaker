import java.awt.*;
import java.io.IOException;

public class AsciiArtMaker {

   static ImageProcessor imgProc;

    public static void main(String[] args) throws IOException {

        imgProc = new ImageProcessor();

        imgProc.GenerateRGBValues();

        System.out.println(imgProc.asciiArt);
        System.out.println("Image Width: " + imgProc.imgWidth);
        System.out.println("Image Height: " + imgProc.imgHeight);

    }

}
