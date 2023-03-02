package JavaSpaceInvadersApp;

import org.lwjgl.opengl.Display;

public class Player {

    Sounds sounds = new Sounds();
    int x;
    int y = 530;
    int xBubble = 26;
    int yBubble = 18;
    int step = 5;
    int lives;
    int score;
    int shotX = -50;
    int shotY = -50;
    int shotXbubble = 2;
    int shotStep = 10;
    boolean movingRight;
    boolean movingLeft;
    boolean soundPlayed;
    boolean alreadyBlasting;

    protected void init() {

        sounds.loadSounds();
        x = Display.getWidth()/2-25;
        lives = 3;
        score = 0;
        shotX = -50;
        shotY = -50;
        boolean movingRight = false;
        boolean movingLeft = false;
        boolean soundPlayed = false;
        boolean alreadyBlasting = false;
    }

    protected void respawn() {

        lives--;
        sounds.cannonDestroy();
    }

    protected void update() {

        if (movingRight && x<746) {
            x = x+step;
        }

        if (movingLeft && x>0) {
            x = x-step;
        }

        if (alreadyBlasting && shotY>0) {
            shotY = shotY-shotStep;
            if (!soundPlayed) {
                sounds.select();
                soundPlayed=true;
            }
        }
        else {
            shotX= -50;
            shotY= -50;
            alreadyBlasting = false;
            soundPlayed = false;
        }
    }
}
