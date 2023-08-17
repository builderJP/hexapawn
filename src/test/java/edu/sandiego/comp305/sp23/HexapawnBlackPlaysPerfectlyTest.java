package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexapawnBlackPlaysPerfectlyTest{

    private static HexapawnBlackPlaysPerfectly hexapawnGame;

    @BeforeAll
    public static void createBlackGameTree(){
        hexapawnGame = new HexapawnBlackPlaysPerfectly();
    }

    /**
     * Resets the board before each test method is executed.
     */
    @BeforeEach
    public void resetBoard(){
        hexapawnGame.hexapawnBoard.resetBoard();
    }

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