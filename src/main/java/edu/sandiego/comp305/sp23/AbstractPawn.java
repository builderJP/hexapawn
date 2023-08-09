package edu.sandiego.comp305.sp23;

public abstract class AbstractPawn{
    protected Directions direction;
    protected PawnTypes type;
    protected int pawnID;

    AbstractPawn(Directions direction, PawnTypes type, int pawnID){
        this.direction = direction;
        this.type = type;
        this.pawnID = pawnID;
    }

}
