/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author kaiyingshan
 */
public class Circle extends Shape{

    public double radius;
    
    public Circle(double radius){
        this.radius = radius;
    }

    
    @Override
    public boolean equals(Object o){
        Circle newC = (Circle)o;
        return this.radius == newC.radius;
    }
    
    @Override
    public String toString(){
        return "This circle has: radius: " + this.radius + "; area: " + this.area() +"; perimeter: " + this.perimeter();
    }
    
    @Override
    public double perimeter() {
        double temp =  Math.PI * this.radius * 2 * 100;
        int tempInt = (int) temp;
        return ((double)tempInt)/100.;
    }

    @Override
    public double area() {
        double temp = Math.PI * this.radius * this.radius * 100;
        int tempInt = (int) temp;
        return ((double)tempInt)/100.;
    }
    
}
