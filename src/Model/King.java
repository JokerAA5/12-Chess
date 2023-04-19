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
public class King extends Piece { //FINISHED(?)

    /**
     * This method will place the King Piece on the board as part of initial
     * setup
     *
     * @param team Whichever Player this piece belongs to
     */
    @Override
    public void initialize(int team) {
        //sets starting position in internal data depending on team so movement is tracked accurately once stuff starts moving. Board location is tracked/initalized separately in the Board class
        if (team == 1) {
            this.team = 1;
            this.setPosition(0, 1);
        }

        if (team == 2) {
            this.team = 2;
            this.setPosition(3, 1);
        }
    }

    /**
     * This method will return the name of the piece
     *
     * @return The String King
     */
    @Override
    public String identify() {
        return "King";
    }

    /**
     * This method will check if the move the King Piece has made is legal in
     * that it has moved in a valid direction and has not ran into any other
     * player pieces.
     *
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that then move will be checked to
     * see if valid on
     * @return A Boolean Value on whether or not the move is legal
     */
    @Override
    public boolean isValidMove(Point to, Board board) { //king can move one space in any direction
        Piece hold = board.getPiece(to); //hold destination contents
        Point from = this.getPosition(); //hold current possition cordinates
        int dx = Math.abs(to.x - from.x);
        int dy = Math.abs(to.y - from.y);
        int tea;
        if (hold != null) {
            tea = hold.team;
        } else {
            tea = 0;
        }

        if (this.isCaptured) { //spoof normal change in location if in capture bank
            dx = 1;
            dy = 1;
        }

        if (to.x >= 0 && to.x <= 3 && to.y >= 0 && to.y <= 2) { //within bounds of play
            if (this.team == 1) { //team 1 is on the left so piece will move right
                if (((dy == 1) && (dx == 1)) || ((dy == 0) && (dx == 1)) || ((dy == 1) && (dx == 0))) {
                    if (this.team != tea) { //check to make sure it wont run into friendly piece
                        if (this.isCaptured && hold != null) { //if its captured just make sure the space is empty
                            return false;
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            if (this.team == 2) {  //team 2 is on the right so piece will move left
                if (((dy == 1) && (dx == 1)) || ((dy == 0) && (dx == 1)) || ((dy == 1) && (dx == 0))) {
                    if (this.team != tea) {
                        if (this.isCaptured && hold != null) {
                            return false;
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false; //if nothing
    }

    /**
     * This method will move the King piece from its current space to its
     * selected movement space.
     *
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that the move will be displayed on
     */
    @Override
    public void move(Point to, Board board) {
        Point from = this.getPosition(); //get current possition for from 
        Piece hold = board.getPiece(to); //get value held in target space
        int tea;
        if (hold != null) {
            tea = hold.team;
        } else {
            tea = 0;
        }
        if (isValidMove(to, board)) {

            if (hold != null && tea != this.team) {
                capture(hold, board);
            }

            board.updateBoard(to, this); //update board
            board.updateBoard_null(from); // clear last space
            this.setPosition(to); //set possition in instance
        }
    }
}
