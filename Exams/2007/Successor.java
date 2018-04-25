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
public class Successor {
    
    public static Position findPosition(int num, int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if (arr[i][j] == num){
                    return new Position(i, j);
                }
            }
        }
        return null;
    }
    
    public static Position[][] getSuccessorArray(int[][] arr){
        Position[][] s = new Position[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j++){
                s[i][j] = findPosition(arr[i][j]+1, arr);
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        Position[][] p = getSuccessorArray(arr);
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
             System.out.println(p[i][j]);
            }
        }
    
    }
}
