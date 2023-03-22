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
public abstract class Piece { //makes sure you have to go through subclasses to use
    
    public int team;
    public boolean iscaptured;
    private Point position;
    
    //public abstract void setTeam(int team);
    
    public abstract boolean isValidMove(Point to, Point from, Piece[][] boardstate); //takes the current possition of the piece and the users desired destination and makes sure its valid
      
    public abstract boolean isTaking(Point to, Point from, Piece[][] boardstate); //Point is an imported function of the java standard library 
    
    public void setPosition(Point position){ 
        this.position = position;
    }
    
    public void move(Point to, Point from, Piece[][] boardstate){ //further implemented in subclasses
        setPosition(to);
        boardstate[from.y][from.x] = null;
        boardstate[to.y][to.x] = this;
    }
    
    
}
