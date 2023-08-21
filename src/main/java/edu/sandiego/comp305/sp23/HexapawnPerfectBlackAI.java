package edu.sandiego.comp305.sp23;

/**
 * This class provides an implementation of a perfect black player AI for the Hexapawn game.
 * This AI player makes optimal moves based on the current configuration of the game board.
 * The class analyzes the current state of the board and performs the best possible move for the black player.
 * @author JP Tasto
 */
public class HexapawnPerfectBlackAI{

    protected HexapawnBoard hexapawnBoard;

    /**
     * Constructs a new instance of the HexapawnPerfectBlackAI class.
     * Initializes the class with a new instance of the HexapawnBoard class.
     */
    public HexapawnPerfectBlackAI(){
        this.hexapawnBoard = new HexapawnBoard();
    }

    /**
     * Constructs a new instance of the HexapawnPerfectBlackAI class.
     * Initializes the class with a preexisting instance of the HexapawnBoard class.
     * @param hexapawnBoard The preexisting HexapawnBoard instance
     */
    public HexapawnPerfectBlackAI(HexapawnBoard hexapawnBoard){
        this.hexapawnBoard = hexapawnBoard;
    }

    /**
     * Analyzes the current game board configuration and makes the best move for the black player.
     * This method determines the optimal move black can make based on the current state of the game,
     * and executes the chosen move on the game board.
     */
    public void blackDoBestMove(){
        Pawn[][] board = this.hexapawnBoard.getBoard();
        
        switch(this.hexapawnBoard.toString()){
            //White moves leftmost pawn as first move
            case "BBBW   WW" -> hexapawnBoard.attack(board[0][1].getPawnID(), true);
            //Below are responses to the possible moves white can do after black responds to their initial move
            case "B BW    W" -> hexapawnBoard.move(board[0][2].getPawnID());
            case "B BBW   W", "B BB W W " -> hexapawnBoard.move(board[1][0].getPawnID());

            //White moves middle pawn as first move
            case "BBB W W W" -> hexapawnBoard.attack(board[0][2].getPawnID(), true);
            //Below are responses to possible moves white can do after black responds to their initial move
            case "BB WB   W", "BB  BWW  " -> hexapawnBoard.move(board[1][1].getPawnID());
            case "BB  W W  ", "BB  W   W" -> hexapawnBoard.move(board[0][0].getPawnID());
            case " B BWW   " -> hexapawnBoard.move(board[1][0].getPawnID());

            //White moves rightmost pawn as first move
            case "BBB  WWW " -> hexapawnBoard.attack(board[0][1].getPawnID(), false);
            //Below are responses to possible moves white can do after black responds to their initial move
            case "B B  WW  " -> hexapawnBoard.move(board[0][0].getPawnID());
            case "B BW B W ", "B B WBW  " -> hexapawnBoard.move(board[1][2].getPawnID());
        }
    }
}
