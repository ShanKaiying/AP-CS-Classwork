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
public class MountainBicycle extends Bicycle{
    public int level;
    public MountainBicycle(){
        super();
        level = 0;
    }
    
    public MountainBicycle(String b, double w, double p, boolean ir, double s, int level){
        super(b, w, p, ir, s);
        this.level = level;
    }
    
    @Override
    public void accelerate(){
        speed += 3 * level;
    }
}
