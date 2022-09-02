import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageProcessor {

    BufferedImage img = null;
    public StringBuilder asciiArt = new StringBuilder();

    public int imgWidth;
    public int imgHeight;

    // Single character wide

    // Double character wide (Best usually)
    String whitePixel = "  ";
    String lightestGreyPixel = "..";
    String lightGreyPixel = "**";
    String mediumGreyPixel = "//";
    String darkGreyPixel = "SS";
    String darkestGreyPixel = "88";
    String blackPixel = "@@";
    String[] PixelColors = // going down in brightness
            {
                    " ",
                    ".",
                    "*",
                    "\\",
                    "Z",
                    "S",
                    "O",
                    "8",
                    "@"
            };

    short pixelDepth = 2;

    // Triple character wide

    File outputFile;
    FileWriter fileWriter;

    public ImageProcessor(String path) throws IOException {
        try
        {
            //img = ImageIO.read(new File("src/Images/Happy Chaos Low Res.png"));
            img = ImageIO.read(new File(path));
            //System.out.println("Successfully loaded target image");
            // Converts image to monochrome
            ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            op.filter(img, img);
        } catch (IOException e){
            //System.out.println("Failed to load target image");
            System.exit(0);
        }

        outputFile = new File("Output.txt");
        fileWriter = new FileWriter(outputFile);
    }

    public void GenerateRGBValues() throws IOException {

        //System.out.println("Loading Image to Ascii...");

        imgWidth = img.getWidth();
        imgHeight = img.getHeight();

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                // Gets RGB
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);

                // In a black and white image all the rgb channels are equal so only one needs to be used
                int brightness = color.getRed();

                if (brightness > 225) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[0]);
                        fileWriter.write(PixelColors[0]);
                    }
                }
                else if (brightness > 200) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[1]);
                        fileWriter.write(PixelColors[1]);
                    }
                }
                else if (brightness >= 175) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[2]);
                        fileWriter.write(PixelColors[2]);
                    }
                }
                else if (brightness >= 150) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[3]);
                        fileWriter.write(PixelColors[3]);
                    }
                }
                else if (brightness >= 100) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[4]);
                        fileWriter.write(PixelColors[4]);
                    }
                }
                else if (brightness >= 75) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[5]);
                        fileWriter.write(PixelColors[5]);
                    }
                }
                else if (brightness >= 50) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[6]);
                        fileWriter.write(PixelColors[6]);
                    }
                }
                else if (brightness >= 25) {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[7]);
                        fileWriter.write(PixelColors[7]);
                    }
                }
                else {
                    for (short depthI = 0; depthI < pixelDepth; depthI++) {
                        asciiArt.append(PixelColors[8]);
                        fileWriter.write(PixelColors[8]);
                    }
                }
            }
            asciiArt.append("\n");
            fileWriter.write(System.getProperty( "line.separator" ));
        }

        //System.out.println("Image Successfully Loaded to Ascii");

    }
}
