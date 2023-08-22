package edu.sandiego.comp305.sp23;

/**
 * This class provides all possible prompts for the white player in a Hexapawn game where the black player plays perfectly.
 * The possible moves white can make are dependent on the current state of the game board and a list of these possible moves are returned in the String.
 * @author JP Tasto
 */
public class HexapawnWhitePlayerPrompts{

    protected HexapawnBoard hexapawnBoard;

    /**
     * Constructs a new instance of the HexapawnWhitePlayerPrompts class.
     * Initializes the class with a new instance of the HexapawnBoard class.
     */
    public HexapawnWhitePlayerPrompts(){
        this.hexapawnBoard = new HexapawnBoard();
    }

    /**
     * Constructs a new instance of the HexapawnWhitePlayerPrompts class.
     * Initializes the class with a preexisting instance of the HexapawnBoard class.
     * @param hexapawnBoard The preexisting HexapawnBoard instance
     */
    public HexapawnWhitePlayerPrompts(HexapawnBoard hexapawnBoard){
        this.hexapawnBoard = hexapawnBoard;
    }

    /**
     * Generates prompts for the white player's possible moves based on the current state of the game board. The list of
     * game board variations are the ones that exist if black plays perfectly. The prompts are returned as a formatted string.
     * If the game board state isn't in the list of states that exist if black plays perfectly, an empty String is returned.
     * @return A String with prompts for the white player's possible moves. Is empty if the game board state is not in the
     *          list of game board states if black plays perfectly.
     */
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
                        "\n3) Attack northwestward with Pawn " + board[2][2].getPawnID() + "\n4) Move Pawn " + board[2][2].getPawnID() + "\n";
            }
            case " B BW   W" -> {
                return "1) Move Pawn " + board[2][2].getPawnID() + "\n";
            }
            case "B B  BWW " -> {
                return "1) Move Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][1].getPawnID() +
                        "\n3) Attack northeastward with Pawn " + board[2][1].getPawnID() + "\n";
            }
            default -> {
                return "";
            }
        }
    }
}
