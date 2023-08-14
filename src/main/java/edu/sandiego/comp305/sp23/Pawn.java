package edu.sandiego.comp305.sp23;

public class Pawn{
    private final Directions direction;
    private final PawnTypes type;
    private final int pawnID;

    /**
     *
     * @param type
     * @param pawnID
     */
    public Pawn(PawnTypes type, int pawnID){
        this.type = type;
        this.pawnID = pawnID;

        switch(type){
            case BLACK -> this.direction = Directions.DOWNWARDS;
            case WHITE -> this.direction = Directions.UPWARDS;
            default -> this.direction = Directions.BLANK_SPACE;
        }
    }

    /**
     *
     * @param otherPawn
     */
    public Pawn(Pawn otherPawn){
        this.type = otherPawn.getType();
        this.pawnID = otherPawn.getPawnID();
        this.direction = otherPawn.getDirection();
    }

    /**
     *
     * @return
     */
    public Directions getDirection(){
        return this.direction;
    }

    /**
     *
     * @return
     */
    public PawnTypes getType(){
        return this.type;
    }

    /**
     *
     * @return
     */
    public int getPawnID(){
        return this.pawnID;
    }

    /**
     *
     * @param otherObj
     * @return
     */
    @Override
    public boolean equals(Object otherObj){
        if(!(otherObj instanceof Pawn)){
            return false;
        }

        Pawn otherPawn = (Pawn) otherObj;

        return this.direction == otherPawn.getDirection() && this.pawnID == otherPawn.getPawnID() && this.type == otherPawn.type;
    }
}
