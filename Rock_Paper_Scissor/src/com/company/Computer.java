package com.company;

import java.util.Random;

public class Computer {
    Random random = new Random();
    Move selection;

    public Move makeSelection() {
        int range = 3;
        int choice = random.nextInt(range);

        switch (choice) {
            case 0:
                selection= Move.ROCK;
                break;
            case 1:
                selection= Move.PAPER;
                break;
            case 2:
                selection= Move.SCISSOR;
                break;
        }

        return selection;
    }
}
