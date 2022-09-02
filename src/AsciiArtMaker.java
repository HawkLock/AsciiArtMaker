import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AsciiArtMaker {

   static ImageProcessor imgProc;

   static long startTime = 0;
   static long endTime = 0;

    public static void main(String[] args) throws IOException {

        UserOptions();

    }

    public static void UserOptions() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.println("INSTRUCTIONS: ");
        System.out.println("Generating a Picture (Works best if viewed with windows notepad): ");
        System.out.println("1. Enter \"Picture\" to convert an image(needs image path)");
        System.out.println("2. Make sure the target image has an x resolution of ~200 for the \"best\" result (~80 for macs)");
        System.out.println("3. Input the image's source path down below");
        System.out.println("4. If on windows: Open output file in notepad and zoom out for full image");
        System.out.println("Generating Animation (Works on most): ");
        System.out.println("1. Type \"Animation\" ");
        System.out.println("2. Type the animation name (only MegaMan now) ");
        System.out.println("Note. If you want to add a new animation, make a folder of 30x30 frames in the animation folder ");
        System.out.println("Enter Mode: ");
        String modeChoice = reader.nextLine();

        if (modeChoice.equals("Picture")) {
            System.out.println("Enter Image Source: ");
            String imageChoice = reader.nextLine();
            long startTime = System.nanoTime();
            imgProc = new ImageProcessor(imageChoice);
            imgProc.GenerateRGBValues();

            System.out.println(imgProc.asciiArt);
            long endTime = System.nanoTime();
            System.out.println("Image Width: " + imgProc.imgWidth);
            System.out.println("Image Height: " + imgProc.imgHeight);
            System.out.println(endTime - startTime);
        }
        else if (modeChoice.equals("Animation")) {
            System.out.println("Enter Anim Name: ");
            String animChoice = reader.nextLine();
            String directoryPath = "src/Images/Animation/" + animChoice + "/";
            File directory = new File(directoryPath);
            String[] FramePaths = directory.list();

            ArrayList<String> FramePathArray = new ArrayList<String>();
            for (int i = 1; i < FramePaths.length; i++) {
                FramePathArray.add(directoryPath + (i) + ".png");
            }

            AnimationProcessor animMaker = new AnimationProcessor(FramePathArray);
        }
    }

}
