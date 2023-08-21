package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for HexapawnWhitePlayerPromptsTest
 * @author JP Tasto
 */
class HexapawnWhitePlayerPromptsTest{

    private static HexapawnWhitePlayerPrompts whitePlayer;

    /**
     * Creates a new HexapawnWhitePlayerPrompts instance before all test methods are executed.
     */
    @BeforeAll
    public static void createBlackGameTree(){
        whitePlayer = new HexapawnWhitePlayerPrompts();
    }

    /**
     * Resets the board before each test method is executed.
     */
    @BeforeEach
    public void resetBoard(){
        whitePlayer.hexapawnBoard.resetBoard();
    }

    /**
     * Tests whether the generated prompt matches the expected output for the initial game board configuration.
     */
    @Test
    void whiteCorrectPrompts(){
        Pawn[][] board = whitePlayer.hexapawnBoard.getBoard();

        String expectedOutput = "1) Move Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][1].getPawnID() +
                                "\n3) Move Pawn " + board[2][2].getPawnID() + "\n";

        assertEquals(expectedOutput, whitePlayer.getWhitePlayerPrompts());
    }

    /**
     * Tests whether an empty string is returned when the game board is not in the list of game board states if black plays perfectly.
     * This specific example is for a game board state where it is black's turn to play.
     */
    @Test
    void emptyStringForBoardsNotInGameTree(){
        Pawn[][] board = whitePlayer.hexapawnBoard.getBoard();
        whitePlayer.hexapawnBoard.move(board[2][2].getPawnID());

        assertEquals("", whitePlayer.getWhitePlayerPrompts());
    }
}