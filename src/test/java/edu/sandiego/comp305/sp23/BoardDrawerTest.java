package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for BoardDrawer
 * @author JP Tasto
 */
class BoardDrawerTest{
    private static BoardDrawer boardDrawer;
    private static HexapawnBoard hexapawnBoard;

    /**
     * Creates a new BoardDrawer instance before all test methods are executed.
     */
    @BeforeAll
    public static void createBoardDrawer(){
        hexapawnBoard = new HexapawnBoard();
        boardDrawer = new BoardDrawer();
    }

    /**
     * Tests the construction of a Hexapawn board with no pieces on it.
     */
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

        assertEquals(expectedOutcome, boardDrawer.drawBoard(blankBoard));
    }

    /**
     * Tests the construction of a Hexapawn board in the initial configuration, with white pawn on the bottommost row.
     */
    @Test
    void drawStartingBoard(){
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

        assertEquals(expectedOutcome, boardDrawer.drawBoard(hexapawnBoard.getBoard()));
    }

    /**
     * Tests the construction of a Hexapawn board with Pawns in various
     */
    @Test
    void drawBoardOddConfiguration(){
        Pawn[][] midGameBoard = {
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

        assertEquals(expectedOutcome, boardDrawer.drawBoard(midGameBoard));
    }
}