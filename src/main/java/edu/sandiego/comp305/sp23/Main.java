package edu.sandiego.comp305.sp23;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        System.out.println("Welcome to Hexapawn! Learn more about the game, the rules, what this rendition of the game represents," +
                " and more in the README.md file.\n");

        //Booleans for while loops
        boolean playAgain = true;
        boolean improperInput;
        boolean gameOngoing;

        //Variables/Objects for tracking/playing Hexapawn game
        boolean isWhitesTurn;
        HexapawnBoard board = new HexapawnBoard();
        HexapawnPerfectBlackAI blackAI = new HexapawnPerfectBlackAI(board);
        HexapawnWhitePlayerPrompts playerPrompts = new HexapawnWhitePlayerPrompts(board);
        BoardDrawer boardDrawer = new BoardDrawer();
        StatesOfGame curStateOfGame;

        String curPlayerPrompts;
        String[] listOfCurPrompts;
        String[] usersChosenPrompt;
        String userInput;
        int userCurChoice;
        int curPawnID;

        Scanner scanner = new Scanner(System.in);


        while(playAgain){
            gameOngoing = true;
            board.resetBoard();

            //Game of Hexapawn
            while(gameOngoing){

                isWhitesTurn = true;
                //Checks for a winner after black's turn
                curStateOfGame = board.doesWinnerExist(isWhitesTurn);
                if(curStateOfGame == StatesOfGame.BLACK_WON){
                    System.out.println(boardDrawer.drawBoard(board.getBoard()));
                    System.out.println("Black won!");
                    gameOngoing = false;
                } else if(curStateOfGame == StatesOfGame.WHITE_WON){
                    System.out.println(boardDrawer.drawBoard(board.getBoard()));
                    System.out.println("White won!");
                    gameOngoing = false;
                }
                //Breaks while loop before white's turn if there is a winner
                if(!gameOngoing){
                    break;
                }

                //White's move & confirming user input for white's move
                improperInput = true;
                while(improperInput){
                    //Print board and prompts
                    System.out.println(boardDrawer.drawBoard(board.getBoard()));
                    System.out.println("Enter the number of the move you want to do.");
                    curPlayerPrompts = playerPrompts.getWhitePlayerPrompts();
                    System.out.println(curPlayerPrompts);

                    try{
                        userCurChoice = Integer.parseInt(scanner.nextLine().trim());
                        listOfCurPrompts = curPlayerPrompts.split("\n");
                        System.out.println();

                        //Confirms that a valid number has been chosen (is positive int not greater than num of prompts)
                        if (userCurChoice > 0 && userCurChoice <= listOfCurPrompts.length) {
                            usersChosenPrompt = listOfCurPrompts[userCurChoice - 1].split(" ");

                            if(usersChosenPrompt[1].equalsIgnoreCase("attack")){
                                curPawnID = Integer.parseInt(usersChosenPrompt[5]);
                                board.attack(curPawnID, usersChosenPrompt[2].equalsIgnoreCase("northwestward"));
                            } else{ //Player wants to move a pawn
                                curPawnID = Integer.parseInt(usersChosenPrompt[3]);
                                board.move(curPawnID);
                            }

                            improperInput = false;

                        }else{
                            System.out.println("Your input is invalid, please try again.\n");
                        }
                    } catch(NumberFormatException e){
                        System.out.println("Your input is invalid, please try again.\n");
                    }
                }

                isWhitesTurn = false;
                //Checks for a winner after white's turn
                curStateOfGame = board.doesWinnerExist(isWhitesTurn);
                if(curStateOfGame == StatesOfGame.BLACK_WON){
                    System.out.println("Black won!");
                    gameOngoing = false;
                } else if(curStateOfGame == StatesOfGame.WHITE_WON){
                    System.out.println("White won!");
                    gameOngoing = false;
                } else{ //If game is not over, do black's turn
                    System.out.println(boardDrawer.drawBoard(board.getBoard()));
                    System.out.println("Black will now do it's move.\n");

                    blackAI.blackDoBestMove();
                }
            }

            improperInput = true;
            while(improperInput){
                System.out.println("Would you like to play again?     [Y] or [N]");
                userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("Yes")){
                    playAgain = true;
                    improperInput = false;
                    System.out.println();
                } else if(userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("No")){
                    playAgain = false;
                    improperInput = false;
                    System.out.println();
                    System.out.println("Thank you for playing Hexapawn. Have a good day.");
                } else{
                    System.out.println("Please input a valid response. ([Y] or [N])");
                }
            }
        }
    }
}