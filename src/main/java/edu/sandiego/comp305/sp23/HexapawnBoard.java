package edu.sandiego.comp305.sp23;

import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Hexapawn board in the form of a 2D Array of Pawn objects.
 * It provides methods for moving and attacking pawns, checking for a winner or stalemate,
 * and resetting the board to its initial state.
 * The methods in this class assume that all Pawn objects (that aren't blank spaces) have different pawnIDs.
 * @author JP Tasto
 */
public class HexapawnBoard{
    private Pawn[][] board;

    /**
     * Constructs a new HexapawnBoard with the initial configuration of pawns:
     * white pawns on the bottommost row and black pawns on the topmost row.
     */
    public HexapawnBoard(){
        this.resetBoard();
    }

    /**
     * Moves a pawn with the specified ID forward.
     * It is assumed that the move is valid (i.e. the space in front of this pawn is empty).
     *
     * @param pawnID The identification number of the pawn to be moved.
     */
    public void move(int pawnID){
        int[] positionOfPawn = getPawnPosition(pawnID);

        //Below only executes if we found a pawn of the specified pawnID
        if(positionOfPawn.length == 2){
            int prevRow = positionOfPawn[0];
            int prevColumn = positionOfPawn[1];
            Pawn targetPawn = removePawn(positionOfPawn);

            //Moves pawn up or down according to its direction
            if(targetPawn.getDirection() == Directions.UPWARDS){
                this.board[prevRow - 1][prevColumn] = new Pawn(targetPawn);
            } else{
                this.board[prevRow + 1][prevColumn] = new Pawn(targetPawn);
            }
        }
    }

    /**
     * Makes the pawn with the specified ID attack one of its forwards diagonals.
     * It is assumed that the attack is valid (i.e. the forward diagonal tile it is attacking has an enemy pawn on it).
     *
     * @param pawnID The identification number of the attacking pawn.
     * @param isAttackingWestward True if the attack is westward, false if it is eastward.
     *                            West & East are used as left & right depend on what
     *                            end/side of the board you are viewing the board from.
     */
    public void attack(int pawnID, boolean isAttackingWestward){
        int[] positionOfPawn = getPawnPosition(pawnID);

        //Below only executes if we found a pawn of the specified pawnID
        if(positionOfPawn.length == 2){
            int prevRow = positionOfPawn[0];
            int prevColumn = positionOfPawn[1];
            Pawn targetPawn = removePawn(positionOfPawn);

            if(targetPawn.getDirection() == Directions.UPWARDS){
                if(isAttackingWestward){
                    this.board[prevRow - 1][prevColumn - 1] = new Pawn(targetPawn);
                } else{
                    this.board[prevRow - 1][prevColumn + 1] = new Pawn(targetPawn);
                }
            } else{
                if(isAttackingWestward){
                    this.board[prevRow + 1][prevColumn - 1] = new Pawn(targetPawn);
                } else{
                    this.board[prevRow + 1][prevColumn + 1] = new Pawn(targetPawn);
                }
            }
        }
    }

    /**
     * Checks if a winner exists (either via reaching the other side of the board or stalemate) or if there's no winner.
     *
     * @param isWhitesTurn True if it's the white player's turn, false for if it's black player's turn.
     * @return The state of the game (BLACK_WON, WHITE_WON, NO_WINNER).
     */
    public StatesOfGame doesWinnerExist(boolean isWhitesTurn){
        //Covers cases of winning by reaching other end of board
        for(int i = 0; i < this.board.length; i++){
            if(this.board[0][i].getDirection() == Directions.UPWARDS){

                if(this.board[0][i].getType() == PawnTypes.WHITE){
                    return StatesOfGame.WHITE_WON;
                } else{
                    return StatesOfGame.BLACK_WON;
                }
            }

            if(this.board[2][i].getDirection() == Directions.DOWNWARDS){

                if(this.board[2][i].getType() == PawnTypes.WHITE){
                    return StatesOfGame.WHITE_WON;
                } else{
                    return StatesOfGame.BLACK_WON;
                }
            }
        }


        boolean inStalemate = true;
        PawnTypes opponentsPawnColor;
        //Checks to see if the match is not in a stalemate
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j].getDirection() == Directions.UPWARDS){
                    //Checks if this pawn can move forwards (upwards)
                    if(isInBounds(i - 1,j) && this.board[i - 1][j].getType() == PawnTypes.BLANK_SPACE){
                        inStalemate = false;
                        break;
                    }

                    opponentsPawnColor = getOpponentsColor(this.board[i][j]);
                    //Checks if pawns to either forward diagonal are enemy pawns (there is a valid move available)
                    if((isInBounds(i - 1, j - 1) && this.board[i - 1][j - 1].getType() == opponentsPawnColor) || // Checks if NW pawn is enemy pawn
                        (isInBounds(i - 1, j + 1) && this.board[i - 1][j + 1].getType() == opponentsPawnColor)){ //Checks if NE pawn is enemy pawn
                        inStalemate = false;
                        break;
                    }

                } else if(this.board[i][j].getDirection() == Directions.DOWNWARDS){
                    //Checks if this pawn can move forwards (downwards)
                    if(isInBounds(i + 1,j) && this.board[i + 1][j].getType() == PawnTypes.BLANK_SPACE){
                        inStalemate = false;
                        break;
                    }

                    opponentsPawnColor = getOpponentsColor(this.board[i][j]);
                    //Checks if pawns to either forward diagonal are enemy pawns (there is a valid move available)
                    if((isInBounds(i + 1, j - 1) && this.board[i + 1][j - 1].getType() == opponentsPawnColor) || // Checks if SW pawn is enemy pawn
                            (isInBounds(i + 1, j + 1) && this.board[i + 1][j + 1].getType() == opponentsPawnColor)){ //Checks if SE pawn is enemy pawn
                        inStalemate = false;
                        break;
                    }
                }
            }
        }

        if(inStalemate){
            if(isWhitesTurn){
                return StatesOfGame.BLACK_WON;
            } else{
                return StatesOfGame.WHITE_WON;
            }
        }

        return StatesOfGame.NO_WINNER;
    }

    /**
     * Resets the board to the initial/following configuration of pawns:
     * white pawns on the bottommost row and black pawns on the topmost row.
     * The numbering system used for IDing the pawns is to number them 1 to 3, from West to East,
     * giving negative numbers to black and positive numbers to white.
     */
    public void resetBoard(){
        this.board = new Pawn[][]{
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };
    }

    /**
     * Returns a string representation of the current state of the game board.
     * The Hexapawn game board is turned into a nine-character string,
     * where each set of three characters represents a row of the board.
     * 'B' stands for a black pawn, 'W' stands for a white pawn, and space (' ') stands for an empty square.
     *
     * @return A string representation of the current state of the game board.
     */
    @Override
    public String toString(){
        StringBuilder boardAsString = new StringBuilder();

        for(int curRowIndex = 0; curRowIndex < 3; curRowIndex++){
            for(int curColumnIndex = 0; curColumnIndex < 3; curColumnIndex++){
                switch(board[curRowIndex][curColumnIndex].getType()){
                    case BLACK -> boardAsString.append("B");
                    case WHITE -> boardAsString.append("W");
                    default -> boardAsString.append(" ");
                }
            }
        }

        return boardAsString.toString();
    }

    public Pawn[][] getBoard(){
        return this.board;
    }

    protected int[] getPawnPosition(int pawnID){
        int[] positionOfPawn;
        int row = -1;
        int column = -1;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j].getPawnID() == pawnID){
                    row = i;
                    column = j;
                    break;
                }
            }
        }

        if(row != -1){
            positionOfPawn = new int[]{row, column};
        } else{
            positionOfPawn = new int[]{};
        }

        return positionOfPawn;
    }

    private @NotNull Pawn removePawn(int[] positionOfPawn){
        int row = positionOfPawn[0];
        int column = positionOfPawn[1];
        Pawn targetPawn = new Pawn(this.board[row][column]);

        //Previous position gets converted to a blank space since pawn is being moved
        this.board[row][column] = new Pawn(PawnTypes.BLANK_SPACE, 0);

        return targetPawn;
    }

    private boolean isInBounds(int targetRow, int targetColumn){
        return (-1 < targetRow && targetRow < 3) && (-1 < targetColumn &&  targetColumn < 3);
    }

    private PawnTypes getOpponentsColor(Pawn targetPawn){
        if(targetPawn.getType() == PawnTypes.WHITE){
            return PawnTypes.BLACK;
        } else{
            return PawnTypes.WHITE;
        }

    }
}
