package edu.sandiego.comp305.sp23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest{

    @Test
    void testEquals(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Pawn otherPawn = new Pawn(PawnTypes.BLACK, -2);

        assertEquals(pawn, otherPawn);
    }

    @Test
    void testNotEqual(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Pawn otherPawn = new Pawn(PawnTypes.WHITE, 1);

        assertNotEquals(pawn, otherPawn);
    }

    @Test
    void testCompareToNonPawn(){
        Pawn pawn = new Pawn(PawnTypes.BLACK, -2);
        Integer notAPawn = 1;

        assertNotEquals(pawn, notAPawn);
    }
}