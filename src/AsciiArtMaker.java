import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class AsciiArtMaker {

   static ImageProcessor imgProc;

   static boolean playAnim = true;

    public static void main(String[] args) throws IOException {

        UserOptions();

        long startTime = System.nanoTime();

        imgProc.GenerateRGBValues();

        System.out.println(imgProc.asciiArt);
        System.out.println("Image Width: " + imgProc.imgWidth);
        System.out.println("Image Height: " + imgProc.imgHeight);

        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);

    }

    public static void UserOptions() throws IOException {

        if (playAnim == true) {

            String[] FramePaths = {
                    "src/Images/Animation/Walk1.jpg",
                    "src/Images/Animation/Walk2.jpg",
                    "src/Images/Animation/Walk3.jpg",
                    "src/Images/Animation/Walk4.jpg",
                    "src/Images/Animation/Walk5.jpg",
                    "src/Images/Animation/Walk6.jpg"
            };

            AsciiAnimMaker animMaker = new AsciiAnimMaker(FramePaths);

            return;
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("INSTRUCTIONS: ");
        System.out.println("1. Make sure the target image has an x resolution of ~200 for the \"best\" result");
        System.out.println("2. Input the image's source path down below");
        System.out.println("3. Open output file and zoom out for full image");
        System.out.println("(Note: Make the \"playAnim\" bool true if you want the anim\n");
        System.out.println("Enter Image Source: ");
        String imageChoice = reader.nextLine();

        imgProc = new ImageProcessor(imageChoice);
    }

}
