package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Pawn
 * @author JP Tasto
 */
class PawnTest{

    /**
     * Tests the equality of two Pawn objects that have the same type and pawn ID.
     */
    @Test
    void testEquals(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Pawn otherPawn = new Pawn(PawnTypes.BLACK, -2);

        assertEquals(pawn, otherPawn);
    }

    /**
     * Tests inequality of two Pawn objects that have different types and pawn IDs.
     */
    @Test
    void testNotEqual(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Pawn otherPawn = new Pawn(PawnTypes.WHITE, 1);

        assertNotEquals(pawn, otherPawn);
    }

    /**
     * Tests comparison of a Pawn object with an object of a different type.
     */
    @Test
    void testCompareToNonPawn(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Integer notAPawn = 1;

        assertNotEquals(pawn, notAPawn);
    }
}