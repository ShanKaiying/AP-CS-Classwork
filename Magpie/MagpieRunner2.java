/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magpie;

/**
 *
 * @author apple
 */

import java.util.Scanner;
public class MagpieRunner2 {
    /**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie2 maggie = new Magpie2();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			
                    
                    System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
                        
                      
		}
	}
}
