package JavaSpaceInvadersApp;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fonts {

    Image basicFontImage;
    Image titleFontImage;
    Image smallFontImage;
    AngelCodeFont basicFont;
    AngelCodeFont titleFont;
    AngelCodeFont smallFont;

    protected void loadFonts() {
        try {
            basicFontImage = new Image("res/fonts/PressStart_0.png");
            titleFontImage = new Image("res/fonts/gameOver_0.png");
            smallFontImage = new Image("res/fonts/Score_0.png");
            basicFont = new AngelCodeFont("res/fonts/PressStart.fnt", basicFontImage);
            titleFont = new AngelCodeFont("res/fonts/gameOver.fnt", titleFontImage);
            smallFont = new AngelCodeFont("res/fonts/Score.fnt", smallFontImage);
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
