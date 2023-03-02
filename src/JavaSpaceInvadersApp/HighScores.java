package JavaSpaceInvadersApp;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HighScores extends BasicGameState {

    private int ID = 3;
    Textures textures = new Textures();
    Fonts fonts = new Fonts();
    ScoresReaderWriter scoresReaderWriter = new ScoresReaderWriter();
    int currentY;
    int scorePos;
    String retMenu = "Press Enter";

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        textures.loadTextures();
        fonts.loadFonts();
        currentY = 20;
        scorePos = 1;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        scoresReaderWriter.readScores();
        Input input = container.getInput();

        if ((input.isKeyPressed(Input.KEY_ENTER)) || (input.isKeyPressed(Input.KEY_ESCAPE))) {
            game.enterState(0);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.setFont(fonts.basicFont);
        currentY = 20;
        scorePos = 1;
        for (int i=1; i<scoresReaderWriter.numScores-1; i++) {
            g.drawString(String.valueOf(scorePos)+". "+scoresReaderWriter.scores.get(i) + " " + scoresReaderWriter.names.get(i), Display.getWidth()/2 - (fonts.basicFont.getWidth(String.valueOf(scorePos)+". "+scoresReaderWriter.scores.get(i) + " " + scoresReaderWriter.names.get(i)))/2, currentY);
            currentY = currentY+50;
            scorePos++;
        }
        if (scoresReaderWriter.numScores==11) {
            g.drawString(String.valueOf(scorePos) + ". " + scoresReaderWriter.scores.get(10) + " " + scoresReaderWriter.names.get(10), Display.getWidth() / 2 - (fonts.basicFont.getWidth(String.valueOf(scorePos) + ". " + scoresReaderWriter.scores.get(9) + " " + scoresReaderWriter.names.get(10))) / 2 - 16, currentY);
        }
        else {
            g.drawString(String.valueOf(scorePos) + ". " + scoresReaderWriter.scores.get(scoresReaderWriter.numScores-1) + " " + scoresReaderWriter.names.get(scoresReaderWriter.numScores-1), Display.getWidth() / 2 - fonts.basicFont.getWidth(String.valueOf(scorePos) + ". " + scoresReaderWriter.scores.get(scoresReaderWriter.numScores-1) + " " + scoresReaderWriter.names.get(scoresReaderWriter.numScores-1)) / 2, currentY);
        }
        g.drawString(retMenu, Display.getWidth()/2 - fonts.basicFont.getWidth(retMenu)/2, 545);
    }

    @Override
    public int getID() {
        return ID;
    }
}
