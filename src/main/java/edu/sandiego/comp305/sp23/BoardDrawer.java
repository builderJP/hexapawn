package edu.sandiego.comp305.sp23;

/**
 * Black Pawn
 *
 *    _
 *  _(#)_
 * White (Player) Pawns
 *
 *    _    _    _
 *  _(1)__(2)__(3)_
 *
 * Board
 *  :::::     :::::
 *  :::::     :::::
 *  :::::     :::::
 *       :::::
 *       :::::
 *       :::::
 *  :::::     :::::
 *  :::::     :::::
 *  :::::     :::::
 *
 * Starting Board
 *  :::::     :::::
 *  : _ :  _  : _ :
 *  _(#)__(#)__(#)_
 *       :::::
 *       :::::
 *       :::::
 *  :::::     :::::
 *  : _ :  _  : _ :
 *  _(1)__(2)__(3)_
 *
 *  ppp
 *   .
 *  123
 *
 *  . .
 *   .
 *  . .
 */
public class BoardDrawer{

    private Pawn[][] hexapawnBoard;
    private final boolean[][] isBlackTile = { {true, false, true}, {false, true, false}, {true, false, true} };

    public BoardDrawer(){
        //Do we need a constructor???
    }

    public String drawBoard(Pawn[][] hexapawnBoard){
        this.hexapawnBoard = hexapawnBoard;
        StringBuilder outputBoard = new StringBuilder();
        PawnTypes[] curRow;

        //Goes through each row of the Hexapawn board
        for (int curRowIndex = 0; curRowIndex < 3; curRowIndex++){
            curRow = new PawnTypes[3];

            //Gets the types of each Pawn object in the current row
            for(int curColumnIndex = 0; curColumnIndex < 3; curColumnIndex++){
                curRow[curColumnIndex] = this.hexapawnBoard[curRowIndex][curColumnIndex].getType();
            }

            //Draws a third of the current row with each iteration
            for(int curLine = 0; curLine < 3; curLine++){

                //For each square in this current row...
                for(int curColumnIndex = 0; curColumnIndex < 3; curColumnIndex++){
                    switch(curRow[curColumnIndex]){
                        case BLACK, WHITE -> outputBoard.append(drawPawn(curLine, curRowIndex, curColumnIndex, curRow[curColumnIndex]));
                        case BLANK_SPACE -> outputBoard.append(drawEmptySquare(curRowIndex, curColumnIndex));
                    }
                }

                outputBoard.append("\n");
            }
        }

        return outputBoard.toString();
    }

    private String drawPawn(int curLine, int curRowIndex, int curColumnIndex, PawnTypes pawnType){
        if(curLine == 0){
            return drawEmptySquare(curRowIndex, curColumnIndex);

        } else if(curLine == 1){
            String marginalChar;
            if(isBlackTile[curRowIndex][curColumnIndex]){
                marginalChar = ":";
            } else{
                marginalChar = " ";
            }

            return marginalChar + " _ " + marginalChar;

        } else{ //curLine == 2
            String charInsidePawn = "#";
            if(pawnType == PawnTypes.WHITE){
                charInsidePawn = Integer.toString(this.hexapawnBoard[curRowIndex][curColumnIndex].getPawnID());
            }

            return "_(" +  charInsidePawn + ")_";
        }
    }

    private String drawEmptySquare(int curRowIndex, int curColumnIndex){
        if(isBlackTile[curRowIndex][curColumnIndex]){
            return ":::::";
        } else{
            return "     ";
        }
    }
}

