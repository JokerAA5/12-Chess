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
public class General extends Piece { //FINISHED(?)
    
    /**
     * This method will place the General Piece on the board as part of initial
     * setup
     * @param team Whichever Player this piece belongs to
     */
    @Override
     public void initialize(int team){ //sets starting position in internal data depending on team so movement is tracked accurately once stuff starts moving. Board location is tracked separately
        if(team == 1){
            this.team = 1;
            this.setPosition(0,0);
        }
        
        if(team == 2){
            this.team = 2;
            this.setPosition(3,2);
        }
    }
     /**
      * This method returns the name of this piece
      * @return The String General
      */
     @Override
     public String identify(){
         return "General";
     }
    /**
     * This method will check if The move the General Piece has made is legal
     * in the fact that it can only move one space up down left or right and that
     * it will not run into another piece of the same player. 
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that then move will be checked to see if valid on
     * @return A Boolean Value on whether or not the move is legal
     */
    @Override
    public boolean isValidMove(Point to, Board board){ //general can only move one place up, down ,left, right (no diag)
        Piece hold = board.getPiece(to); //hold destination contents
        Point from = this.getPosition(); //hold current possition cordinates
        int tea;
        if(hold != null){
            tea = hold.team;
        }
        else tea = 0;
        int dx = Math.abs(to.x - from.x);
        int dy = Math.abs(to.y - from.y);
        
        if(this.isCaptured){ //spoof normal change in location if in capture bank
           dx = 1;
           dy = 0;
        }
        
        if(to.x >= 0 && to.x <= 3 && to.y >= 0 && to.y <= 2){ //within bounds of play
            if(this.team == 1){ //team 1 is on the left so piece will move right
                if(((dy == 1) && (dx == 0)) || ((dy == 0) && (dx == 1))){ //general can only move one place up, down ,left, right (no diag)
                    if(this.team != tea){ //check to make sure it wont run into friendly piece
                        if(this.isCaptured && hold != null && to.x == 3){ //if its captured just make sure the space is empty and not the enemy territory 
                            return false;
                        }
                        return true;
                    }
                   else return false;
                }
            }

            if(this.team == 2){  //team 2 is on the right so piece will move left
                if(((dy == 1) && (dx == 0)) || ((dy == 0) && (dx == 1))){
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
      * This method will move the General piece from its current space to its
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
         }
     }
}
 