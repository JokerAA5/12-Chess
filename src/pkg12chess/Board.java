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
public class Board {
    public Piece board[][];
    
public void Board_init (){ // initializes the board
    board = new Piece[2][7];
    //board should look like this with the right most #C spaces representing the capture hold spaces. 
    //Pieces can only move to #C spaces with the capture function and are driven out with the normal move function.
    //#C spaces are initalized as NULL
    // - is NULL
    // 1Mi - -  2G  1C 1C 2C 2C
    // 1K 1M 2M 2K  1C 1C 2C 2C
    // 1G  - -  2Mi 1C 1C 2C 2C
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
    
    for(int i = 4; i <= 7; i++){
        for(int j = 0; j <= 2; j++){
            board[j][i] = null;
        }
    }
}    

public Piece getPiece(Point poss){
    return board[poss.y][poss.x];
}

public Piece getPiece(int x, int y){
    return board[y][x];
}

public void updateBoard(Point poss, Piece piece){
    board[poss.y][poss.x] = piece; 
}

public void updateBoard(int x, int y, Piece piece){
    board[y][x] = piece;
}

public void updateBoard_null(Point poss){
    board[poss.y][poss.x] = null;
}

public void updateBoard_null(int x, int y){
    board[y][x] = null;
}

public boolean checknull(Point poss){
    if(board[poss.y][poss.x] == null){
    return true;
}
   else return false;
}

public boolean checknull(int x, int y){
    if(board[y][x] == null){
        return true;
    }
    else return false;
}

}
