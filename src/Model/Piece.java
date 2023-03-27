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
public abstract class Piece { //makes sure you have to go through subclasses to use
    
    public int team;
    public boolean isCaptured = false;
    public  Point position = new Point();
    
    public abstract void initialize(int team);
    
    public abstract boolean isValidMove(Point to, Board board); //takes the current possition of the piece and the users desired destination and makes sure its valid
    
    public abstract String identify();
    
    public Point getPosition(){ 
        return position;
    }
    
    public void setPosition(Point poss){
        int x = poss.x;
        int y = poss.y;
        position.setLocation(x,y);
    }
    
    public void setPosition(int x, int y){
        position.setLocation(x,y);
    }
    
    public void move(Point to, Board board){ //further implemented in subclasses
        Point from = this.getPosition();
        board.updateBoard_null(from);
        this.setPosition(to);
        board.updateBoard(to, this);
    }
    
    public void capture(Piece target, Board board){ //capture function that moves the targeted piece to the hold for your team and swaps the captured pieces team
        target.isCaptured = true;
        if(target.team == 2){//if captured piece belonged to team 2
            for (int i = 4; i <= 5; i++){ //itterates thorugh all slots on capture board to find open spot
                for (int j = 0; j <= 2; j++){
                    if(board.checknull(i, j)){
                        board.updateBoard(i, j, target);
                        target.team = 1; //change owner
                        target.position.x = i;
                        target.position.y = j;
                        return;
                    }
                }
            }
        }
        
        if(target.team == 1){//if captured piece belonged to team 1
            for (int i = 6; i <= 7; i++){
                for (int j = 0; j <= 2; j++){
                    if(board.checknull(i, j)){
                        board.updateBoard(i, j, target);
                        target.team = 2; //change owner
                        target.position.x = i;
                        target.position.y = j;
                        return;
                    }
                }
            }
        }
    }
}
