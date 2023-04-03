/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Point;

/**
 *
 * @author Spac3(Michael)
 */
public class Man extends Piece { //WIP lord conversion (in the move method at the bottom)
    
    /**
     * This method will place the Man Piece on the board as part of initial
     * setup
     * @param team Whichever Player this piece belongs to
     */
    @Override
     public void initialize(int team){ //sets starting position in internal data depending on team so movement is tracked accurately once stuff starts moving. Board location is tracked separately
        if(team == 1){
            this.team = 1;
            this.setPosition(1,1);
        }
        
        if(team == 2){
            this.team = 2;
            this.setPosition(2,1);
        }
    }
     /**
      * This method will return the name of the piece
      * @return A string Man
      */
     @Override
     public String identify(){
         return "Man";
     }
    
    /**
     * This method will check if the move the Man Piece has made is legal
     * in that it has moved in a valid direction and has not ran into any other 
     * player pieces.
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that then move will be checked to see if valid on
     * @return A Boolean Value on whether or not the move is legal
     */
    @Override
    public boolean isValidMove(Point to, Board board){ //determines rules of movement for this particular piece
        Piece hold = board.getPiece(to); //hold destination contents
        Point from = this.getPosition(); //hold current possition cordinates
        int dx = (to.x - from.x);
        int dy = Math.abs(to.y - from.y); //man can only move forward but good to keep track
        int tea;
        if(hold != null){
            tea = hold.team;
        }
        else tea = 0;
        
        if(to.x >= 0 && to.x <= 3 && to.y >= 0 && to.y <= 2){ //within bounds of play
            if(this.team == 1){ //team 1 is on the left so piece will move right
                if((dy == 0) && (dx == 1)){
                    if(this.team != tea){
                        if(this.isCaptured && hold != null && to.x == 3){ //captured pieces can onlt be placed in empty spots that are not in the other players territory
                            return false;
                        }
                        return true;
                    }
                   else return false;
                }
            }

            if(this.team == 2){  //team 2 is on the right so piece will move left
                if((dy == 0) && (dx == -1)){ //man pieces can only move in one direction dependant on team so direction matters internaly 
                    if(this.team != tea){
                        if(this.isCaptured && hold != null && to.x == 0){ 
                            return false;
                        }
                        return true;
                    }
                   else return false;
                }
            }
        }
        return false; //if nothing
    }
           
    /**
     * This method will move the Man piece from its current space to its
     * selected movement space.
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that the move will be displayed on
     */ 
    @Override
     public void move(Point to, Board board){
         Point from = this.getPosition(); //get current possition for from 
         Piece hold = board.getPiece(to); //get value held in target space
         int tea;
         if(hold != null){
            tea = hold.team;
         }
         else tea = 0;
         if(isValidMove(to, board)){
             
             if(hold != null && tea != this.team){
                 capture(hold, board);
             }
             
             board.updateBoard(to, this); //update board
             board.updateBoard_null(from); // clear last space
             this.setPosition(to); //set possition in instance
             
             if(to.x == 3){ //if the desired move space is the enemy territory change to a feudal lord (this should only be present in the Man subclass)
                 Piece lord = new Lord();
                 lord.initialize(this.team); // set lord team as team of man
                 lord.setPosition(this.getPosition()); // set lord internal position as the internal position of man
                 board.updateBoard_null(to); //clear spot
                 board.updateBoard(to, lord); //place lord in spot
             }
         }
     }  
}
