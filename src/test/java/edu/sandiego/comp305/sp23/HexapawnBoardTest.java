package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for HexapawnBoard
 * @author JP Tasto
 */
class HexapawnBoardTest{

    private static HexapawnBoard board;

    /**
     * Creates a new HexapawnBoard instance before all test methods are executed.
     */
    @BeforeAll
    public static void createHexapawnBoard(){
        board = new HexapawnBoard();
    }

    /**
     * Resets the board before each test method is executed.
     */
    @BeforeEach
    public void resetBoard(){
        board.resetBoard();
    }

    /**
     * Tests the functionality of resetting the board to its initial configuration (i.e. tests the resetBoard() method).
     */
    @Test
    void resetBoardTester(){
        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertArrayEquals(expectedOutput, board.getBoard());
    }

    /**
     * Tests moving a white pawn.
     */
    @Test
    void moveWhite(){
        board.move(1);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertArrayEquals(expectedOutput, board.getBoard());
    }

    /**
     * Tests moving a black pawn.
     */
    @Test
    void moveBlack(){
        board.move(-3);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertArrayEquals(expectedOutput, board.getBoard());
    }

    /**
     * Tests a white pawn attacking a black pawn.
     */
    @Test
    void whiteAttack(){
        board.move(-2);
        board.attack(1, false);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertArrayEquals(expectedOutput, board.getBoard());
    }

    /**
     * Tests a black pawn attacking a white pawn.
     */
    @Test
    void blackAttack(){
        board.move(1);
        board.attack(-2,true);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertArrayEquals(expectedOutput, board.getBoard());
    }

    /**
     * Tests the existence of a winner, black being said winner in this scenario, in the case of a stalemate.
     */
    @Test
    void winnerExistsStalemate(){
        board.move(1);
        board.attack(-2,true);
        board.attack(2, true);
        board.move(-3);

        assertEquals(StatesOfGame.BLACK_WON, board.doesWinnerExist(true));
    }

    /**
     * Tests the existence of a winner, white being said winner, in the case of white reaching the other side of the board.
     */
    @Test
    void winnerExistsWhiteWon(){
        board.move(2);
        board.move(-1);
        board.attack(2, false);

        assertEquals(StatesOfGame.WHITE_WON, board.doesWinnerExist(true));
    }

    /**
     * Tests the existence of a winner, black being said winner, in the case of black reaching the other side of the board.
     */
    @Test
    void winnerExistsBlackWon(){
        board.move(3);
        board.attack(-2, false);
        board.move(1);
        board.move(-2);

        assertEquals(StatesOfGame.BLACK_WON, board.doesWinnerExist(true));

    }

    /**
     * Tests the absence of a winner in a board that is in a mid-game configuration.
     */
    @Test
    void winnerDoesNotExist(){
        board.move(2);

        assertEquals(StatesOfGame.NO_WINNER, board.doesWinnerExist(true));
    }
}