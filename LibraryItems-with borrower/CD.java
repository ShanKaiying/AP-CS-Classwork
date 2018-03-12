/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryitems;
import java.util.Date;

/**
 *
 * @author kaiyingshan
 */
public class CD extends LibraryItems{
    
    public String genre;
    
    public CD(){
        super();
        this.genre = "";
    }
    
    public CD(String t, String a, String i, boolean l, Date d, String genre){
        super(t, a, i, l, d);
        this.genre = genre;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    @Override
    public void printDetail(){
        System.out.println("title: "+ this.title);
        System.out.println("artist: "+ this.getAuthor_Artist());
        System.out.println("itemID: " + this.itemID);
        if(this.onLoan){
            System.out.println("on loan");
        }else{
            System.out.println("not on loan");
        }
        System.out.println("due date: " + this.dueDate);
        System.out.println("music type: " + this.genre +"\n");
    }
    
}
