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
        super.printDetail();
        if(this.isRequested){
            System.out.println("requested by another borrower\n");
        }else{
            System.out.println("not requested by another borrower\n");
        }
    }
}
