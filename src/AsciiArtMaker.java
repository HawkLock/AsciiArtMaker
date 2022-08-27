import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class AsciiArtMaker {

   static ImageProcessor imgProc;

    public static void main(String[] args) throws IOException {

        UserOptions();

        imgProc.GenerateRGBValues();

        System.out.println(imgProc.asciiArt);
        System.out.println("Image Width: " + imgProc.imgWidth);
        System.out.println("Image Height: " + imgProc.imgHeight);

    }

    public static void UserOptions() throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("INSTRUCTIONS: ");
        System.out.println("1. Make sure the target image has an x resolution of ~200 for the \"best\" result");
        System.out.println("2. Input the image's source path down below");
        System.out.println("3. Open output file and zoom out for full image\n");
        System.out.println("Enter Image Source: ");
        String imageChoice = reader.nextLine();

        imgProc = new ImageProcessor(imageChoice);
    }

}
