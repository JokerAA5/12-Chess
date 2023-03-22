/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg12chess;
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
        Board gameboard = new Board();
        gameboard.Board_init();
        gameboard.drawBoard(gameboard);
    }
    
}
