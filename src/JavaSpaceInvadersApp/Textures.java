package JavaSpaceInvadersApp;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Textures {

    Image cursorImage;
    Image groundImage;
    Image cannonImage;
    Image cannonShotImage;
    Image smallInvader1;
    Image smallInvader2;
    Image mediumInvader1;
    Image mediumInvader2;
    Image largeInvader1;
    Image largeInvader2;
    Image flyingSaucer;
    Image selectorImage;
    Image backSpaceImage;

    protected void loadTextures() {
        try {
            cursorImage = new Image("res/sprites/Cursor.png");
            groundImage = new Image("res/sprites/greenLine.png");
            cannonImage = new Image("res/sprites/Cannon.png");
            cannonShotImage = new Image("res/sprites/CannonShot.png");
            smallInvader1 = new Image("res/sprites/SmallInvader1.png");
            smallInvader2 = new Image("res/sprites/SmallInvader2.png");
            mediumInvader1 = new Image("res/sprites/MediumInvader1.png");
            mediumInvader2 = new Image("res/sprites/MediumInvader2.png");
            largeInvader1 = new Image("res/sprites/LargeInvader1.png");
            largeInvader2 = new Image("res/sprites/LargeInvader2.png");
            flyingSaucer = new Image("res/sprites/FlyingSaucer.png");
            selectorImage = new Image("res/sprites/Selector.png");
            backSpaceImage = new Image("res/sprites/Backspace.png");
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
