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
public class Book extends LibraryItems {
    boolean isRequested;
    public Book(){
        super();
        isRequested = false;
    }
    
    public Book(String t, String a, String i, boolean l, Date d, boolean iR){
        super(t, a, i, l, d);
        isRequested = iR;
    }
    
    public boolean getIsRequested(){
        return this.isRequested;
    }
    
    public void setIsRequested(boolean iR){
        isRequested = iR;
    }
    
    @Override
    public void printDetail(){
        System.out.println("title: "+ this.title);
        System.out.println("author: "+ this.getAuthor_Artist());
        System.out.println("itemID: " + this.itemID);
        if(this.onLoan){
            System.out.println("on loan");
        }else{
            System.out.println("not on loan");
        }
        System.out.println("due date: " + this.dueDate);
        if(this.isRequested){
            System.out.println("requested by another borrower\n");
        }else{
            System.out.println("not requested by another borrower\n");
        }
    }
}
