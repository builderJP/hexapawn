package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardDrawerTest{

    @Test
    void drawBlankBoard(){
        Pawn[][] blankBoard = {
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)} };

        String expectedOutcome = """
                :::::     :::::
                :::::     :::::
                :::::     :::::
                     :::::    \s
                     :::::    \s
                     :::::    \s
                :::::     :::::
                :::::     :::::
                :::::     :::::
                """;

        assertEquals(expectedOutcome, BoardDrawer.drawBoard(blankBoard));
    }

    @Test
    void drawStartingBoard(){
        Pawn[][] blankBoard = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        String expectedOutcome = """
                :::::     :::::
                : _ :  _  : _ :
                _(#)__(#)__(#)_
                     :::::    \s
                     :::::    \s
                     :::::    \s
                :::::     :::::
                : _ :  _  : _ :
                _(1)__(2)__(3)_
                """;

        assertEquals(expectedOutcome, BoardDrawer.drawBoard(blankBoard));
    }

    @Test
    void drawBoardOddConfiguration(){
        Pawn[][] blankBoard = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)} };

        String expectedOutcome = """
                :::::     :::::
                : _ :     :::::
                _(#)_     :::::
                     :::::    \s
                  _  : _ :  _ \s
                _(#)__(2)__(3)_
                :::::     :::::
                : _ :     : _ :
                _(1)_     _(#)_
                """;

        assertEquals(expectedOutcome, BoardDrawer.drawBoard(blankBoard));
    }
}