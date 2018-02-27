/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author kaiyingshan
 */
public class Tiles {
    public int direction = 1;//一共四个方向，1是默认，从1到4（但表示的是0，因为我们要向4取模，符号是%）顺时针旋转
    public int randDirec = 1;
    public int[] coordinate = {0,0};
    public int brand = 1;//一共七种形状，1代表I，2代表J，3代表L，四代表O，5代表S，6代表T，7代表z
    public static final int length = 22;
    public int height = 0;
    public int width = 0;
    
    
    public Tiles(){
        this.randDirec = (int) (Math.random() * 4 + 1);
        this.direction = randDirec % 4;
        
        brand = (int)(Math.random() * 7)+1;
        
        int xCoor = (int)(Math.random() * 10) * 22 + 1;
        this.coordinate[0] = xCoor;
        this.coordinate[1] = 1;
        if(this.brand == 1 && (this.coordinate[0] > 200 || this.coordinate[0] > 134 || this.coordinate[0] < 88)){
            this.coordinate[0] = 89;
        }
        if(this.brand == 2){
            if(this.coordinate[0] > 154){
                this.coordinate[0] = 155;
            }
            if(this.coordinate[0] < 66){
                this.coordinate[0] = 67;
            }
        }
        
        if(this.brand == 3){
            if(this.coordinate[0] > 154){
                this.coordinate[0] = 155;
            }
            if(this.coordinate[0] < 66){
                this.coordinate[0] = 67;
            }
        }
        if(this.brand == 4){
            if(this.coordinate[0] > 176){
                this.coordinate[0] = 177;
            }
            if(this.coordinate[0] < 44){
                this.coordinate[0] = 45;
            }
        }
        if(this.brand == 5){
            if(this.coordinate[0] > 154){
                this.coordinate[0] = 155;
            }
            if(this.coordinate[0] < 66){
                this.coordinate[0] = 67;
            }
        }
        if(this.brand == 6){
            this.coordinate[0] = 154;
        }
        if(this.brand == 7){
            if(this.coordinate[0] > 154){
                this.coordinate[0] = 155;
            }
            if(this.coordinate[0] < 66){
                this.coordinate[0] = 67;
            }
        }
        
        if(this.brand == 1 && (this.direction == 1 || this.direction == 3)){
            this.height = 4 * 22;
            this.width = 22;
        }
        
        if(this.brand == 1 && (this.direction == 2 || this.direction == 0)){
            this.height = 22;
            this.width = 4 * 22;
        }
        
        if(((this.brand == 2 || this.brand == 3) &&(this.direction == 1 || this.direction == 3))){
            this.height = 3 * 22;
            this.width = 2 * 22;
        }
        
        if((this.brand == 2 || this.brand == 3) && (this.direction == 2 || this.direction == 0)){
            this.height = 2 * 22;
            this.width = 3 * 22;
        }
        
        if(this.brand == 4){
            this.height = 2 * 22;
            this.width = 2 * 22;
        }
        
        if((this.brand == 5 || this.brand == 6 || this.brand == 7) && (this.direction == 1 || this.direction == 3)){
            this.height = 2 * 22;
            this.width = 3 * 22;
        }
        
        if((this.brand == 5 || this.brand == 6 || this.brand == 7) && (this.direction == 2 || this.direction == 0)){
            this.height = 3 * 22;
            this.width = 2 * 22;
        }
        
        
        
    }
    
    public void changeDirection(){
        this.randDirec++;
        this.direction = this.randDirec % 4;
        
        
        if(this.brand == 1 && (this.direction == 1 || this.direction == 3)){
            this.height = 4 * 22;
            this.width = 22;
        }
        
        if(this.brand == 1 && (this.direction == 2 || this.direction == 0)){
            this.height = 22;
            this.width = 4 * 22;
        }
        
        if(((this.brand == 2 || this.brand == 3) &&(this.direction == 1 || this.direction == 3))){
            this.height = 3 * 22;
            this.width = 2 * 22;
        }
        
        if((this.brand == 2 || this.brand == 3) && (this.direction == 2 || this.direction == 0)){
            this.height = 2 * 22;
            this.width = 3 * 22;
        }
        
        if(this.brand == 4){
            this.height = 2 * 22;
            this.width = 2 * 22;
        }
        
        if((this.brand == 5 || this.brand == 6 || this.brand == 7) && (this.direction == 1 || this.direction == 3)){
            this.height = 2 * 22;
            this.width = 3 * 22;
        }
        
        if((this.brand == 5 || this.brand == 6 || this.brand == 7) && (this.direction == 2 || this.direction == 0)){
            this.height = 3 * 22;
            this.width = 2 * 22;
        }
    }
    
    
}
