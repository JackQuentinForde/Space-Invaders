package JavaSpaceInvadersApp;

import java.util.Random;

public class FlyingSaucer {

    int[] rewardsArray = {300,400,500,600};
    int x = -100;
    int y = 50;
    int xBubble = 32;
    int yBubble = 16;
    int step = 3;
    int whichReward;
    int reward;
    int spawnChance;
    int spawnSide;
    boolean alreadyMoving = false;

    protected void init() {
        x = -100;
        spawnChance = 0;
        spawnSide = 0;
        alreadyMoving = false;
    }

    protected void spawn() {
        Random rn = new Random();
        spawnChance = rn.nextInt(300);

        if (spawnChance>=295) {
            spawnSide = rn.nextInt(2) + 1;

            switch (spawnSide) {
                case 1:
                    x = -xBubble*2;
                    break;
                case 2:
                    x = 800;
                    break;
            }
            spawnChance = 0;
            alreadyMoving = true;
        }
    }

    protected void update() {

        if (alreadyMoving && spawnSide==1) {
            if (x<800) {
                x = x+step;
            }
            else {
                x = -100;
                spawnSide = 0;
                alreadyMoving = false;
            }
        }

        if (alreadyMoving && spawnSide==2) {
            if (x>-xBubble*2) {
                x = x-step;
            }
            else {
                x = -100;
                spawnSide = 0;
                alreadyMoving = false;
            }
        }
    }

    protected void reward() {
        Random rn = new Random();
        whichReward = rn.nextInt(3);
        reward = rewardsArray[whichReward];
    }
}
