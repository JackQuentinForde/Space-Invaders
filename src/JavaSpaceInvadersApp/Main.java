package JavaSpaceInvadersApp;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    public Main() {

        super("JavaSpaceInvaders");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {

        addState(new Menu());
        addState(new Game());
        addState(new GameOver());
        addState(new HighScores());
        addState(new EnterInitials());
    }

    public static void main(String[] args) throws SlickException {

        AppGameContainer app = new AppGameContainer(new Main());
        app.setDisplayMode(800, 600, false);
        app.setTargetFrameRate(59);
        app.setShowFPS(false);
        app.start();
    }
}
