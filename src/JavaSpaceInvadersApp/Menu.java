package JavaSpaceInvadersApp;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

    private int ID = 0;
    Textures textures = new Textures();
    Fonts fonts = new Fonts();
    Sounds sounds = new Sounds();
    int currentPos = 0;
    int currentY = 242;
    String title1 = "SPACE";
    String title2 = "INVADERS";
    String play = "Play";
    String highScores = "High Scores";
    String quit = "Quit";
    String currentSelection = play;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        textures.loadTextures();
        fonts.loadFonts();
        sounds.loadSounds();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        Input input = container.getInput();

        if (input.isKeyPressed(Input.KEY_DOWN)) {
            sounds.cursorMove();
            if (currentPos<2) {
                currentPos++;
            }
            else {
                currentPos = 0;
            }
        }

        if (input.isKeyPressed(Input.KEY_UP)) {
            sounds.cursorMove();
            if (currentPos>0) {
                currentPos--;
            }
            else {
                currentPos = 2;
            }
        }

        if (currentPos==0) {
            currentSelection = play;
            currentY = 242;
        }
        else if (currentPos==1) {
            currentSelection = highScores;
            currentY = 342;
        }
        else {
            currentSelection = quit;
            currentY = 442;
        }

        if (input.isKeyPressed(Input.KEY_ENTER)) {
            if (currentPos==0) {
                sounds.select();
                game.enterState(1);
            }
            else if (currentPos==1) {
                sounds.select();
                game.enterState(3);
            }
            else {
                Display.destroy();
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            Display.destroy();
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.drawImage(textures.cursorImage, Display.getWidth()/2 - fonts.basicFont.getWidth(currentSelection)/2-100, currentY);
        g.setFont(fonts.titleFont);
        g.drawString(title1, Display.getWidth()/2 - fonts.titleFont.getWidth(title1)/2, 30);
        g.drawString(title2, Display.getWidth()/2 - fonts.titleFont.getWidth(title2)/2, 100);
        g.setFont(fonts.basicFont);
        g.drawString(play, Display.getWidth()/2 - fonts.basicFont.getWidth(play)/2, 250);
        g.drawString(highScores, Display.getWidth()/2 - fonts.basicFont.getWidth(highScores)/2, 350);
        g.drawString(quit, Display.getWidth()/2 - fonts.basicFont.getWidth(quit)/2, 450);
    }

    @Override
    public int getID() {
        return ID;
    }
}

