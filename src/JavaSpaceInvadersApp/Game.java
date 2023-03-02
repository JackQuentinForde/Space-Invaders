package JavaSpaceInvadersApp;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

    private int ID = 1;
    ScoresReaderWriter scoresReaderWriter = new ScoresReaderWriter();
    Textures textures = new Textures();
    Fonts fonts = new Fonts();
    Sounds sounds = new Sounds();
    Player player = new Player();
    Invaders invaders = new Invaders();
    FlyingSaucer flyingSaucer = new FlyingSaucer();
    boolean reInit = false;
    int counter = 0;
    int[] livesPos = {605,670,735};
    String yourScore = "SCORE ";
    String yourLives = "LIVES ";

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        textures.loadTextures();
        fonts.loadFonts();
        sounds.loadSounds();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        if (!reInit) {
            player.init();
            invaders.delayDecrease=0;
            invaders.init();
            flyingSaucer.init();
            reInit = true;
        }

        counter+=delta;

        player.update();
        if (counter>=invaders.delay && (invaders.numSmallInvaders>0 || invaders.numMediumInvaders1>0 || invaders.numMediumInvaders2>0 ||
                invaders.numLargeInvaders1>0 || invaders.numLargeInvaders2>0)) {
            invaders.update();
            if (!flyingSaucer.alreadyMoving) {
                flyingSaucer.spawn();
            }
            counter = 0;
        }
        flyingSaucer.update();

        if (invaders.numShots>0) {
            for (int i=0; i<invaders.numShots; i++) {
                if (invaders.shotY.get(0)<556) {
                    invaders.shotY.set(i, invaders.shotY.get(i)+invaders.shotStep);
                }
                else {
                    invaders.shotY.remove(0);
                    invaders.shotX.remove(0);
                    invaders.numShots--;
                }
            }
        }

        for (int i=0; i<invaders.numLargeInvaders2; i++) {
            if (onCollision(invaders.largeInvaders2X.get(i)+invaders.largexBubble, invaders.largeInvaders2Y.get(i)+invaders.yBubble, player.x, player.y, invaders.largexBubble, invaders.yBubble)) {
                player.respawn();
            }
            if (invaders.largeInvaders2Y.get(i)>=525) {
                player.lives=0;
            }
            if (onCollision(invaders.largeInvaders2X.get(i)+invaders.largexBubble, invaders.largeInvaders2Y.get(i)+invaders.yBubble, player.shotX + player.shotXbubble, player.shotY, invaders.largexBubble, invaders.yBubble)) {
                player.shotX = -50;
                player.shotY = -50;
                invaders.largeInvaders2X.remove(i);
                invaders.largeInvaders2Y.remove(i);
                invaders.numLargeInvaders2--;
                invaders.delay = invaders.delay-5;
                player.score = player.score+invaders.largeReward;
                sounds.invaderDestroy();
            }
        }

        for (int i=0; i<invaders.numShots; i++) {
            if (onCollision(invaders.shotX.get(i), invaders.shotY.get(i), player.x+player.xBubble, player.y+player.yBubble, player.xBubble + player.shotXbubble, player.yBubble)) {
                invaders.shotX.remove(i);
                invaders.shotY.remove(i);
                invaders.numShots--;
                player.respawn();
            }
        }

        for (int i=0; i<invaders.numLargeInvaders1; i++) {
            if (onCollision(invaders.largeInvaders1X.get(i)+invaders.largexBubble, invaders.largeInvaders1Y.get(i)+invaders.yBubble, player.x, player.y, invaders.largexBubble, invaders.yBubble)) {
                player.respawn();
            }
            if (invaders.largeInvaders1Y.get(i)>=525) {
                player.lives=0;
            }
            if (onCollision(invaders.largeInvaders1X.get(i)+invaders.largexBubble, invaders.largeInvaders1Y.get(i)+invaders.yBubble, player.shotX + player.shotXbubble, player.shotY, invaders.largexBubble, invaders.yBubble)) {
                player.shotX = -50;
                player.shotY = -50;
                invaders.largeInvaders1X.remove(i);
                invaders.largeInvaders1Y.remove(i);
                invaders.numLargeInvaders1--;
                invaders.delay = invaders.delay-5;
                player.score = player.score+invaders.largeReward;
                sounds.invaderDestroy();
            }
        }

        for (int i=0; i<invaders.numMediumInvaders2; i++) {
            if (onCollision(invaders.mediumInvaders2X.get(i)+invaders.mediumxBubble, invaders.mediumInvaders2Y.get(i)+invaders.yBubble, player.x, player.y, invaders.mediumxBubble, invaders.yBubble)) {
                player.respawn();
            }
            if (invaders.mediumInvaders2Y.get(i)>=525) {
                player.lives=0;
            }
            if (onCollision(invaders.mediumInvaders2X.get(i)+invaders.mediumxBubble, invaders.mediumInvaders2Y.get(i)+invaders.yBubble, player.shotX + player.shotXbubble, player.shotY, invaders.mediumxBubble, invaders.yBubble)) {
                player.shotX = -50;
                player.shotY = -50;
                invaders.mediumInvaders2X.remove(i);
                invaders.mediumInvaders2Y.remove(i);
                invaders.numMediumInvaders2--;
                invaders.delay = invaders.delay-5;
                player.score = player.score+invaders.mediumReward;
                sounds.invaderDestroy();
            }
        }

        for (int i=0; i<invaders.numMediumInvaders1; i++) {
            if (onCollision(invaders.mediumInvaders1X.get(i)+invaders.mediumxBubble, invaders.mediumInvaders1Y.get(i)+invaders.yBubble, player.x, player.y, invaders.mediumxBubble, invaders.yBubble)) {
                player.respawn();
            }
            if (invaders.mediumInvaders1Y.get(i)>=525) {
                player.lives=0;
            }
            if (onCollision(invaders.mediumInvaders1X.get(i)+invaders.mediumxBubble, invaders.mediumInvaders1Y.get(i)+invaders.yBubble, player.shotX + player.shotXbubble, player.shotY, invaders.mediumxBubble, invaders.yBubble)) {
                player.shotX = -50;
                player.shotY = -50;
                invaders.mediumInvaders1X.remove(i);
                invaders.mediumInvaders1Y.remove(i);
                invaders.numMediumInvaders1--;
                invaders.delay = invaders.delay-5;
                player.score = player.score+invaders.mediumReward;
                sounds.invaderDestroy();
            }
        }

        for (int i=0; i<invaders.numSmallInvaders; i++) {
            if (onCollision(invaders.smallInvadersX.get(i)+invaders.smallxBubble, invaders.smallInvadersY.get(i)+invaders.yBubble, player.x, player.y, invaders.smallxBubble, invaders.yBubble)) {
                player.respawn();
            }
            if (invaders.smallInvadersY.get(i)>=525) {
                player.lives=0;
            }
            if (onCollision(invaders.smallInvadersX.get(i) + invaders.smallxBubble, invaders.smallInvadersY.get(i) + invaders.yBubble, player.shotX + player.shotXbubble, player.shotY, invaders.smallxBubble, invaders.yBubble)) {
                player.shotX = -50;
                player.shotY = -50;
                invaders.smallInvadersX.remove(i);
                invaders.smallInvadersY.remove(i);
                invaders.numSmallInvaders--;
                invaders.delay = invaders.delay-5;
                player.score = player.score + invaders.smallReward;
                sounds.invaderDestroy();
            }
        }

        if (invaders.numLargeInvaders2==0 && invaders.numLargeInvaders1==0 && invaders.numMediumInvaders2==0 &&
                invaders.numMediumInvaders1==0 && invaders.numSmallInvaders==0) {
            invaders.delayDecrease = invaders.delayDecrease+50;
            invaders.shotX.clear();
            invaders.shotY.clear();
            invaders.numShots = 0;
            if (player.lives<3) {
                player.lives++;
            }
            invaders.init();
        }

        if (onCollision(flyingSaucer.x+flyingSaucer.xBubble, flyingSaucer.y+flyingSaucer.yBubble, player.shotX+player.shotXbubble, player.shotY, flyingSaucer.xBubble, flyingSaucer.yBubble)) {
            player.shotX = -50;
            player.shotY = -50;
            flyingSaucer.x = -100;
            flyingSaucer.spawnSide = 0;
            flyingSaucer.alreadyMoving = false;
            flyingSaucer.reward();
            player.score = player.score+flyingSaucer.reward;
            sounds.invaderDestroy();
        }

        if (player.lives==0) {
            reInit = false;
            counter = 0;
            sounds.back();
            scoresReaderWriter.writeNewLastScore(player.score);
            game.enterState(2);
        }

        Input input = container.getInput();

        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.movingRight = true;
        }
        else {
            player.movingRight = false;
        }

        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.movingLeft = true;
        }
        else {
            player.movingLeft = false;
        }

        if (input.isKeyDown(Input.KEY_X) && !player.alreadyBlasting) {
            player.shotX = player.x+24;
            player.shotY = player.y;
            player.alreadyBlasting = true;
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            player.lives = 0;
        }

        if (input.isKeyPressed(Input.KEY_ADD)) {
            invaders.delay = invaders.delay-50;
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.drawImage(textures.cannonShotImage, player.shotX, player.shotY);

        for (int i=0; i<invaders.numShots; i++) {
            g.drawImage(textures.cannonShotImage, invaders.shotX.get(i), invaders.shotY.get(i));
        }

        g.drawImage(textures.cannonImage, player.x, player.y);

        if (invaders.numSmallInvaders>0) {
            for (int i = 0; i < invaders.numSmallInvaders; i++) {
                if (invaders.moveNum == 1 || invaders.moveNum == 3) {
                    g.drawImage(textures.smallInvader1, invaders.smallInvadersX.get(i), invaders.smallInvadersY.get(i));
                } else {
                    g.drawImage(textures.smallInvader2, invaders.smallInvadersX.get(i), invaders.smallInvadersY.get(i));
                }
            }
        }

        if (invaders.numMediumInvaders1>0) {
            for (int i = 0; i < invaders.numMediumInvaders1; i++) {
                if (invaders.moveNum == 1 || invaders.moveNum == 3) {
                    g.drawImage(textures.mediumInvader1, invaders.mediumInvaders1X.get(i), invaders.mediumInvaders1Y.get(i));
                } else {
                    g.drawImage(textures.mediumInvader2, invaders.mediumInvaders1X.get(i), invaders.mediumInvaders1Y.get(i));
                }
            }
        }

        if (invaders.numMediumInvaders2>0) {
            for (int i = 0; i < invaders.numMediumInvaders2; i++) {
                if (invaders.moveNum == 1 || invaders.moveNum == 3) {
                    g.drawImage(textures.mediumInvader1, invaders.mediumInvaders2X.get(i), invaders.mediumInvaders2Y.get(i));
                } else {
                    g.drawImage(textures.mediumInvader2, invaders.mediumInvaders2X.get(i), invaders.mediumInvaders2Y.get(i));
                }
            }
        }

        if (invaders.numLargeInvaders1>0) {
            for (int i = 0; i < invaders.numLargeInvaders1; i++) {
                if (invaders.moveNum == 1 || invaders.moveNum == 3) {
                    g.drawImage(textures.largeInvader1, invaders.largeInvaders1X.get(i), invaders.largeInvaders1Y.get(i));
                } else {
                    g.drawImage(textures.largeInvader2, invaders.largeInvaders1X.get(i), invaders.largeInvaders1Y.get(i));
                }
            }
        }

        if (invaders.numLargeInvaders2>0) {
            for (int i = 0; i < invaders.numLargeInvaders2; i++) {
                if (invaders.moveNum == 1 || invaders.moveNum == 3) {
                    g.drawImage(textures.largeInvader1, invaders.largeInvaders2X.get(i), invaders.largeInvaders2Y.get(i));
                } else {
                    g.drawImage(textures.largeInvader2, invaders.largeInvaders2X.get(i), invaders.largeInvaders2Y.get(i));
                }
            }
        }

        g.drawImage(textures.flyingSaucer, flyingSaucer.x, flyingSaucer.y);

        for (int i = 0; i<player.lives; i++) {
            g.drawImage(textures.cannonImage, livesPos[i], 10);
        }

        g.drawImage(textures.groundImage, 0, 570);
        g.setFont(fonts.smallFont);
        g.drawString(yourScore+player.score, 20, 25);
        g.drawString(yourLives, 500, 25);
    }

    @Override
    public int getID() {
        return ID;
    }

    private boolean onCollision(int x1, int y1, int x2, int y2, int xBubble, int yBubble) {

        if (x1 >= x2 - xBubble && x1 <= x2 + xBubble && y1 >= y2 - yBubble && y1 <= y2 + yBubble) {
            return true;
        } else {
            return false;
        }
    }
}
