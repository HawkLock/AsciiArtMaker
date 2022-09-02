import java.io.IOException;
import java.util.ArrayList;

/*

Animal Animation: https://docs.coronalabs.com/guide/media/spriteAnimation/index.html
MegaMan Animation: https://www.kindpng.com/imgv/mwToi_exemplo-de-spritesheet-sprite-sheet-megaman-png-transparent/
Mr. Sweeney: MyUS

 */

public class AnimationProcessor {

    ImageProcessor imgProc;


    int frameDelay = 200;
    short loopCount = 20;

    AnimationProcessor(ArrayList<String> FramePaths) throws IOException {

        for (int i = 0; i < FramePaths.size() * loopCount; i++) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            String pathName = FramePaths.get(i % FramePaths.size());
            imgProc = new ImageProcessor(pathName);
            imgProc.GenerateRGBValues();
            System.out.println(imgProc.asciiArt);
            try {
                Thread.sleep(frameDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
