package JavaSpaceInvadersApp;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {

    Sound cursorMoveSound;
    Sound selectSound;
    Sound backSound;
    Sound invaderMove1;
    Sound invaderMove2;
    Sound invaderMove3;
    Sound invaderMove4;
    Sound cannonDestroy;
    Sound invaderDestroy;

    protected void loadSounds() {
        try {
            cursorMoveSound = new Sound("res/sounds/cursorMove.wav");
            selectSound = new Sound("res/sounds/selectSound.wav");
            backSound = new Sound("res/sounds/backSound.wav");
            invaderMove1 = new Sound("res/sounds/invaderMove1.wav");
            invaderMove2 = new Sound("res/sounds/invaderMove2.wav");
            invaderMove3 = new Sound("res/sounds/invaderMove3.wav");
            invaderMove4 = new Sound("res/sounds/invaderMove4.wav");
            cannonDestroy = new Sound("res/sounds/cannonDestroy.wav");
            invaderDestroy = new Sound("res/sounds/invaderDestroy.wav");
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

    protected void cursorMove() {
        cursorMoveSound.play();
    }

    protected void select() {
        selectSound.play();
    }

    protected void back() {
        backSound.play();
    }

    protected void invaderMove1() {
        invaderMove1.play();
    }

    protected void invaderMove2() {
        invaderMove2.play();
    }

    protected void invaderMove3() {
        invaderMove3.play();
    }

    protected void invaderMove4() {
        invaderMove4.play();
    }

    protected void invaderDestroy() {
        invaderDestroy.play();
    }

    protected void cannonDestroy() {
        cannonDestroy.play();
    }
}
