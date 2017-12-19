/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author apple
 */
public class Runner {
    public static void main (String args[]){
        Speaks a = new Speaks("Miao", 15, "English");
        System.out.print(a.SayHello());
    }
}
