package JavaSpaceInvadersApp;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EnterInitials extends BasicGameState {

    private int ID = 4;
    Textures textures = new Textures();
    Sounds sounds = new Sounds();
    Fonts fonts = new Fonts();
    ScoresReaderWriter scoresReaderWriter = new ScoresReaderWriter();
    int selectorX;
    int selectorY;
    int numLetters;
    String enterInitials = "Enter Initials";
    String initials = "";
    String alphabet1 = "A B C D E F G";
    String alphabet2 = "H I J K L M N";
    String alphabet3 = "O P Q R S T U";
    String alphabet4 = "V W X Y Z";
    String ok = "OK";

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        textures.loadTextures();
        sounds.loadSounds();
        fonts.loadFonts();
        selectorX = 164;
        selectorY = 186;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {

        scoresReaderWriter.readScores();
        numLetters = initials.length();
        Input input = container.getInput();

        if (input.isKeyPressed(Input.KEY_RIGHT)) {
            sounds.cursorMove();
            if (selectorX==560) {
                selectorX = 164;
            }
            else {
                selectorX = selectorX+66;
            }
        }

        if (input.isKeyPressed(Input.KEY_LEFT)) {
            sounds.cursorMove();
            if (selectorX==164) {
                selectorX = 560;
            }
            else {
                selectorX = selectorX-66;
            }
        }

        if (input.isKeyPressed(Input.KEY_UP)) {
            sounds.cursorMove();
            if (selectorY==186) {
                selectorY = 486;
            }
            else {
                selectorY = selectorY-100;
            }
        }

        if (input.isKeyPressed(Input.KEY_DOWN)) {
            sounds.cursorMove();
            if (selectorY==486) {
                selectorY = 186;
            }
            else {
                selectorY = selectorY+100;
            }
        }

        if (input.isKeyPressed(Input.KEY_ENTER)) {

            if (numLetters>0 && selectorX==494 && selectorY==486) {
                initials = initials.substring(0, numLetters-1);
            }

            if (numLetters==3 && selectorX==560 && selectorY==486) {
                sounds.select();
                scoresReaderWriter.writeNewHighScore(scoresReaderWriter.scores.get(0), initials);
                initials = "";
                game.enterState(0);
            }

            if (numLetters<3) {
                if (selectorY==186) {
                    sounds.select();

                    if (selectorX==164) {
                        initials = initials+"A";
                        numLetters++;
                    }
                    if (selectorX==230) {
                        initials = initials+"B";
                        numLetters++;
                    }
                    if (selectorX==296) {
                        initials = initials+"C";
                        numLetters++;
                    }
                    if (selectorX==362) {
                        initials = initials+"D";
                        numLetters++;
                    }
                    if (selectorX==428) {
                        initials = initials+"E";
                        numLetters++;
                    }
                    if (selectorX==494) {
                        initials = initials+"F";
                        numLetters++;
                    }
                    if (selectorX==560) {
                        initials = initials+"G";
                        numLetters++;
                    }
                }

                if (selectorY==286) {
                    sounds.select();

                    if (selectorX==164) {
                        initials = initials+"H";
                        numLetters++;
                    }
                    if (selectorX==230) {
                        initials = initials+"I";
                        numLetters++;
                    }
                    if (selectorX==296) {
                        initials = initials+"J";
                        numLetters++;
                    }
                    if (selectorX==362) {
                        initials = initials+"K";
                        numLetters++;
                    }
                    if (selectorX==428) {
                        initials = initials+"L";
                        numLetters++;
                    }
                    if (selectorX==494) {
                        initials = initials+"M";
                        numLetters++;
                    }
                    if (selectorX==560) {
                        initials = initials+"N";
                        numLetters++;
                    }
                }

                if (selectorY==386) {
                    sounds.select();

                    if (selectorX==164) {
                        initials = initials+"O";
                        numLetters++;
                    }
                    if (selectorX==230) {
                        initials = initials+"P";
                        numLetters++;
                    }
                    if (selectorX==296) {
                        initials = initials+"Q";
                        numLetters++;
                    }
                    if (selectorX==362) {
                        initials = initials+"R";
                        numLetters++;
                    }
                    if (selectorX==428) {
                        initials = initials+"S";
                        numLetters++;
                    }
                    if (selectorX==494) {
                        initials = initials+"T";
                        numLetters++;
                    }
                    if (selectorX==560) {
                        initials = initials+"U";
                        numLetters++;
                    }
                }

                if (selectorY==486) {

                    if (selectorX==164) {
                        sounds.select();
                        initials = initials+"V";
                        numLetters++;
                    }
                    if (selectorX==230) {
                        sounds.select();
                        initials = initials+"W";
                        numLetters++;
                    }
                    if (selectorX==296) {
                        sounds.select();
                        initials = initials+"X";
                        numLetters++;
                    }
                    if (selectorX==362) {
                        sounds.select();
                        initials = initials+"Y";
                        numLetters++;
                    }
                    if (selectorX==428) {
                        sounds.select();
                        initials = initials+"Z";
                        numLetters++;
                    }
                    if (selectorX==494) {
                        sounds.back();
                    }
                    if (selectorX==560) {
                        sounds.back();
                    }
                }
            }
            else if (selectorX!=560 && selectorY!=486){
                sounds.back();
            }
        }

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {

        g.setFont(fonts.basicFont);
        g.drawString(enterInitials, Display.getWidth()/2 - fonts.basicFont.getWidth(enterInitials)/2, 25);
        g.drawString(initials, Display.getWidth()/2 - fonts.basicFont.getWidth(initials)/2, 100);
        g.drawString(alphabet1, Display.getWidth()/2 - fonts.basicFont.getWidth(alphabet1)/2, 200);
        g.drawString(alphabet2, Display.getWidth()/2 - fonts.basicFont.getWidth(alphabet2)/2, 300);
        g.drawString(alphabet3, Display.getWidth()/2 - fonts.basicFont.getWidth(alphabet3)/2, 400);
        g.drawString(alphabet4, Display.getWidth()/2 - fonts.basicFont.getWidth(alphabet3)/2, 500);
        g.drawString(ok, 567, 500);
        g.drawImage(textures.backSpaceImage, 505, 492);
        g.drawImage(textures.selectorImage, selectorX, selectorY);
    }

    @Override
    public int getID() {
        return ID;
    }
}

