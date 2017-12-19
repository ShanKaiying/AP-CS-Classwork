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

import java.util.Random;
import java.lang.String;

public class Magpie2 {
    /**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
                if (statement.indexOf("no") >= 0)
		{
                    int ind = statement.indexOf("no");
                    if((statement.substring(ind-1).compareTo(" ") == 0 ||statement.substring(ind-1).compareTo("") == 0)){
                        response = "Why so negative?";
                    }
			
                    else{
                        response = getRandomResponse();
                    }
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
                else if(statement.indexOf("beatbox") >= 0){
                    response = "mimimi mamama mimimi mamama pu pa pupu pa pu pa pupu pa \nhuala huala huahuala";
                }else if(statement.indexOf("poem") >= 0){
                    response = "苟利国家生死矣，岂因祸福避趋之。";
                   
                }else if(statement.indexOf("color") >= 0 && (statement.indexOf("like") >= 0 || statement.indexOf("favorite") >= 0)){
                    response = "My favorite color is green.\nIt symbolizes my love story.";
                }else if(statement.indexOf("hobby")>=0 && statement.indexOf("you")>=0){
                    response = GetRandomToad();
                }else{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
        
        private String GetRandomToad(){
            String[] choose = {"Oh, I enjoy praying to toads.", "I'd love to study glasses with black frames.", "Studying makes me happy. Oh, by the way, my dream school is Shanghai Jiao Tong University."};
            return choose[(int)(Math.random()*3)];
        }
        
        }

