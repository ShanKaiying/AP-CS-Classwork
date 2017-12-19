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
public class Speaks {
    String name;
    int age;
    String language;
    public Speaks(String n, int a, String l){
        name = n;
        age = a;
        language = l;
    }
    
    public String SayHello(){
        if(age < 3){
            return "Ooooaaaaaa";
        }
        if(language.compareTo("English") == 0){
            return "Hello";
        }else if(language.compareTo("Spanish") == 0){
            return "Hola";
        }else if(language.compareTo("Japanese") == 0){
            return "Konichiwa";
        }else{
            return "???";
        }
    }
    
    
}
