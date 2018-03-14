/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kaiyingshan
 */
public abstract class Shape implements Comparable{

    @Override
    public int compareTo(Object o) {
        Shape s = (Shape)o;
        if(this.area() > s.area() && this.area() - s.area() >= 0.001){
            return 1;
        }else if(this.area() < s.area() && s.area() - this.area() >= 0.001){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    
    public Shape(){
        
    }
    
    public abstract double perimeter();
    
    public abstract double area(); 
    
    
    
    public static void main(String[] args) {
        
        ArrayList<Shape> shapes  = new ArrayList<>();
        
        
        Shape c = new Circle(3.0);
        Shape t = new Triangle(3, 4, 5);
        Shape s = new Square(5.0);
        Shape r = new Rectangle(4,6);
        
        shapes.add(c);
        shapes.add(t);
        shapes.add(s);
        shapes.add(r);
        
        Collections.sort(shapes);
        
        for(Shape s1 : shapes){
            System.out.println(s1.toString());
        }
    }
    
}
