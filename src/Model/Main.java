/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;
import java.awt.Point;

/**
 *
 * @author Nate, Spac3(Michael)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point to = new Point();
        Point too = new Point();
        Piece hold;
        to.setLocation(1,0);
        too.setLocation(2,1);
        
        Board gameboard = new Board();
        gameboard.Board_init();
        gameboard.drawBoard(gameboard);
        
        gameboard.board[0][0].move(to, gameboard);
        gameboard.board[1][1].move(too, gameboard);
        
        //hold = gameboard.getPiece(1, 0);
        //System.out.print(hold.identify());
        
        gameboard.drawBoard(gameboard);
        
        to.setLocation(3,1);
        gameboard.board[1][2].move(to, gameboard);
        gameboard.drawBoard(gameboard);
    }
    
}
