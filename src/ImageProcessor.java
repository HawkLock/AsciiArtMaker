import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ImageProcessor {

    BufferedImage img = null;
    byte[] pixels;
    ArrayList<int[]> pixelRGBs = new ArrayList<int[]>();
    public StringBuilder asciiArt = new StringBuilder();

    public int imgWidth;
    public int imgHeight;

    // Single character wide
    /*
    char whitePixel = " ";
    char lightGreyPixel = '.';
    char mediumGreyPixel = '*';
    char darkGreyPixel = '@';
    char blackPixel = '$';
    */

    // Double character wide (Best usually)
    String whitePixel = "  ";
    String lightGreyPixel = "..";
    String mediumGreyPixel = "**";
    String darkGreyPixel = "//";
    String darkestGreyPixel = "@@";
    String blackPixel = "$$";

    // Triple character wide
    /*
    String whitePixel = "   ";
    String lightGreyPixel = "...";
    String mediumGreyPixel = "***";
    String darkGreyPixel = "///";
    String darkestGreyPixel = "@@@";
    String blackPixel = "$$$";
    */

    File outputFile;
    FileWriter fileWriter;

    public ImageProcessor() throws IOException {
        try
        {
            img = ImageIO.read(new File("src/Images/Walter White Low Res.jpg"));
            System.out.println("Successfully loaded target image");
        } catch (IOException e){
            System.out.println("Failed to load target image");
            System.exit(0);
        }

        outputFile = new File("Output.txt");
        fileWriter = new FileWriter(outputFile);
    }

    public void GenerateRGBValues() throws IOException {

        System.out.println("Loading Image to Ascii...");

        imgWidth = img.getWidth();
        imgHeight = img.getHeight();

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                // Gets RGB
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);

                int brightness = color.getRed();

                // Generates Ascii for the Image
                /*
                Notes:
                ~250 = Basically White
                ~200 = Light
                ~150 = Medium Grey
                ~100 = Dark Grey
                <100 = Basically Black
                 */

                if (brightness > 250) {
                    asciiArt.append(whitePixel);
                    fileWriter.write(whitePixel);
                }
                else if (brightness >= 200) {
                    asciiArt.append(lightGreyPixel);
                    fileWriter.write(lightGreyPixel);
                }
                else if (brightness >= 150) {
                    asciiArt.append(mediumGreyPixel);
                    fileWriter.write(mediumGreyPixel);
                }
                else if (brightness >= 100) {
                    asciiArt.append(darkGreyPixel);
                    fileWriter.write(darkGreyPixel);
                }
                else if (brightness >= 50) {
                    asciiArt.append(darkestGreyPixel);
                    fileWriter.write(darkestGreyPixel);
                }
                else if (brightness < 100) {
                    asciiArt.append(blackPixel);
                    fileWriter.write(blackPixel);
                }
            }
            asciiArt.append("\n");
            fileWriter.write(System.getProperty( "line.separator" ));
        }

        System.out.println("Image Successfully Loaded to Ascii");

    }
}
