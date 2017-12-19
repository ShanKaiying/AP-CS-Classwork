/*
 * Victoria Shan
 * S3C8 APCS
 * This program is a tictactoe game that cannot judge diagonals
 */
package newproject;

/**
 *
 * @author apple
 */

import java.util.Scanner;

public class TicTacToeVictoria {
   
    public static void main(String args[]){
        boolean wins = false;
        char player;
        for(int i = 1; i < 10; i ++){
            int m = i%2;
            if(m==0){
                player='x';
                position(x,m,'x');
                wins = judge(x,row,col);
            }else{
                player='o';
                position(o,m,'o');
                wins = judge(o,row,col);
            }
            if(wins){
            System.out.print("player " + player +" wins");
            break;
        }else if(i == 9){
            System.out.print("tie.");
        }
        }
        
    }

    
    static int[][] x=new int[3][3];
    static int[][] o=new int[3][3];
    static int row;
    static int col;
    
    //judge 
    public static boolean judge(int[][] m, int i, int j){
        
        int a=0;
        int b=0;
        
        for(int l = 0; l <= 2; l++){
                      
                if(m[i][l]==1){
                    a+=1;
                }
                
                if(m[l][j]==1){
                    b+=1;
                }
                
        }
        if(a==3||b==3){
            return true;
        }else{
            return false;
        }
    }
    
    //position
    static void position(int [][] xo, int m, char player){
        Scanner input = new Scanner(System.in);
        System.out.print("player " + player + " row #: ");
        int row  = input.nextInt()-1;
        System.out.print("player " + player + " column #: ");
        int col = input.nextInt()-1;
        
        if(row > 2 || row < 0 || col > 2|| col <0){
            System.out.println("exceeds the bound, you idiot.");
            position(xo, m, player);
        }else{
            xo[row][col] = 1;
            printBoard();
        }
    }
    
    //print chessboard
    public static void printBoard(){
        System.out.print("|");
        for(int i = 0; i <=2; i++){
            for(int j = 0; j <=2; j++){
                if(x[i][j]==1)
                        System.out.print(" x |");
                    else if(o[i][j]==1)
                        System.out.print(" o |");
                    else
                        System.out.print("   |");
                }
                System.out.println("");
                if(i != 2){
                   System.out.print("|");
             
                }
                }
    }
    
    }
