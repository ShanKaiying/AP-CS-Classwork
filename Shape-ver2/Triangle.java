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
public class Triangle extends Shape{
    public double side1;
    public double side2;
    public double side3;
    
    public Triangle(double s1, double s2, double s3){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    
    public String toString(){
        return "This triangle has: area: " + this.area() + "and perimeter: " + this.perimeter();
    }

    @Override
    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public double area() {
        double s = this.perimeter()/2;
        return Math.pow(s * (s-this.side1) * (s-this.side2) * (s-this.side3), 0.5);
    }
    
    
}
