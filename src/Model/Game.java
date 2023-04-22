/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Point;
/**
 *
 * @author michael
 */
public class Game {
    public Board board = new Board(); //new board object
    //private Point to = new Point(); //Point that holds the translated user input
    //private Point from = new Point();
    private int pTurn = 1; //player turn flag
    private int win = 0; //win flag
    private int win1hold = 0; //hold variables for the king must stay in hostile terrirtory for 1 turn for win rule
    private int win2hold = 0;
    
    /**
     *initializes the internal game board
     *
     */
    public void start(){
        board.Board_init();
    }
    
    /**
     *returns a boolean based on if the requested move was preformed or not
     *
     * @param sfrom string representation of the starting space
     * @param sto string representation if the destination space
     * @return true if move was made, false if no move was made
     */
    public Boolean gmove(String sfrom, String sto){
        Point from = translateInput(sfrom);
        Point to = translateInput(sto);
        if (!board.checknull(from) && board.board[from.y][from.x].isValidMove(to, board) && board.board[from.y][from.x].team == pTurn) {//make sure the requested move is actually moving a valid piece and that the move is valid
                board.board[from.y][from.x].move(to, board);
                chngturn();
                board.drawBoard(board);
                return true;
        }     
        return false;
    }
    
    /**
     *returns the int representation of which players turn it is
     *@return integer representation of player turn
     */
    public int gturn(){
        return pTurn;
    }
    
    /**
     *changes the turn from player 1s to player 2s or vice versa
     *
     */
    public void chngturn(){
        if(pTurn == 1){
            pTurn =2;
        }
        else pTurn = 1;
    }
    
    /**
     *checks the board for the winning conditions.
     *
     * @return return value 1: p2 lost king p1 win. 2: p1 lost king p2 win. 1: p1 king in p2 territory for one turn. 2: p2 king in p1 territory for one turn.
     */
    public int checkWin() {
        //checks for win conditions for both teams. return value 1: p2 lost king p1 win. 2: p1 lost king p2 win. 1: p1 king in p2 territory for one turn. 2: p2 king in p1 territory for one turn.
        int k1 = 0;
        int k2 = 0;
        int hold1 = win1hold;
        int hold2 = win2hold;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board.identify(i, j, board) == "King") {//detect king and then determine team
                    if (board.board[j][i].getTeam() == 1) {
                        k1 = 1;
                    }
                    if (board.board[j][i].getTeam() == 2) {
                        k2 = 1;
                    }
                }
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (board.identify(0, i, board) == "King" && board.board[i][0].getTeam() == 2) {//p2 king in p1 territory
                if (win2hold == 1){
                    return 2;
                }
                win2hold++;
            }
  
            if (board.identify(3, i, board) == "King" && board.board[i][3].getTeam() == 1) {//p1 king in p2 territory
                if (win1hold == 1){
                    return 1;
                }
                win1hold++;
            }
        }

        if (k1 == 0) {//p1 king dead
            return 2;
        }

        if (k2 == 0) {//p2 king dead
            return 1;
        }
       if (hold1 == win1hold) win1hold = 0;//if no change is detected in the win hold then no kings are in enemy territory so reset
       if (hold2 == win2hold) win2hold = 0;
        return 0; //default return
    }
    
    /**
     *returns a Point representing the coordiantes equate to that particular space on the board. for example "A1" would return a point with a x of 0 and y of 2
     *
     * @return Point coordinates of the provided space string name
     */
    public Point translateInput(String cord) { //translates player input string into corresponding board coordinates
        Point poss = new Point();
        switch (cord) {
            case "A1":
                poss.setLocation(0, 2);
                break;
            case "A2":
                poss.setLocation(0, 1);
                break;
            case "A3":
                poss.setLocation(0, 0);
                break;
            case "B1":
                poss.setLocation(1, 2);
                break;
            case "B2":
                poss.setLocation(1, 1);
                break;
            case "B3":
                poss.setLocation(1, 0);
                break;
            case "C1":
                poss.setLocation(2, 2);
                break;
            case "C2":
                poss.setLocation(2, 1);
                break;
            case "C3":
                poss.setLocation(2, 0);
                break;
            case "D1":
                poss.setLocation(3, 2);
                break;
            case "D2":
                poss.setLocation(3, 1);
                break;
            case "D3":
                poss.setLocation(3, 0);
                break;
            case "1C1":
                poss.setLocation(4, 2);
                break;
            case "1C2":
                poss.setLocation(4, 1);
                break;
            case "1C3":
                poss.setLocation(4, 0);
                break;
            case "1C4":
                poss.setLocation(5, 2);
                break;
            case "1C5":
                poss.setLocation(5, 1);
                break;
            case "1C6":
                poss.setLocation(5, 0);
                break;
            case "2C1":
                poss.setLocation(6, 2);
                break;
            case "2C2":
                poss.setLocation(6, 1);
                break;
            case "2C3":
                poss.setLocation(6, 0);
                break;
            case "2C4":
                poss.setLocation(7, 2);
                break;
            case "2C5":
                poss.setLocation(7, 1);
                break;
            case "2C6":
                poss.setLocation(7, 0);
                break;
        }
        return poss;
    }
    
    /**
     *resets the game state to initial values. used to start new games after the initial one has been played
     *
     */
    public void reset(){
        board.Board_init();
        pTurn = 1;
        win = 0;
        win1hold = 0;
        win2hold = 0;
    }
    
}
