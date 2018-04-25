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
public class Phrase {
    private String currentPhrase;
    
    public Phrase(String p){
        this.currentPhrase = p;
    }
    
    public int findNthOccurrence(String str, int n){
        
        int count = 0;
        for(int i = 0; i <= this.currentPhrase.length() - str.length(); i ++){
            boolean b = true;
            
            if(currentPhrase.substring(i, i+ str.length()).equals(str)){
                count++;
            }
            if(count == n){
                return i;
            }
        }
        return -1;
    }
    
    public void replaceNthOccurrence(String str, int n, String repl){
        
        int i = this.findNthOccurrence(str, n);
        String temp1 = this.currentPhrase.substring(0,i);
        String temp2 = this.currentPhrase.substring(i + str.length());
        this.currentPhrase = temp1 + repl + temp2;
    } 
    
    public int findLastOccurrence(String str){
        int occurrence = 0;
        int index = this.findNthOccurrence(str, 1);
        if(index == -1){
            return -1;
        }
        while(true){
            if(findNthOccurrence(str, occurrence+1) == -1){
                return index;
            }
            occurrence++;
            index = findNthOccurrence(str, occurrence);
        }
    }
    
    public static void main(String[] args){
        Phrase p = new Phrase("a cat ate late");
        System.out.println(p.findLastOccurrence("at"));
        p.replaceNthOccurrence("at", 1, "rane");
        System.out.println(p.currentPhrase);
        
        
    }
    
}
