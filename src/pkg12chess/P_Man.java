/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Peices;

/**
 *
 * @author michael
 */
public class P_Man {
    public static int xposs = 0;
    public static int yposs = 0;
    public static int team = 0;
    //public int[] poss = {x,y}; //possition of peice
    
    public static void move(){
        if (team == 1 && xposs != 4){
            xposs++;
        }
        
        if (team==2 && xposs!=0) {
            xposs--;
        }
        
        else if (xposs == 0 || xposs == 4){
            //change to feudal lord
        }
    }
}
