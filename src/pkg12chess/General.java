/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg12chess;
import java.awt.Point;
/**
 *
 * @author Spac3(Michael)
 */
public class General extends Piece { //FINISHED(?)
    
    @Override
     public void initialize(int team){ //sets starting position in internal data depending on team so movement is tracked accurately once stuff starts moving. Board location is tracked separately
        if(team == 1){
            this.team = 1;
            this.setPosition(0,2);
        }
        
        if(team == 2){
            this.team = 2;
            this.setPosition(3,0);
        }
    }
     
     @Override
     public String identify(){
         return "General";
     }
    
    @Override
    public boolean isValidMove(Point to, Board board){ //general can only move one place up, down ,left, right (no diag)
        Piece hold = board.getPiece(to); //hold destination contents
        Point from = this.getPosition(); //hold current possition cordinates
        int dx = Math.abs(to.x - from.x);
        int dy = Math.abs(to.y - from.y);
        
        if(to.x >= 0 && to.x <= 3 && to.y >= 0 && to.y <= 2){ //within bounds of play
            if(this.team == 1){ //team 1 is on the left so piece will move right
                if(((dy == 1) && (dx == 0)) || ((dy == 0) && (dx == 1))){ //general can only move one place up, down ,left, right (no diag)
                    if(this.team != hold.team){ //check to make sure it wont run into friendly piece
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
                    if(this.team != hold.team){
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
           
     @Override
     public void move(Point to, Board board){
         Point from = this.getPosition(); //get current possition for from 
         Piece hold = board.getPiece(to); //get value held in target space
         if(isValidMove(to, board)){
             
             if(hold != null && hold.team != this.team){
                 capture(hold, board);
             }
             
             this.setPosition(to); //set possition in instance
             board.updateBoard(to, this); //update board
             board.updateBoard_null(from); // clear last space
         }
     }
}
 