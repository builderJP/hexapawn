package edu.sandiego.comp305.sp23;

/**
 * Black Pawn
 *
 *    _
 *  _(#)_
 * White (Player) Pawns
 *
 *    _    _    _
 *  _(1)__(2)__(3)_
 *
 * Board
 *  :::::     :::::
 *  :::::     :::::
 *  :::::     :::::
 *       :::::
 *       :::::
 *       :::::
 *  :::::     :::::
 *  :::::     :::::
 *  :::::     :::::
 *
 * Starting Board
 *  :::::     :::::
 *  : _ :  _  : _ :
 *  _(#)__(#)__(#)_
 *       :::::
 *       :::::
 *       :::::
 *  :::::     :::::
 *  : _ :  _  : _ :
 *  _(1)__(2)__(3)_
 *
 *  ppp
 *   .
 *  123
 *
 *  . .
 *   .
 *  . .
 */
public class BoardDrawer{

    BoardDrawer(){
        //Do we need a constructor???
    }

    protected static String drawBoard(Pawn[][] hexapawnBoard){
        //This is just the starting board
        return ":::::     :::::\n: _ :  _  : _ :\n_(#)__(#)__(#)_\n     :::::     \n     :::::     \n" +
                "     :::::     \n:::::     :::::\n: _ :  _  : _ :\n_(1)__(2)__(3)_\n";
    }
}

