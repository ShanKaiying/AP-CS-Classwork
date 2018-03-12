/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryitems;

/**
 *
 * @author kaiyingshan
 */
public class Borrower {
    public String borrowerName;
    public String emailAddress;
    public int borrowerID;
    public int itemsOnLoan;
    
    public Borrower(){
        this.borrowerName = "";
        this.emailAddress = "";
        this.borrowerID = 0;
        this.itemsOnLoan = 0;
    }
    
    public Borrower(String b, String e, int id, int iol){
        borrowerName = b;
        emailAddress = e;
        borrowerID = id;
        itemsOnLoan = iol;
    }
    
    public String getBorrowerName(){
        return this.borrowerName;
    }
    
    public String getEmailAddress(){
        return this.emailAddress;
    }
    
    public int getBorrowerID(){
        return this.borrowerID;
    }
    
    public int getItemsOnLoan(){
        return this.itemsOnLoan;
    }
    
    public void updateItemsOnloan(int n){
        this.itemsOnLoan += n;
    }
    
}
