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
public class Board {

    public Piece board[][];

    /**
     *initializes the board with the starting piece positions
     *
     */
    public void Board_init() { // initializes the board
        board = new Piece[3][8];
        //board should look like this with the right most #C spaces representing the capture hold spaces. 
        // 1Mi - -  2G  1C 1C 2C 2C
        // 1K 1M 2M 2K  1C 1C 2C 2C
        // 1G  - -  2Mi 1C 1C 2C 2C
        //Pieces can only move to #C spaces with the capture function and are driven out with the normal move function.
        //#C spaces are initalized as NULL
        // - is NULL
        board[0][0] = new General(); // general team 1
        board[0][0].initialize(1);
        board[1][0] = new King(); // king team 1
        board[1][0].initialize(1);
        board[2][0] = new Minister(); //minister team 1
        board[2][0].initialize(1);
        board[0][1] = null;
        board[1][1] = new Man(); //man team 1
        board[1][1].initialize(1);
        board[2][1] = null;
        board[0][2] = null;
        board[1][2] = new Man(); //man team 2
        board[1][2].initialize(2);
        board[2][2] = null;
        board[0][3] = new Minister(); // minister team 2
        board[0][3].initialize(2);
        board[1][3] = new King(); // king team 2
        board[1][3].initialize(2);
        board[2][3] = new General(); //general team 2
        board[2][3].initialize(2);

        for (int i = 4; i <= 7; i++) {
            for (int j = 0; j <= 2; j++) {
                board[j][i] = null;
            }
        }
    }
    
    /**
     *returns the piece at the specified coordinate on the board
     *
     * @param poss Point for the coordinates
     * @return The piece at the requested location
     */
    public Piece getPiece(Point poss) {//returns the piece in the requested board location 
        return board[poss.y][poss.x];
    }

    /**
     *returns the piece at the specified coordinate on the board
     *
     * @param x integer for the x coordinate
     * @param y integer for the y coordinate
     * @return The piece at the requested location
     */
    public Piece getPiece(int x, int y) {//returns the piece in the requested board location. overloaded to take int x and y coordinates
        return board[y][x];
    }

    /**
     *sets the specified coordinate on the board to the passed piece
     *
     * @param poss Point for the coordinates
     * @param piece Piece passes for placement
     */
    public void updateBoard(Point poss, Piece piece) {//fills the requested board position with the provided piece
        board[poss.y][poss.x] = piece;
    }

    /**
     *sets the specified coordinate on the board to the passed piece
     *
     * @param x integer for the x coordinate
     * @param y integer for the y coordinate
     * @param piece Piece passes for placement
     */
    public void updateBoard(int x, int y, Piece piece) {//fills the requested board position with the provided piece. overloaded to take int x and y coordinates
        board[y][x] = piece;
    }
    
    /**
     *sets the specified coordinate on the board to null
     *
     * @param poss Point for the coordinates
     */
    public void updateBoard_null(Point poss) {//fills the requested board position with a NULL value
        board[poss.y][poss.x] = null;
    }

    /**
     *sets the specified coordinate on the board to null
     *
     * @param x integer for the x coordinate
     * @param y integer for the y coordinate
     */
    public void updateBoard_null(int x, int y) {//fills the requested board position with a NULL value. overloaded to take int x and y coordinates
        board[y][x] = null;
    }

    /**
     *returns a boolean value determined by if there is a piece in the specified coordinates or not 
     *
     * @param poss Point for the coordinates
     * @return true if space is null, false if occupied
     */
    public boolean checknull(Point poss) {//checks the provided possition for if it is empty or not
        if (board[poss.y][poss.x] == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *returns a boolean value determined by if there is a piece in the specified coordinates or not 
     *
     * @param x integer for the x coordinate
     * @param y integer for the y coordinate
     * @return true if space is null, false if occupied
     */
    public boolean checknull(int x, int y) {//checks the provided possition for if it is empty or not. overloaded to take int x and y coordinates
        if (board[y][x] == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     *returns the string identification of a piece at the Point coordinate 
     *
     * @param poss Point representation of the coordinates
     * @param b the gameboard passed thorugh to the function
     * @return string identification if the piece in the requested space
     */
    public String identify(Point poss, Board b) {//returns the string identification of the piece at the requested position
        if (b.getPiece(poss) != null) {
            return board[poss.y][poss.x].identify();
        } else {
            return "null";
        }
    }

    /**
     * returns the string identification of a piece at the x and y coordinate 
     *
     * @param x integer for the x coordinate
     * @param y integer for the y coordinate
     * @param b the gameboard passed thorugh to the function
     * @return string identification if the piece in the requested space
     */
    public String identify(int x, int y, Board b) {//returns the string identification of the piece at the requested position. overloaded to take int x and y coordinates
        if (b.getPiece(x, y) != null) {
            return board[y][x].identify();
        } else {
            return "null";
        }
    }

    /**
     * This Method will draw the board in the console for users to play
     *
     * @param board The Board
     */
    public void drawBoard(Board board) { //prints the current board state onto the console row wise ([2][0-7] gets drawn first)
        System.out.print("  A B C D  1C  2C\n");
        for (int i = 2; i >= 0; i--) { //y
            switch (i) {
                case 2:
                    System.out.print("1 ");
                    break;
                case 1:
                    System.out.print("2 ");
                    break;
                case 0:
                    System.out.print("3 ");
                    break;
            }
            for (int j = 0; j <= 7; j++) { //x
                switch (board.identify(j, i, board)) {
                    case "Man":
                        System.out.print("Ma");
                        break;

                    case "King":
                        System.out.print("Ki");
                        break;

                    case "General":
                        System.out.print("Ge");
                        break;

                    case "Minister":
                        System.out.print("Mi");
                        break;

                    case "Lord":
                        System.out.print("Lo");
                        break;

                    case "null":
                        System.out.print("--");
                        break;

                    default:
                        System.out.print("ER");
                        break;
                }
            }
            System.out.println("");
        }
    }
}
