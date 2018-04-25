/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2007;

/**
 *
 * @author kaiyingshan
 */
public class Position {
    int row;
    int col;
    
    public Position(int r, int c){
        row = r;
        col = c;
    }
    
    public String toString(){
        return "(" + row + ", " + col + ")";
    }
    
    
    
}
