/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg12chess;
import java.awt.Point;

/**
 *
 * @author Spac3
 */
public class Man extends Piece {
    @Override
    public boolean isValidMove(Point to, Point from, Piece[][] boardstate){
        int dx = (to.x - from.x);
        int dy = Math.abs(to.y - from.y);
        
        if(this.team == 1){ //team 1 is on the left so piece will move right
            if((dy == 0) && (dx == 1)){
                if(this.team != boardstate[to.y][to.x].team){ //check to make sure it wont ruun into friendly piece
                    return true;
               }
               else return false;
            }
        }
        
        if(this.team == 2){  //team 2 is on the right so piece will move left
            if((dy == 0) && (dx == -1)){
                if(this.team != boardstate[to.y][to.x].team){
                    return true;
               }
               else return false;
            }
        }
        return false; //if nothing
    }
           
    @Override
     public boolean isTaking(Point to, Point from, Piece[][] boardstate){
         if(boardstate[to.y][to.x].team != this.team && isValidMove(to, from, boardstate)){
             return true;
         }
         return false;
     }
     
     public void move(Point to, Point from, Piece[][] boardstate){
         if(isValidMove(to, from, boardstate)){
             
             if(boardstate[to.y][to.x] != null && boardstate[to.y][to.x].team != this.team){
                 //capture
             }
             
             setPosition(to);
             boardstate[to.y][to.x] = this; //not needed if just updating the setposition value and not board matrix
             boardstate[from.y][from.x] = null;
         }
     }  
}
