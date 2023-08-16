package edu.sandiego.comp305.sp23;

public class HexapawnBlackGameTree{

    HexapawnBlackGameTree(){}

    /**
     * Returns String in following regex format: "-?[0-9]+|[am][we]?"
     * before the | is the pawnID
     * a = attack -> means that w or e follows to indicate direction of attack
     * m = move forward
     * @param hexapawnBoard
     * @return
     */
    public String getBestMove(Pawn[][] hexapawnBoard){
        return "";
    }

    private String boardToString(Pawn[][] hexapawnBoard){
        StringBuilder boardAsString = new StringBuilder();

        for(int curRowIndex = 0; curRowIndex < 3; curRowIndex++){
            for(int curColumnIndex = 0; curColumnIndex < 3; curColumnIndex++){
                switch(hexapawnBoard[curRowIndex][curColumnIndex].getType()){
                    case BLACK -> boardAsString.append("B");
                    case WHITE -> boardAsString.append("W");
                    default -> boardAsString.append(" ");
                }
            }
        }

        return boardAsString.toString();
    }

}
