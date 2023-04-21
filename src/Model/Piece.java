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
    public Point position = new Point();

    public abstract void initialize(int team);//handles the initializeation of the piece based on desired team. abstracted to subclasses

    public abstract boolean isValidMove(Point to, Board board); //takes the current possition of the piece and the users desired destination and makes sure its a valid move. abstracted to subclasses

    public abstract String identify();//returns the string identification of the piece. abstracted to subclasses

    /**
     * This method will get the current position of a piece
     *
     * @return Returns the current position of the piece
     */
    public Point getPosition() { //returns the position of the piece
        return position;
    }

    /**
     * This method will set the current position of the Piece on the Board
     *
     * @param poss The current cooridnate positions of the piece
     */
    public void setPosition(Point poss) {//sets the internal possition of the piece. only used for initilization on the board
        int x = poss.x;
        int y = poss.y;
        position.setLocation(x, y);
    }

    public void setPosition(int x, int y) {//sets the internal possition of the piece. only used for initilization on the board. overloaded to take int x and y coordinates
        position.setLocation(x, y);
    }

    public int getTeam() {//returns the team number
        return team;
    }

    /**
     * This method will move the piece on a board to another spot
     *
     * @param to This is the space the piece will be moving to
     * @param board This is the Board Object that the move will be displayed on
     */
    public void move(Point to, Board board) { //further implemented in subclasses
        Point from = this.getPosition();
        board.updateBoard_null(from);
        this.setPosition(to);
        board.updateBoard(to, this);
    }

    /**
     * This method will process a piece capturing another piece
     *
     * @param target This is the Piece being targeted to be removed into the
     * Capture Zone
     * @param board This is the Board Object that the capture will be displayed
     * on
     */
    public void capture(Piece target, Board board) { //capture function that moves the targeted piece to the hold for your team and swaps the captured pieces team
        target.isCaptured = true;
        if (target.team == 2) {//if captured piece belonged to team 2
            for (int i = 4; i <= 5; i++) { //itterates thorugh all slots on capture board to find open spot
                for (int j = 2; j >= 0; j--) {
                    if (board.checknull(i, j)) {
                        board.updateBoard(i, j, target);
                        target.team = 1; //change owner
                        target.position.x = i;
                        target.position.y = j;
                        if(target.identify() == "Lord"){
                            Piece man = new Man();
                            man.initialize(target.team); // set lord team as team of man
                            man.setPosition(target.getPosition()); // set lord internal position as the internal position of man
                            board.updateBoard_null( target.position.x,target.position.y ); //clear spot
                            board.updateBoard(target.position.x,target.position.y, man); //place lord in spot
                        }
                        return;
                    }
                }
            }
        }

        if (target.team == 1) {//if captured piece belonged to team 1
            for (int i = 6; i <= 7; i++) {
                for (int j = 2; j >= 0; j--) {
                    if (board.checknull(i, j)) {
                        board.updateBoard(i, j, target);
                        target.team = 2; //change owner
                        target.position.x = i;
                        target.position.y = j;
                        if(target.identify() == "Lord"){
                            Piece man = new Man();
                            man.initialize(target.team); // set lord team as team of man
                            man.setPosition(target.getPosition()); // set lord internal position as the internal position of man
                            board.updateBoard_null( target.position.x,target.position.y ); //clear spot
                            board.updateBoard(target.position.x,target.position.y, man); //place lord in spot
                        }
                        return;
                    }
                }
            }
        }
    }
}
