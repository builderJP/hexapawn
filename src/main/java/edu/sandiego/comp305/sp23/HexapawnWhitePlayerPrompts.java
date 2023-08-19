package edu.sandiego.comp305.sp23;

public class HexapawnWhitePlayerPrompts{

    protected HexapawnBoard hexapawnBoard;

    HexapawnWhitePlayerPrompts(){
        this.hexapawnBoard = new HexapawnBoard();
    }

    public String getWhitePlayerPrompts(){
        Pawn[][] board = this.hexapawnBoard.getBoard();

        switch(this.hexapawnBoard.toString()){
            case "BBB   WWW" -> {
                return "1) Move Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][1].getPawnID() +
                        "\n3) Move Pawn " + board[2][2].getPawnID() + "\n";
            }
            case "B BB   WW" -> {
                return "1) Attack northwestward with Pawn " + board[2][1].getPawnID() + "\n2) Move Pawn "
                        + board[2][1].getPawnID() + "\n3) Move Pawn " + board[2][2].getPawnID() + "\n";
            }
            case "BB  B W W" -> {
                return "1) Attack northeastward with Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][0].getPawnID() +
                        "3) Attack northwestward with Pawn " + board[2][2].getPawnID() + "\n4) Move Pawn " + board[2][2].getPawnID() + "\n";
            }
            case " B BW   W" -> {
                return "1) Move Pawn " + board[2][2].getPawnID();
            }
            case "B B  BWW " -> {
                return "1) Move Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][1].getPawnID() +
                        "3) Attack northeastward with Pawn " + board[2][1].getPawnID() + "\n";
            }
            default -> {
                return "";
            }
        }
    }
}
