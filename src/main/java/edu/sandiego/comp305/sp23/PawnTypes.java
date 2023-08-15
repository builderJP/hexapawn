package edu.sandiego.comp305.sp23;

/**
 * Types of pieces in Hexapawn, but can be but can be applied to other games, such as chess.
 * @author JP Tasto
 */
public enum PawnTypes{
    WHITE, BLACK,

    /**
     * My implementation of Hexapawn utilizes an array of Pawn objects, so some Pawn objects are actually blank spaces.
     * BLANK_SPACE exists to help me keep track of which places on the board aren't occupied.
     */
    BLANK_SPACE
}

