/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2007;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kaiyingshan
 */
public class Digit {
    private ArrayList<Integer> digitList;
    
    public Digit(int num){
        digitList = new ArrayList<Integer>();
        
        if(num == 0){
            this.digitList.add(new Integer(0));
        }
        
        while(num > 0){
            this.digitList.add(0, num%10);
            num = num/10;
        }
    }
    
    public boolean isStrictlyIncreasing(){
        for(int i = 0; i < digitList.size()-1; i ++){
            if(digitList.get(i+1) <= digitList.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        Digit d = new Digit(17);
        for(int i = 0; i < d.digitList.size(); i++){
            System.out.print(d.digitList.get(i));
        }
    }
    
}
