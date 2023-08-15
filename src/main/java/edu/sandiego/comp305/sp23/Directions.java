package edu.sandiego.comp305.sp23;

/**
 * Directions that a pawn in Hexapawn can move in, but can be applied/expanded on to be used in other games.
 * @author JP Tasto
 */
public enum Directions{
    UPWARDS, DOWNWARDS,

    /**
     * My implementation of Hexapawn utilizes an array of Pawn objects, so some Pawn objects are actually blank spaces.
     * BLANK_SPACE exists to help me keep track of which places on the board aren't occupied.
     */
    BLANK_SPACE
}
