/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryitems;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author kaiyingshan
 */
public class LibraryItems {

    public String title;
    public String author_artist;
    public String itemID;
    public boolean onLoan;
    public Date dueDate;
    public int borrowerID;
    public ArrayList<Borrower> borrowers= new ArrayList<>();
    
    public LibraryItems(){
        title = "";
        author_artist = "";
        itemID = "";
        onLoan = false;
        dueDate = new Date();
    }
    
    public LibraryItems(String t, String a, String i, boolean l, Date d){
        title = t;
        author_artist = a;
        itemID = i;
        onLoan = l;
        dueDate = d;
    }
    
    public String GetTitle(){
        return this.title;
    }
    
    public String getAuthor_Artist(){
        return this.author_artist;
    }
    
    public String getItemId(){
        return this.itemID;
    }
    
    public boolean getOnLoan(){
        return this.onLoan;
    }
    
    public Date getDueDate(){
        return this.dueDate;
    }
    
    public void borrowing(String bn, String e, int id, int iol){
        this.onLoan = true;
        Borrower b = new Borrower(bn, e, id, iol);
        borrowers.add(b);
        this.borrowerID = b.borrowerID;
        b.updateItemsOnloan(1);
        this.dueDate = addDays(new Date(), 14);
    }
    
    public void borrowing(int bid){
        for(int i = 0; i < borrowers.size(); i++){
            if(bid == borrowers.get(i).borrowerID){
                this.borrowerID = borrowers.get(i).borrowerID;
                borrowers.get(i).updateItemsOnloan(1);
                this.dueDate = addDays(new Date(), 14);
                break;
            }
        }
        
    }
    
    public void returning(int bid){
        this.onLoan = false;
        for(int i = 0; i < borrowers.size(); i ++){
            if(bid == borrowers.get(i).borrowerID){
                this.borrowerID = 0;
                borrowers.get(i).updateItemsOnloan(-1);
                this.dueDate = null;
                break;
            }
        }
        
    }
    
    private static Date addDays(Date date, int days){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    public void printDetail(){
        System.out.println("title: "+ this.title);
        System.out.println("author/artist: "+ this.getAuthor_Artist());
        System.out.println("itemID: " + this.itemID);
        if(this.onLoan){
            System.out.println("on loan");
        }else{
            System.out.println("not on loan");
        }
        System.out.println("due date: " + this.dueDate);
    }
    
    public static void main(String[] args) {
        LibraryItems b = new Book("12 Rules for Life", "Jordan Peterson", "X123", false, new Date(), false);
        b.printDetail();
        
        LibraryItems cd = new CD("And Justice for All", "Metallica", "X567",false, new Date(), "Metal");
        cd.printDetail();
        
    }

}
