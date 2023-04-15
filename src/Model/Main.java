/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;
import java.awt.Point;
import java.util.Scanner;

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
        Board board = new Board();
        board.Board_init();
        Point to = new Point();
        int pTurn = 1;
        int win  = 0;
        int win1hold = 0;
        int win2hold = 0;
        int game = 1;
        
        while (game == 1){
            if (checkWin(board) == 0){
                board.drawBoard(board);
                while (pTurn == 1){
                    playerOneTurn(board);
                    pTurn = 2;
                }
            }
            if (win2hold == 0 && checkWin(board) == 0){
                board.drawBoard(board);
                while (pTurn == 2){
                    playerTwoTurn(board);
                    pTurn = 1;
                }
            }

            win = checkWin(board);

            switch(win){
                case 1:
                    //P1 win
                    System.out.print("P1 win \n");
                    game = 0;
                    break;
                case 2:
                    //P2 win
                    System.out.print("P2 win \n");
                    game = 0;
                    break;
                case 3:
                    win1hold++;
                    break;
                case 4:
                    win2hold++;
                    break;
                default: //no win conditions met 
                    win1hold = 0;
                    win2hold = 0;
                    break;
            }

            if(win1hold == 2){
                //P1 win
                System.out.print("P1 win \n");
                game = 0;
            }

            if(win2hold == 2){
                //P2 win
                System.out.print("P2 win \n");
                game = 0;
            }
        }
    }
    
    public static void playerOneTurn(Board b){
        String userTo;
        String userFrom;
        Point to = new Point();
        Point from = new Point();
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        while (flag == 0){
            //========
            //implement user input here (either through console or jtextbox)
            //TEMP CONSOLE INTERFACE
            System.out.print("P1 enter cord of piece you want to move: ");
            userFrom = scanner.nextLine();
            System.out.print("P1 enter cord where you want to move: ");
            userTo = scanner.nextLine();
            //========
            to.setLocation(translateInput(userTo));
            from.setLocation(translateInput(userFrom));

            if (!b.checknull(from) && b.board[from.y][from.x].isValidMove(to,b) && b.board[from.y][from.x].team == 1){
                b.board[from.y][from.x].move(to, b);
                flag = 1;
            }
            else System.out.print("invalid move \n");
        }
    }
    
    public static void playerTwoTurn(Board b){
        String userTo;
        String userFrom;
        Point to = new Point();
        Point from = new Point();
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        while (flag == 0){
            //========
            //implement user input here (either through console or jtextbox)
            //TEMP CONSOLE INTERFACE
            System.out.print("P2 enter cord of piece you want to move: ");
            userFrom = scanner.nextLine();
            System.out.print("P2 enter cord where you want to move: ");
            userTo = scanner.nextLine();
            //========
            to.setLocation(translateInput(userTo));
            from.setLocation(translateInput(userFrom));

            if (!b.checknull(from) && b.board[from.y][from.x].isValidMove(to,b) && b.board[from.y][from.x].team == 2){
                b.board[from.y][from.x].move(to, b);
                flag = 1;
            }
            else System.out.print("invalid move \n");
        }
    }
    
    public static Point translateInput(String cord){ //translates player input string into corresponding board coordinates
        Point poss = new Point();
        switch (cord) {
            case "A1":
                poss.setLocation(0,2);
                break;
            case "A2":
                poss.setLocation(0,1);
                break;
            case "A3":
                 poss.setLocation(0,0);
                 break;
            case "B1":
                 poss.setLocation(1,2);
                 break;
            case "B2":
                 poss.setLocation(1,1);
                 break;
            case "B3":
                 poss.setLocation(1,0);
                 break;
            case "C1":
                 poss.setLocation(2,2);
                 break;
            case "C2":
                 poss.setLocation(2,1);
                 break;
            case "C3":
                 poss.setLocation(2,0);
                 break;
            case "D1":
                 poss.setLocation(3,2);
                 break;
            case "D2":
                 poss.setLocation(3,1);
                 break;
            case "D3":
                 poss.setLocation(3,0);
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
    
    public static int checkWin(Board b){
        //checks for win conditions for both teams. return value 1: p2 lost king p1 win. 2: p1 lost king p2 win. 3: p1 king in p2 territory. 4: p2 king in p1 territory.
        //make sure to count return 3 and 4 values twice before win condition as this function will only tell you if the king is in enemy territory but not how long its been there
        int k1 = 0;
        int k2 = 0;
        
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 2; j++){
                if(b.identify(i, j, b) == "King"){//detect king and then determine team
                    if (b.board[j][i].getTeam() == 1){
                        k1 = 1;
                    }
                    if (b.board[j][i].getTeam() == 2){
                        k2 = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i <= 2; i++){
            if(b.identify(0, i, b) == "King" && b.board[i][0].getTeam() == 2 ){//p2 king in p1 territory
                return 4;
            }
            if(b.identify(3, i, b) == "King" && b.board[i][3].getTeam() == 1 ){//p1 king in p2 territory
                return 3;
            }
        }
        
        if (k1 == 0){
            return 2;
        }
        
        if (k2 == 0){
            return 1;
        }
        
        return 0; //default return
    }
}
