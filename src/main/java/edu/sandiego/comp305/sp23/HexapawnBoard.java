package edu.sandiego.comp305.sp23;

public class HexapawnBoard{
    private Pawn[][] board = new Pawn[3][3];

    HexapawnBoard(){

    }

    protected void move(int pawnID){

    }

    protected void attack(int pawnID, boolean isAttackingWestward){

    }

    protected StatesOfGame doesWinnerExist(boolean isPlayersTurn){
        return StatesOfGame.NO_WINNER;
    }

    protected void resetBoard(){

    }

    protected Pawn[][] getBoard(){
        return null;
    }

}
