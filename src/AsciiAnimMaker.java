import java.io.IOException;

public class AsciiAnimMaker {

    ImageProcessor imgProc;

    int frameDelay = 300;

    AsciiAnimMaker(String FramePaths[]) throws IOException {

        for (int i = 0; i < 6 * 20; i++) {
            String pathName = FramePaths[i%6];
            imgProc = new ImageProcessor(pathName);
            imgProc.GenerateRGBValues();
            System.out.println(imgProc.asciiArt);
            try {
                Thread.sleep(frameDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }

    }

}
