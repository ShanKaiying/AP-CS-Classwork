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
public class Square extends Shape{
    public double sideLength;
    
    public Square(double sl){
        this.sideLength = sl;
    }

    @Override
    public double perimeter() {
        return 4 * this.sideLength;
    }

    @Override
    public double area() {
        return this.sideLength * this.sideLength;
    }
    
    @Override
    public String toString(){
        return "This square has" + " perimeter: " + this.perimeter() + "; area: " + this.area();
    }
    
}
