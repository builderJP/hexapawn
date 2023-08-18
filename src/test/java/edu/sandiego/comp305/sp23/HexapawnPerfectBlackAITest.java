package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for HexapawnPerfectBlackAI
 * Author: JP Tasto
 */
class HexapawnPerfectBlackAITest{

    private static HexapawnPerfectBlackAI hexapawnGame;

    /**
     * Creates a new HexapawnPerfectBlackAI instance before all test methods are executed.
     */
    @BeforeAll
    public static void createBlackGameTree(){
        hexapawnGame = new HexapawnPerfectBlackAI();
    }

    /**
     * Resets the board before each test method is executed.
     */
    @BeforeEach
    public void resetBoard(){
        hexapawnGame.hexapawnBoard.resetBoard();
    }

    /**
     * Tests to see if the black AI properly responds to the leftmost white pawn moving as white's first move.
     * The expected response of the black AI is verified against the resulting game board.
     */
    @Test
    void blackDoBestMove(){
        Pawn[][] properResponseToLeftWhitePawnMove = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        hexapawnGame.hexapawnBoard.move(1);
        hexapawnGame.blackDoBestMove();

        assertArrayEquals(properResponseToLeftWhitePawnMove, hexapawnGame.hexapawnBoard.getBoard());
    }

    /**
     * Tests whether the game board remains unchanged when the black AI's optimal move is not in the game tree.
     * The game board's initial state is compared with the board after the black AI's (lack of doing a) move.
     */
    @Test
    void emptyStringForBoardsNotInGameTree(){
        Pawn[][] initialBoard = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        hexapawnGame.blackDoBestMove();

        assertArrayEquals(initialBoard, hexapawnGame.hexapawnBoard.getBoard());
    }
}