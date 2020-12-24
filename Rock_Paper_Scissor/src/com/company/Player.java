package com.company;

public class Player {
    private Move selection;

    public Move makeSelection(String userInput){
        switch (userInput) {
            case "R":
                selection= Move.ROCK;
                break;
            case "P":
                selection= Move.PAPER;
                break;
            case "S":
                selection= Move.SCISSOR;
                break;
        }
        return selection;
    }
}
