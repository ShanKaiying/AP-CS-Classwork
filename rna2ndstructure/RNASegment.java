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
public class RNASegment {
    public static String[] rnaArr;
    public static String rna;
    public static int[][] score;
    public static int segmentNum = 0;
    public int sepScore;
    
    
    public RNASegment(String rnaStr){
        rna = rnaStr;
        String[] rnaArr = new String[rna.length()];
        for(int i = 0; i < rna.length(); i++){
            rnaArr[i] = rna.substring(i, i+1);
        }
        
        score = new int[rna.length()][rna.length()];
        for(int j = 0; j < score.length; j++){
            for(int k = 0; k < score[j].length;k++){
                if(rnaArr[j].compareTo("G") == 0 && rnaArr[k].compareTo("U") == 0){
                    score[j][k] = 1;
                }else if(rnaArr[k].compareTo("G") == 0 && rnaArr[j].compareTo("U") == 0){
                    score[j][k] = 1;
                }else if(rnaArr[j].compareTo("G") == 0 && rnaArr[k].compareTo("C") == 0){
                    score[j][k] = 3;
                }else if(rnaArr[j].compareTo("C") == 0 && rnaArr[k].compareTo("G") == 0){
                    score[j][k] = 3;
                }else if(rnaArr[j].compareTo("A") == 0 && rnaArr[k].compareTo("U") == 0){
                    score[j][k] = 2;
                }else if(rnaArr[j].compareTo("U") == 0 && rnaArr[k].compareTo("A") == 0){
                    score[j][k] = 2;
                }else{
                    score[j][k] = 0;
                }
                
            }
        
    }
        
    
    }
    
    public int segmentScore(int num){
        
        
           this.sepScore = 0;
           for(int w = num; w >= 0; w--){
               this.sepScore += score[w][num-w];
               if(w == num-w){
                   break;
               }
           }
    
        return this.sepScore;
        
    }
    
   public static int GetsegmentNum(){
       for(int q = 0; q < rna.length(); q++){
           for(int p = 0; p < q; p++){
               if(p != 0){
                   segmentNum ++;
                   break;
               }
           }
       }
       return segmentNum;
   }
    
}
