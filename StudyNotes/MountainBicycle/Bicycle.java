/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicycle;

/**
 *
 * @author kaiyingshan
 */
public class Bicycle{
public static int NumberOfWheels = 2;
public String brand;
public double weight;
public double speed;
boolean isRunning;

public Bicycle(){
 this.brand = "";
 this.weight = 10.0;
 isRunning = false;
 this.speed = 10.;
}

public Bicycle(String b, double w, double p, boolean ir, double s){
 this.brand = b;
 this.weight = w;
 this.isRunning = ir;
 this.speed = s;
}

public boolean ride(){
 return isRunning;
}
 
public void accelerate(){
 speed +=3;
}

public static void main(String args[]){
    
}

}