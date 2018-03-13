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
public abstract class Shape {

    /**
     * @param args the command line arguments
     */
    
    public Shape(){
        
    }
    
    public abstract double perimeter();
    
    public abstract double area(); 
    
    public static void main(String[] args) {
        Shape c = new Circle(3.0);
        Shape t = new Triangle(3, 4, 5);
        Shape s = new Square(5.0);
        Shape r = new Rectangle(4,6);
        
        
        System.out.println("area of the square is: " + s.area() + " the perimeter of the square is: " + s.perimeter());
        System.out.println("area of the triangle is: " + t.area() + " the perimeter of the triangle is: " + t.perimeter());
        System.out.println(c.toString());
        System.out.println("area of the rectangle is: " + r.area() + " the perimeter of the rectangle is: " + r.perimeter());
    }
    
}
