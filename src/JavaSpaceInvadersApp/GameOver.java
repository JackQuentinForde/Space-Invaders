package JavaSpaceInvadersApp;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState {

    private int ID = 2;
    Textures textures = new Textures();
    Fonts fonts = new Fonts();
    ScoresReaderWriter scoresReaderWriter = new ScoresReaderWriter();
    EnterInitials enterInitials = new EnterInitials();
    boolean isNewHighScore;
    String gameOver = "GAME OVER";
    String score = "Score: ";
    String retMenu = "Press Enter";

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        textures.loadTextures();
        fonts.loadFonts();
        isNewHighScore = false;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        scoresReaderWriter.readScores();
        Input input = container.getInput();

        for (int i=1; i<scoresReaderWriter.numScores; i++) {
            if ((Integer.valueOf(scoresReaderWriter.scores.get(i)) < Integer.valueOf(scoresReaderWriter.scores.get(0)) && isNewHighScore==false) || (scoresReaderWriter.numScores<11)) {
                isNewHighScore = true;
            }
        }

        if (input.isKeyPressed(Input.KEY_ENTER) || input.isKeyPressed(Input.KEY_ESCAPE)) {
            if (!isNewHighScore) {
                game.enterState(0);
            }
            else {
                isNewHighScore=false;
                game.enterState(4);
            }
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.setFont(fonts.titleFont);
        g.drawString(gameOver, Display.getWidth()/2 - fonts.titleFont.getWidth(gameOver)/2, Display.getHeight()/2-100);
        g.setFont(fonts.basicFont);
        g.drawString(score+scoresReaderWriter.scores.get(0), Display.getWidth()/2 - fonts.basicFont.getWidth(score+scoresReaderWriter.scores.get(0))/2, Display.getHeight()/2);
        g.drawString(retMenu, Display.getWidth()/2 - fonts.basicFont.getWidth(retMenu)/2, Display.getHeight()/2+100);
    }

    @Override
    public int getID() {
        return ID;
    }
}


