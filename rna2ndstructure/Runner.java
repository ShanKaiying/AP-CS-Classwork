/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rna2ndstructure;

/**
 *
 * @author apple
 */
import java.util.Scanner;
import java.util.Arrays;
public class Runner {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("input rna sequence: ");
        String r = input.nextLine();
        RNASegment rna2 = new RNASegment(r);
        
        int maxLine = 0;
        int maxScore = 0;
        for(int i = 0; i < r.length(); i++){
            maxScore = Math.max(maxScore, rna2.segmentScore(i));
            if(rna2.segmentScore(i) > maxScore){
                maxLine = i;
            }
        }
        
        System.out.print(maxLine);
            
}
}