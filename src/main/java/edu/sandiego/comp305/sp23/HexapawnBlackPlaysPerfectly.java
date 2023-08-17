package edu.sandiego.comp305.sp23;

public class HexapawnBlackPlaysPerfectly{

    protected HexapawnBoard hexapawnBoard;

    HexapawnBlackPlaysPerfectly(){
        hexapawnBoard = new HexapawnBoard();
    }

    //This will just interact with the hexapawnBoard
    public void blackDoBestMove(){
        switch(boardToString()){
            //White moves leftmost pawn as first move
            case "BBBW   WW" -> hexapawnBoard.attack(hexapawnBoard.getBoard()[0][1].getPawnID(), true);
            //Below are responses to the possible moves white can do after black responds to their initial move
            case "B BW    W" -> hexapawnBoard.move(hexapawnBoard.getBoard()[0][2].getPawnID());
            case "B BBW   W", "B BB W W " -> hexapawnBoard.move(hexapawnBoard.getBoard()[1][0].getPawnID());

            //White moves middle pawn as first move
            case "BBB W W W" -> hexapawnBoard.attack(hexapawnBoard.getBoard()[0][2].getPawnID(), true);
            //Below are responses to possible moves white can do after black responds to their initial move
            case "BB WB   W", "BB  BWW  " -> hexapawnBoard.move(hexapawnBoard.getBoard()[1][1].getPawnID());
            case "BB  W W  ", "BB  W   W" -> hexapawnBoard.move(hexapawnBoard.getBoard()[0][0].getPawnID());
            case " B BWW   " -> hexapawnBoard.move(hexapawnBoard.getBoard()[1][0].getPawnID());

            //White moves rightmost pawn as first move
            case "BBB  WWW " -> hexapawnBoard.attack(hexapawnBoard.getBoard()[0][1].getPawnID(), false);
            //Below are responses to possible moves white can do after black responds to their initial move
            case "B B  WW  " -> hexapawnBoard.move(hexapawnBoard.getBoard()[0][0].getPawnID());
            case "B BW B W ", "B B WBW  " -> hexapawnBoard.move(hexapawnBoard.getBoard()[1][2].getPawnID());
        }
    }

    private String boardToString(){
        StringBuilder boardAsString = new StringBuilder();

        for(int curRowIndex = 0; curRowIndex < 3; curRowIndex++){
            for(int curColumnIndex = 0; curColumnIndex < 3; curColumnIndex++){
                switch(hexapawnBoard.getBoard()[curRowIndex][curColumnIndex].getType()){
                    case BLACK -> boardAsString.append("B");
                    case WHITE -> boardAsString.append("W");
                    default -> boardAsString.append(" ");
                }
            }
        }

        return boardAsString.toString();
    }
}
