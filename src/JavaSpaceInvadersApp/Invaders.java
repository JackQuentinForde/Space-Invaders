package JavaSpaceInvadersApp;

import java.util.ArrayList;
import java.util.Random;

public class Invaders {

    Sounds sounds = new Sounds();
    ArrayList<Integer> smallInvadersX = new ArrayList<Integer>();
    ArrayList<Integer> smallInvadersY = new ArrayList<Integer>();
    ArrayList<Integer> mediumInvaders1X = new ArrayList<Integer>();
    ArrayList<Integer> mediumInvaders1Y = new ArrayList<Integer>();
    ArrayList<Integer> mediumInvaders2X = new ArrayList<Integer>();
    ArrayList<Integer> mediumInvaders2Y = new ArrayList<Integer>();
    ArrayList<Integer> largeInvaders1X = new ArrayList<Integer>();
    ArrayList<Integer> largeInvaders1Y = new ArrayList<Integer>();
    ArrayList<Integer> largeInvaders2X = new ArrayList<Integer>();
    ArrayList<Integer> largeInvaders2Y = new ArrayList<Integer>();
    ArrayList<Integer> shotX = new ArrayList<Integer>();
    ArrayList<Integer> shotY = new ArrayList<Integer>();
    boolean leftToRight;
    boolean goDown;
    boolean shotObstructed;
    boolean soundPlayed;
    int currentX;
    int numSmallInvaders;
    int numMediumInvaders1;
    int numMediumInvaders2;
    int numLargeInvaders1;
    int numLargeInvaders2;
    int step = 25;
    int delay;
    int delayDecrease = 0;
    int numShots;
    int shotStep = 5;
    int shotSpawnPoint;
    int shootChance;
    int shootMax = 100;
    int smallxBubble = 16;
    int mediumxBubble = 18;
    int largexBubble = 20;
    int yBubble = 16;
    int smallReward = 100;
    int mediumReward = 50;
    int largeReward = 25;
    int moveNum;

    protected void init() {

        sounds.loadSounds();
        numSmallInvaders = 0;
        smallInvadersX.clear();
        smallInvadersY.clear();
        numMediumInvaders1 = 0;
        mediumInvaders1X.clear();
        mediumInvaders1Y.clear();
        numMediumInvaders2 = 0;
        mediumInvaders2X.clear();
        mediumInvaders2Y.clear();
        numLargeInvaders1 = 0;
        largeInvaders1X.clear();
        largeInvaders1Y.clear();
        numLargeInvaders2 = 0;
        largeInvaders2X.clear();
        largeInvaders2Y.clear();
        currentX = 125;
        delay = 1000 - delayDecrease;
        moveNum = 1;
        numShots = 0;
        shotX.clear();
        shotY.clear();
        leftToRight = true;

        for (int i = 0; i < 11; i++) {
            smallInvadersX.add(i, currentX);
            smallInvadersY.add(i, 100);
            currentX = currentX + step * 2;
            numSmallInvaders++;
        }
        currentX = 125;

        for (int i = 0; i < 11; i++) {
            mediumInvaders1X.add(i, currentX);
            mediumInvaders1Y.add(i, 150);
            currentX = currentX + step * 2;
            numMediumInvaders1++;
        }
        currentX = 125;

        for (int i = 0; i < 11; i++) {
            mediumInvaders2X.add(i, currentX);
            mediumInvaders2Y.add(i, 200);
            currentX = currentX + step * 2;
            numMediumInvaders2++;
        }
        currentX = 125;

        for (int i = 0; i < 11; i++) {
            largeInvaders1X.add(i, currentX);
            largeInvaders1Y.add(i, 250);
            currentX = currentX + step * 2;
            numLargeInvaders1++;
        }
        currentX = 125;

        for (int i = 0; i < 11; i++) {
            largeInvaders2X.add(i, currentX);
            largeInvaders2Y.add(i, 300);
            currentX = currentX + step * 2;
            numLargeInvaders2++;
        }
    }

