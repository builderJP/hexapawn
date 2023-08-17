package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexapawnBlackPerfectGameTreeTest{

    private static HexapawnBlackPerfectGameTree blackAI;

    @BeforeAll
    public static void createBlackGameTree(){
        blackAI = new HexapawnBlackPerfectGameTree();
    }

    @Test
    void getBestMove(){
        Pawn[][] whiteMovesLeftPawn = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals("-2|aw", blackAI.getBestMove(whiteMovesLeftPawn));
    }

    @Test
    void emptyStringForBoardsNotInGameTree(){
        Pawn[][] invalidBoard = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals("", blackAI.getBestMove(invalidBoard));
    }
}