package edu.sandiego.comp305.sp23;

/**
 * This class represents a pawn in the game of chess and other games that have this piece, such as Hexapawn.
 * Each pawn has an identification number, a type (e.g., White or Black), and a movement direction.
 * @author JP Tasto
 */
public class Pawn{
    private final Directions direction;
    private final PawnTypes type;
    private final int pawnID;

    /**
     * Constructs a Pawn object that has an identification number along with a type (e.g. White, Black) and direction.
     * In this constructor, the type and direction are tied to each other; white pawns always move upwards and black pawns
     * always move downwards.
     * @param type The type of the pawn.
     * @param pawnID The identification number of the pawn.
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
     * Constructs a Pawn object that is identical to the Pawn passed in as a parameter.
     * @param otherPawn The Pawn one wants to make a copy of
     */
    public Pawn(Pawn otherPawn){
        this.type = otherPawn.getType();
        this.pawnID = otherPawn.getPawnID();
        this.direction = otherPawn.getDirection();
    }

    public Directions getDirection(){
        return this.direction;
    }

    public PawnTypes getType(){
        return this.type;
    }

    public int getPawnID(){
        return this.pawnID;
    }

    /**
     * Checks to see if another Pawn object has the same ID, type, and direction as the Pawn passed in as a parameter.
     * @param otherObj The Object to be compared with this Pawn.
     * @return True if the pawnID, type, and direction are all the same as otherObj's, false otherwise.
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