    protected void update() {

        goDown = false;
        shotObstructed = false;
        soundPlayed = false;

        if (leftToRight) {

            if (numSmallInvaders>0) {
                if (smallInvadersX.get(numSmallInvaders-1)==725) {
                    goDown = true;
                }
            }

            if (numMediumInvaders1>0) {
                if (mediumInvaders1X.get(numMediumInvaders1-1)==725) {
                    goDown = true;
                }
            }

            if (numMediumInvaders2>0) {
                if (mediumInvaders2X.get(numMediumInvaders2-1)==725) {
                    goDown = true;
                }
            }

            if (numLargeInvaders1>0) {
                if (largeInvaders1X.get(numLargeInvaders1-1)==725) {
                    goDown = true;
                }
            }

            if (numLargeInvaders2>0) {
                if (largeInvaders2X.get(numLargeInvaders2-1)==725) {
                    goDown = true;
                }
            }

            if (goDown) {

                if (numSmallInvaders>0) {
                    for (int i = 0; i < numSmallInvaders; i++) {
                        smallInvadersY.set(i, smallInvadersY.get(i) + step);
                    }
                }
                if (numMediumInvaders1>0) {
                    for (int i = 0; i < numMediumInvaders1; i++) {
                        mediumInvaders1Y.set(i, mediumInvaders1Y.get(i) + step);
                    }
                }
                if (numMediumInvaders2>0) {
                    for (int i = 0; i < numMediumInvaders2; i++) {
                        mediumInvaders2Y.set(i, mediumInvaders2Y.get(i) + step);
                    }
                }
                if (numLargeInvaders1>0) {
                    for (int i = 0; i < numLargeInvaders1; i++) {
                        largeInvaders1Y.set(i, largeInvaders1Y.get(i) + step);
                    }
                }
                if (numLargeInvaders2>0) {
                    for (int i = 0; i < numLargeInvaders2; i++) {
                        largeInvaders2Y.set(i, largeInvaders2Y.get(i) + step);
                    }
                }
                delay = delay-10;
                leftToRight = false;
            }

            else {
                if (numSmallInvaders > 0) {
                    for (int i = 0; i < numSmallInvaders; i++) {
                        smallInvadersX.set(i, smallInvadersX.get(i) + step);
                    }
                }

                if (numMediumInvaders1 > 0) {
                    for (int i = 0; i < numMediumInvaders1; i++) {
                        mediumInvaders1X.set(i, mediumInvaders1X.get(i) + step);
                    }
                }

                if (numMediumInvaders2 > 0) {
                    for (int i = 0; i < numMediumInvaders2; i++) {
                        mediumInvaders2X.set(i, mediumInvaders2X.get(i) + step);
                    }
                }

                if (numLargeInvaders1 > 0) {
                    for (int i = 0; i < numLargeInvaders1; i++) {
                        largeInvaders1X.set(i, largeInvaders1X.get(i) + step);
                    }
                }

                if (numLargeInvaders2 > 0) {
                    for (int i = 0; i < numLargeInvaders2; i++) {
                        largeInvaders2X.set(i, largeInvaders2X.get(i) + step);
                    }
                }
            }
        }
        else {

            if (numSmallInvaders>0) {
                if (smallInvadersX.get(0)==25) {
                    goDown = true;
                }
            }

            if (numMediumInvaders1>0) {
                if (mediumInvaders1X.get(0)==25) {
                    goDown = true;
                }
            }

            if (numMediumInvaders2>0) {
                if (mediumInvaders2X.get(0)==25) {
                    goDown = true;
                }
            }

            if (numLargeInvaders1>0) {
                if (largeInvaders1X.get(0)==25) {
                    goDown = true;
                }
            }

            if (numLargeInvaders2>0) {
                if (largeInvaders2X.get(0)==25) {
                    goDown = true;
                }
            }

            if (goDown) {

                if (numSmallInvaders > 0) {
                    for (int i = 0; i < numSmallInvaders; i++) {
                        smallInvadersY.set(i, smallInvadersY.get(i) + step);
                    }
                }
                if (numMediumInvaders1 > 0) {
                    for (int i = 0; i < numMediumInvaders1; i++) {
                        mediumInvaders1Y.set(i, mediumInvaders1Y.get(i) + step);
                    }
                }
                if (numMediumInvaders2 > 0) {
                    for (int i = 0; i < numMediumInvaders2; i++) {
                        mediumInvaders2Y.set(i, mediumInvaders2Y.get(i) + step);
                    }
                }
                if (numLargeInvaders1 > 0) {
                    for (int i = 0; i < numLargeInvaders1; i++) {
                        largeInvaders1Y.set(i, largeInvaders1Y.get(i) + step);
                    }
                }
                if (numLargeInvaders2 > 0) {
                    for (int i = 0; i < numLargeInvaders2; i++) {
                        largeInvaders2Y.set(i, largeInvaders2Y.get(i) + step);
                    }
                }
                delay = delay-10;
                leftToRight = true;
            } else {
                if (numSmallInvaders > 0) {
                    for (int i = 0; i < numSmallInvaders; i++) {
                        smallInvadersX.set(i, smallInvadersX.get(i) - step);
                    }
                }

                if (numMediumInvaders1 > 0) {
                    for (int i = 0; i < numMediumInvaders1; i++) {
                        mediumInvaders1X.set(i, mediumInvaders1X.get(i) - step);
                    }
                }

                if (numMediumInvaders2 > 0) {
                    for (int i = 0; i < numMediumInvaders2; i++) {
                        mediumInvaders2X.set(i, mediumInvaders2X.get(i) - step);
                    }
                }

                if (numLargeInvaders1 > 0) {
                    for (int i = 0; i < numLargeInvaders1; i++) {
                        largeInvaders1X.set(i, largeInvaders1X.get(i) - step);
                    }
                }

                if (numLargeInvaders2 > 0) {
                    for (int i = 0; i < numLargeInvaders2; i++) {
                        largeInvaders2X.set(i, largeInvaders2X.get(i) - step);
                    }
                }
            }
        }

        if (moveNum == 1 && !soundPlayed) {
            sounds.invaderMove1();
            soundPlayed = true;
            moveNum++;
        }
        if (moveNum == 2 && !soundPlayed) {
            sounds.invaderMove2();
            soundPlayed = true;
            moveNum++;
        }
        if (moveNum == 3 && !soundPlayed) {
            sounds.invaderMove3();
            soundPlayed = true;
            moveNum = 4;
        }
        if (moveNum == 4 && !soundPlayed) {
            sounds.invaderMove4();
            soundPlayed = true;
            moveNum = 1;
        }

        if (numLargeInvaders2>0) {
            Random rn = new Random();
            shootChance = rn.nextInt(shootMax);
            if (shootChance<=shootMax/5) {
                if (numLargeInvaders2==1) {
                    shotSpawnPoint = 0;
                }
                else {
                    shotSpawnPoint = rn.nextInt(numLargeInvaders2-1);
                }
                shotX.add(largeInvaders2X.get(shotSpawnPoint)+18);
                shotY.add(largeInvaders2Y.get(shotSpawnPoint)+20);
                numShots++;
                sounds.cursorMove();
            }
        }

        if (numLargeInvaders1>0) {
            Random rn = new Random();
            shootChance = rn.nextInt(shootMax);
            if (shootChance<=shootMax/5) {
                if (numLargeInvaders1==1) {
                    shotSpawnPoint = 0;
                }
                else {
                    shotSpawnPoint = rn.nextInt(numLargeInvaders1-1);
                }
                for (int i=0; i<numLargeInvaders2; i++) {
                    if (largeInvaders1X.get(shotSpawnPoint).equals(largeInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                if (!shotObstructed) {
                    shotX.add(largeInvaders1X.get(shotSpawnPoint)+18);
                    shotY.add(largeInvaders1Y.get(shotSpawnPoint)+20);
                    numShots++;
                    sounds.cursorMove();
                }
            }
        }
        shotObstructed = false;

        if (numMediumInvaders2>0) {
            Random rn = new Random();
            shootChance = rn.nextInt(shootMax);
            if (shootChance<=shootMax/5) {
                if (numMediumInvaders2==1) {
                    shotSpawnPoint = 0;
                }
                else {
                    shotSpawnPoint = rn.nextInt(numMediumInvaders2-1);
                }
                for (int i=0; i<numLargeInvaders1; i++) {
                    if (mediumInvaders2X.get(shotSpawnPoint).equals(largeInvaders1X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numLargeInvaders2; i++) {
                    if (mediumInvaders2X.get(shotSpawnPoint).equals(largeInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                if (!shotObstructed) {
                    shotX.add(mediumInvaders2X.get(shotSpawnPoint)+16);
                    shotY.add(mediumInvaders2Y.get(shotSpawnPoint)+20);
                    numShots++;
                    sounds.cursorMove();
                }
            }
        }
        shotObstructed = false;

        if (numMediumInvaders1>0) {
            Random rn = new Random();
            shootChance = rn.nextInt(shootMax);
            if (shootChance<=shootMax/5) {
                if (numMediumInvaders1==1) {
                    shotSpawnPoint = 0;
                }
                else {
                    shotSpawnPoint = rn.nextInt(numMediumInvaders1-1);
                }
                for (int i=0; i<numMediumInvaders2; i++) {
                    if (mediumInvaders1X.get(shotSpawnPoint).equals(mediumInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numLargeInvaders1; i++) {
                    if (mediumInvaders1X.get(shotSpawnPoint).equals(largeInvaders1X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numLargeInvaders2; i++) {
                    if (mediumInvaders1X.get(shotSpawnPoint).equals(largeInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                if (!shotObstructed) {
                    shotX.add(mediumInvaders1X.get(shotSpawnPoint)+16);
                    shotY.add(mediumInvaders1Y.get(shotSpawnPoint)+20);
                    numShots++;
                    sounds.cursorMove();
                }
            }
        }
        shotObstructed = false;

        if (numSmallInvaders>0) {
            Random rn = new Random();
            shootChance = rn.nextInt(shootMax);
            if (shootChance<=shootMax/5) {
                if (numSmallInvaders==1) {
                    shotSpawnPoint = 0;
                }
                else {
                    shotSpawnPoint = rn.nextInt(numSmallInvaders - 1);
                }
                for (int i=0; i<numMediumInvaders1; i++) {
                    if (smallInvadersX.get(shotSpawnPoint).equals(mediumInvaders1X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numMediumInvaders2; i++) {
                    if (smallInvadersX.get(shotSpawnPoint).equals(mediumInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numLargeInvaders1; i++) {
                    if (smallInvadersX.get(shotSpawnPoint).equals(largeInvaders1X.get(i))) {
                        shotObstructed = true;
                    }
                }
                for (int i=0; i<numLargeInvaders2; i++) {
                    if (smallInvadersX.get(shotSpawnPoint).equals(largeInvaders2X.get(i))) {
                        shotObstructed = true;
                    }
                }
                if (!shotObstructed) {
                    shotX.add(smallInvadersX.get(shotSpawnPoint)+14);
                    shotY.add(smallInvadersY.get(shotSpawnPoint)+20);
                    numShots++;
                    sounds.cursorMove();
                }
            }
        }
        shotObstructed = false;
    }
}

