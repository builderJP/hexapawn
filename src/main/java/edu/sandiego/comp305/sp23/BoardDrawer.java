package edu.sandiego.comp305.sp23;

/**
 * This class provides a method for drawing an ASCII representation of a Hexapawn game board during any state of the game.
 * The board is 15 characters wide (not including non-printing characters such as \n) and 9 characters tall.
 * Each square of the Hexapawn board is 5 characters wide and 3 characters tall.
 * Black squares are made with colons while white squares use empty characters/spaces.
 * Black pawns have a pound sign in the base of their piece, while white pawns have their pawn ID in the base of their piece.
 * @author JP Tasto
 */
public class BoardDrawer{

    private Pawn[][] hexapawnBoard;
    private final boolean[][] isBlackTile = { {true, false, true}, {false, true, false}, {true, false, true} };

    /**
     * Default constructor for BoardDrawer.
     */
    public BoardDrawer(){}

    /**
     * Constructs an ASCII representation of a Hexapawn board.
     * @param hexapawnBoard A 2D array representing the current state of game of the Hexapawn board.
     * @return An ASCII representation of the game board provided as a parameter.
     */
    public String drawBoard(Pawn[][] hexapawnBoard){
        this.hexapawnBoard = hexapawnBoard;
        StringBuilder outputBoard = new StringBuilder(144);
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

