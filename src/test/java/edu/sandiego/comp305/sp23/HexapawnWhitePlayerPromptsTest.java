package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void whiteCorrectPrompts(){
        Pawn[][] board = whitePlayer.hexapawnBoard.getBoard();

        String expectedOutput = "1) Move Pawn " + board[2][0].getPawnID() + "\n2) Move Pawn " + board[2][1].getPawnID() +
                                "\n3) Move Pawn " + board[2][2].getPawnID() + "\n";

        assertEquals(expectedOutput, whitePlayer.getWhitePlayerPrompts());
    }

    @Test
    void emptyStringForBoardsNotInGameTree(){
        Pawn[][] board = whitePlayer.hexapawnBoard.getBoard();
        whitePlayer.hexapawnBoard.move(board[2][2].getPawnID());

        assertEquals("", whitePlayer.getWhitePlayerPrompts());
    }
}