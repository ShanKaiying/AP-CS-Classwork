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
public class Rectangle extends Shape{
    public double side1;
    public double side2;
    public Rectangle(double s1, double s2){
        this.side1 = s1;
        this.side2 = s2;
    }

    @Override
    public double perimeter() {
        return 2 * (this.side1 + this.side2);
    }

    @Override
    public double area() {
        return this.side1 * this.side2;
    }
    
    
}
