package edu.sandiego.comp305.sp23;

public class Pawn{
    private final Directions direction;
    private final PawnTypes type;
    private final int pawnID;

    Pawn(PawnTypes type, int pawnID){
        this.type = type;
        this.pawnID = pawnID;

        switch(type){
            case BLACK -> this.direction = Directions.DOWNWARDS;
            case WHITE -> this.direction = Directions.UPWARDS;
            default -> this.direction = Directions.NONE;
        }
    }

}
