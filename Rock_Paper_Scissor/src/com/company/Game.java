package com.company;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please select the move");
        System.out.println("Press R for Rock, P for Paper, S for Scissor");

        String userInput = inputScanner.nextLine();
        if (userInput.equals("S") || userInput.equals("P") || userInput.equals("R")) {
            Player player = new Player();
            Move playerMove = player.makeSelection(userInput);

            Computer computer = new Computer();
            Move computerMove = computer.makeSelection();

            Winner winner = computeWin(playerMove,computerMove);


            System.out.println("Your move:"+ playerMove);
            System.out.println("Computers move:"+ computerMove);
            switch(winner){
                case TIE:
                    System.out.println("Its a tie");
                    break;
                case PLAYER:
                    System.out.printf("Congratulations you won");
                    break;
                case COMPUTER:
                    System.out.println("Better luck next time");
                    break;
            }
        }
        else{
            System.out.println("Invalid selection. please try again");
        }
    }

    public static Winner computeWin(Move playerMove, Move computerMove){
        Winner winner;

        if(playerMove == computerMove){
            winner = Winner.TIE;
        }
        else if(playerMove == Move.ROCK && computerMove == Move.SCISSOR){
            winner = Winner.PLAYER;
        }
        else if(playerMove == Move.SCISSOR && computerMove == Move.PAPER){
            winner = Winner.PLAYER;
        }
        else if(playerMove == Move.PAPER && computerMove == Move.ROCK){
            winner = Winner.PLAYER;
        }
        else{
            winner = Winner.COMPUTER;
        }
        return winner;
    }
}
