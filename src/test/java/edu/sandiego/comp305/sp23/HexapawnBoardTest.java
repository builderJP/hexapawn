package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HexapawnBoardTest{

    private static HexapawnBoard board;

    @BeforeAll
    public static void createHexapawnBoard(){
        board = new HexapawnBoard();
    }

    @Test
    void resetBoard(){
        board.resetBoard();

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals(expectedOutput, board.getBoard());
    }

    @Test
    void moveWhite(){
        board.resetBoard();
        board.move(1);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals(expectedOutput, board.getBoard());
    }

    @Test
    void moveBlack(){
        board.resetBoard();
        board.move(-3);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.WHITE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 1), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals(expectedOutput, board.getBoard());
    }

    @Test
    void whiteAttack(){
        board.resetBoard();
        board.move(-2);
        board.attack(1, false);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 1), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals(expectedOutput, board.getBoard());
    }

    @Test
    void blackAttack(){
        board.resetBoard();
        board.move(1);
        board.attack(-2,true);

        Pawn[][] expectedOutput = {
                {new Pawn(PawnTypes.BLACK, -1), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLACK, -3)},
                {new Pawn(PawnTypes.BLACK, -2), new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.BLANK_SPACE, 0)},
                {new Pawn(PawnTypes.BLANK_SPACE, 0), new Pawn(PawnTypes.WHITE, 2), new Pawn(PawnTypes.WHITE, 3)} };

        assertEquals(expectedOutput, board.getBoard());
    }

    @Test
    void winnerExistsStalemate(){
        board.resetBoard();
        board.move(1);
        board.attack(-2,true);
        board.attack(2, true);
        board.move(-3);

        assertEquals(StatesOfGame.BLACK_WON, board.doesWinnerExist(true));
    }

    @Test
    void winnerExistsWhiteWon(){
        board.resetBoard();
        board.move(2);
        board.move(-1);
        board.attack(2, false);

        assertEquals(StatesOfGame.WHITE_WON, board.doesWinnerExist(true));
    }

    @Test
    void winnerExistsBlackWon(){
        board.resetBoard();
        board.move(3);
        board.attack(-2, false);
        board.move(1);
        board.attack(-3, true);

        assertEquals(StatesOfGame.BLACK_WON, board.doesWinnerExist(true));

    }

    @Test
    void winnerDoesNotExist(){
        board.resetBoard();
        board.move(2);

        assertEquals(StatesOfGame.NO_WINNER, board.doesWinnerExist(true));
    }
}