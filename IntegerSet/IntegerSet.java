/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerset;

/**
 *
 * @author kaiyingshan
 */
public class IntegerSet implements Mergeble{
    public int[] integerSet;
    
    public IntegerSet(){
        
    }
    
    public IntegerSet(int[] is){
        integerSet = is;
    }
    
    void printElement(){
        for(int i = 0 ; i < integerSet.length; i ++){
            System.out.print(integerSet[i]);
            if(i +1 != integerSet.length){
                System.out.print(" ");
            }
        }
        
    }
    
    int size(){
        return integerSet.length;
    }
    
    boolean elementOf(int x){
        for(int i = 0; i < integerSet.length; i++){
            if(integerSet[i] == x){
                return true;
            }
        }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public Object merge(Object o) {
        int[] x = (int[]) o;
        int l = integerSet.length + x.length;
        int[] result = new int[l];
        for(int i = 0 ; i < integerSet.length ; i ++){
            result[i] = integerSet[i];
        }
        
        for(int i = 0; i < x.length; i ++){
            result[integerSet.length + i] = x[i];
        }
        
        return result;
    }
    
}
