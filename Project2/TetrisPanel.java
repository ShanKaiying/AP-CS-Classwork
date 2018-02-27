/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author kaiyingshan
 */
public class TetrisPanel extends JPanel implements Runnable, KeyListener{
    public int cols = 10;
    public int rows = 20;
    public static int sideLength = 22;
    
    public Tiles tile1 = new Tiles();
    public Tiles tile2 = new Tiles();
    public Tiles tile3 = new Tiles();
    public Tiles tile = new Tiles();
    
    public AffineTransform trans = new AffineTransform();
    public AffineTransform trans2 = new AffineTransform();
    public AffineTransform trans3 = new AffineTransform();
    //AffineTransform trans2 = new AffineTransform();
    
    public ArrayList<Tiles> tiles = new ArrayList<>();
    
    public int[] height = {441, 441, 441, 441, 441, 441, 441, 441, 441, 441};
    public ArrayList<Rectangle2D> rectangles = new ArrayList<>();
    public ArrayList<Rectangle2D> currentRectangles = new ArrayList<>();
    public int[][] whole = new int[20][10];
    public int distance = 441;
    
    Thread t;
    public static boolean  run = true;
    public static boolean gameOver = false;
    public int countNumber = 50;
    
    public TetrisPanel(){
        
        //创建线程
        t = new Thread(this);
        
        //启动线程
        t.start();
    }
    
    @Override
    public void paint(Graphics g1){
        Graphics2D g = (Graphics2D) g1;
        super.paint(g);
        g1.create();
        g.setPaint(new Color(176,224,230));
        for(int i = 1; i < rows; i++){
            g.drawLine(1, i * sideLength +1, 221, i * sideLength +1);
        }
        for(int i = 1; i < cols; i++){
            g.drawLine(i * sideLength +1, 1, i * sideLength+1, 441);
        }
        g.setStroke(new BasicStroke(3f));
        g.setPaint(new Color(0,0,139));
        g.drawRect(0, 0, 221, 441);
        
        rectangles = new ArrayList<Rectangle2D>();
        currentRectangles = new ArrayList<Rectangle2D>();
        for(int i = 0; i < tiles.size(); i++){
            if(tiles.get(i).brand == 1){
            g.setColor(Color.cyan);
            Rectangle2D r = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], sideLength, sideLength * 4);
            
            if(tiles.get(i).direction == 1 || tiles.get(i).direction == 3){
                g.fill(r);
                rectangles.add(r);
            }
            if(tiles.get(i).direction == 2 || tiles.get(i).direction == 0){
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 4 *22, 22);
                g.fill(re);
                rectangles.add(re);
            }
        }
        
        if(tiles.get(i).brand == 2){
            g.setColor(Color.BLUE);
            Rectangle2D r = new Rectangle.Float(tiles.get(i).coordinate[0] + sideLength, tiles.get(i).coordinate[1], sideLength, sideLength * 2);
            Rectangle2D r2 = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + sideLength * 2, sideLength * 2, sideLength);
            
            if(tiles.get(i).direction == 1){
                g.fill(r);
                g.fill(r2);
                rectangles.add(r);
                rectangles.add(r2);
            }
            if(tiles.get(i).direction == 2){
                //g.setTransform(trans);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 2 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 2 * 22, tiles.get(i).coordinate[1], 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
                
            }
            if(tiles.get(i).direction == 3){
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 22, 3 * 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1], 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            if(tiles.get(i).direction == 0){
                //g.setTransform(trans3);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + 22, 3 * 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
        }
        
        if(tiles.get(i).brand == 3){
            g.setColor(Color.orange);
            Rectangle2D r = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], sideLength, sideLength *2);
            Rectangle2D r2 = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + sideLength * 2, sideLength * 2, sideLength);
            if(tiles.get(i).direction == 1){
                g.fill(r);
                g.fill(r2);
                rectangles.add(r);
                rectangles.add(r2);
            }
            if(tiles.get(i).direction == 2){
                //g.transform(trans);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + 22, 3 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 2 * 22, tiles.get(i).coordinate[1], 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            if(tiles.get(i).direction == 3){
                //g.transform(trans2);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 2 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1] + 22, 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            if(tiles.get(i).direction == 0){
                //g.transform(trans3);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 3 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
        }
        
        if(tiles.get(i).brand == 4){
            g.setColor(Color.yellow);
            Rectangle2D r = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], sideLength * 2, sideLength * 2);
            g.fill(r);
            rectangles.add(r);
        }
        
        if(tiles.get(i).brand == 5){
            g.setColor(Color.GREEN);
            Rectangle2D r = new Rectangle2D.Float(tiles.get(i).coordinate[0] + sideLength, tiles.get(i).coordinate[1], sideLength * 2, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + sideLength, sideLength * 2, sideLength);
            if(tiles.get(i).direction == 1 || tiles.get(i).direction == 3){
                g.fill(r);
                g.fill(r2);
                rectangles.add(r);
                rectangles.add(r2);
            }
            if(tiles.get(i).direction == 2 || tiles.get(i).direction == 0){
                //g.transform(trans);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 22, 2 * 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1] + 22, 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            
        }
        
        if(tiles.get(i).brand == 6){
            g.setColor(Color.pink);
            Rectangle2D r = new Rectangle2D.Float(tiles.get(i).coordinate[0] + sideLength, tiles.get(i).coordinate[1], sideLength, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + sideLength, sideLength * 3, sideLength);
            if(tiles.get(i).direction == 1){
                g.fill(r);
                g.fill(r2);
                rectangles.add(r);
                rectangles.add(r2);
            }
            if(tiles.get(i).direction == 2){
                //g.transform(trans);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + 22, 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1], 22, 3 * 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            if(tiles.get(i).direction == 3){
                //g.transform(trans2);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 3 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            if(tiles.get(i).direction == 0){
                //g.transform(trans3);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], 22, 3 * 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
        }
        
        if(tiles.get(i).brand == 7){
            g.setColor(Color.red);
            Rectangle2D r = new Rectangle2D.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1], sideLength * 2, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tiles.get(i).coordinate[0] + sideLength, tiles.get(i).coordinate[1] + sideLength, sideLength * 2, sideLength);
            if(tiles.get(i).direction == 1 || tiles.get(i).direction == 3){
                g.fill(r);
                g.fill(r2);
                rectangles.add(r);
                rectangles.add(r2);
            }
            if(tiles.get(i).direction == 2 || tiles.get(i).direction == 0){
                //g.transform(trans);
                //g.draw(r);
                //g.draw(r2);
                Rectangle2D re = new Rectangle.Float(tiles.get(i).coordinate[0], tiles.get(i).coordinate[1] + 22, 22, 2 * 22);
                Rectangle2D re2 = new Rectangle.Float(tiles.get(i).coordinate[0] + 22, tiles.get(i).coordinate[1], 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                rectangles.add(re);
                rectangles.add(re2);
            }
            
        }
        
    }
        
        if(tile.brand == 1){
            g.setColor(Color.cyan);
            Rectangle2D r = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1], sideLength, sideLength * 4);
            if(tile.direction == 1 || tile.direction == 3){
                g.fill(r);
                currentRectangles.add(r);
                
            }
            if(tile.direction == 2 || tile.direction == 0){
                Rectangle2D re = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1], 4 *22, 22);
                g.fill(re);
                currentRectangles.add(re);
            }
        }
        
        if(tile.brand == 2){
            g.setColor(Color.BLUE);
            Rectangle2D r = new Rectangle.Float(tile.coordinate[0] + sideLength, tile.coordinate[1], sideLength, sideLength * 2);
            Rectangle2D r2 = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1] + sideLength * 2, sideLength * 2, sideLength);
            
            if(tile.direction == 1){
                g.fill(r);
                g.fill(r2);
                currentRectangles.add(r);
                currentRectangles.add(r2);
            }
            if(tile.direction == 2){
                Rectangle2D re = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1], 2 * 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tile.coordinate[0] + 2 * 22, tile.coordinate[1], 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 3){
                Rectangle2D re = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1], 22, 3 * 22);
                Rectangle2D re2 = new Rectangle.Float(tile.coordinate[0] + 22, tile.coordinate[1], 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 0){
                Rectangle2D re = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1], 22, 22);
                Rectangle2D re2 = new Rectangle.Float(tile.coordinate[0], tile.coordinate[1] + 22, 3 * 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
        }
        
        if(tile.brand == 3){
            g.setColor(Color.orange);
            Rectangle2D r = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], sideLength, sideLength *2);
            Rectangle2D r2 = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + sideLength * 2, sideLength * 2, sideLength);
            if(tile.direction == 1){
                g.fill(r);
                g.fill(r2);
                currentRectangles.add(r);
                currentRectangles.add(r2);
            }
            if(tile.direction == 2){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + 22, 3 * 22, 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 2 * 22, tile.coordinate[1], 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 3){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], 2 * 22, 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1] + 22, 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 0){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], 3 * 22, 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
        }
        
        if(tile.brand == 4){
            g.setColor(Color.yellow);
            Rectangle2D r = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], sideLength * 2, sideLength * 2);
            g.fill(r);
            currentRectangles.add(r);
        }
        
        if(tile.brand == 5){
            g.setColor(Color.GREEN);
            Rectangle2D r = new Rectangle2D.Float(tile.coordinate[0] + sideLength, tile.coordinate[1], sideLength * 2, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + sideLength, sideLength * 2, sideLength);
            if(tile.direction == 1 || tile.direction == 3){
                g.fill(r);
                g.fill(r2);
                currentRectangles.add(r);
                currentRectangles.add(r2);
            }
            if(tile.direction == 2 || tile.direction == 0){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], 22, 2 * 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1] + 22, 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            
        }
        
        if(tile.brand == 6){
            g.setColor(Color.pink);
            Rectangle2D r = new Rectangle2D.Float(tile.coordinate[0] + sideLength, tile.coordinate[1], sideLength, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + sideLength, sideLength * 3, sideLength);
            if(tile.direction == 1){
                g.fill(r);
                g.fill(r2);
                currentRectangles.add(r);
                currentRectangles.add(r2);
            }
            if(tile.direction == 2){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + 22, 22, 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1], 22, 3 * 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 3){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], 3 * 22, 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            if(tile.direction == 0){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], 22, 3 * 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1] + 22, 22, 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
        }
        
        if(tile.brand == 7){
            g.setColor(Color.red);
            Rectangle2D r = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1], sideLength * 2, sideLength);
            Rectangle2D r2 = new Rectangle2D.Float(tile.coordinate[0] + sideLength, tile.coordinate[1] + sideLength, sideLength * 2, sideLength);
            if(tile.direction == 1 || tile.direction == 3){
                g.fill(r);
                g.fill(r2);
                currentRectangles.add(r);
                currentRectangles.add(r2);
            }
            if(tile.direction == 2 || tile.direction == 0){
                Rectangle2D re = new Rectangle2D.Float(tile.coordinate[0], tile.coordinate[1] + 22, 22, 2 * 22);
                Rectangle2D re2 = new Rectangle2D.Float(tile.coordinate[0] + 22, tile.coordinate[1], 22, 2 * 22);
                g.fill(re);
                g.fill(re2);
                currentRectangles.add(re);
                currentRectangles.add(re2);
            }
            
        }
        
    }
    
    
    
    @Override
    public void run() {
        int count = 0;
        boolean repaint = false;
        while(true){
            try{
                Thread.sleep(20);
                count ++;
                if(count%countNumber == 0){
                    repaint = true;
                }else{
                    repaint = false;
                }
                
            } catch (InterruptedException ex) { }
            
            if(repaint){
                tile.coordinate[1] += 22;
            }
            
            boolean attached = false;
            if(tile.brand == 1){
                if(tile.direction == 1 || tile.direction == 3){
                    if(tile.coordinate[1] + 4 * 22>= height[tile.coordinate[0]/22]){
                        attached = true;
                        height[tile.coordinate[0]/22] -= 4 *22;
                    }
                }else if(tile.direction == 2 || tile.direction == 0){
                    if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp -22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                        height[tile.coordinate[0]/22 + 3] = temp - 22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                        height[tile.coordinate[0]/22 + 3] = temp -22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 2];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                        height[tile.coordinate[0]/22 + 3] = temp -22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22 + 3]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 3];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                        height[tile.coordinate[0]/22 + 3] = temp -22;
                    }
                }
            }else if(tile.brand == 2){
                if(tile.direction == 1){
                    if(tile.coordinate[1] + 3 * 22>= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22 * 3;
                    }else if(tile.coordinate[1] + 3 * 22>= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22 * 3;
                    }
                }else if(tile.direction == 2){
                    if(tile.coordinate[1]+22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 +1] = temp - 22;
                        height[tile.coordinate[0]/22 +2] = temp - 22;
                    }else if(tile.coordinate[1]+22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 +1] = temp - 22;
                        height[tile.coordinate[0]/22 +2] = temp - 22;
                    }else if(tile.coordinate[1] + 2 * 22 >=height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 2];
                        height[tile.coordinate[0]/22] = temp - 2* 22;
                        height[tile.coordinate[0]/22 +1] = temp - 2* 22;
                        height[tile.coordinate[0]/22 +2] = temp - 2* 22;
                    }
                }else if(tile.direction == 3){
                    if(tile.coordinate[1] + 3 * 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 3 * 22;
                    }else if(tile.coordinate[1] + 22 >= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 +1] = temp - 22;
                    }
                }else if(tile.direction == 0){
                    if(tile.coordinate[1] + 2 * 22>= height[tile.coordinate[0]/22]|| tile.coordinate[1] - 2>= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22+ 1] ){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22+ 1];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22; 
                    }
                }
            }else if(tile.brand == 3){
                if(tile.direction == 1){
                    if(tile.coordinate[1] + 3*22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                    }else if(tile.coordinate[1] + 3*22 >= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 +1] = temp - 22;
                    }
                }else if(tile.direction == 2){
                    if(tile.coordinate[1] + 2 * 22>= height[tile.coordinate[0]/22] ){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2* 22;
                    }else if(tile.coordinate[1] + 2 * 22>= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2 * 22;
                    }else if(tile.coordinate[1] + 2 * 22>=height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 2];
                        height[tile.coordinate[0]/22] = temp + 22;
                        height[tile.coordinate[0]/22 + 1] = temp + 22;
                        height[tile.coordinate[0]/22 + 2] = temp + 2 * 22;
                    }
                }else if(tile.direction == 3){
                    if(tile.coordinate[1] + 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp -22;
                    }else if(tile.coordinate[1] + 3 * 22 >= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 +1] = temp - 3 * 22;
                    }
                }else if(tile.direction == 0){
                    if(tile.coordinate[1] + 2 *22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2 * 22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22+ 1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 22>= height[tile.coordinate[0]/22 +2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 2];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }
                }
            }else if(tile.brand == 4){
                if(tile.coordinate[1] + 2 * 22 >= height[tile.coordinate[0]/22]){
                    attached = true;
                    int temp = height[tile.coordinate[0]/22];
                    height[tile.coordinate[0]/22] = temp - 2 * 22;
                    height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                }else if(tile.coordinate[1] + 2 *22 >= height[tile.coordinate[0]/22 +1]){
                    attached = true;
                    int temp = height[tile.coordinate[0]/22 + 1];
                    height[tile.coordinate[0]/22] = temp - 2 * 22;
                    height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                }
            }else if(tile.brand == 5){
                if(tile.direction == 1 || tile.direction == 3){
                    if(tile.coordinate[1] + 2 * 22>= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2 * 22;
                    }else if(tile.coordinate[1] + 2*22 >= height[tile.coordinate[0]/22+1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2 * 22;
                    }else if(tile.coordinate[1] + 22 >= height[tile.coordinate[0]/22 +2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +2];
                        height[tile.coordinate[0]/22 +2] = temp - 22;
                        height[tile.coordinate[0]/22 +1] = temp - 22;
                        height[tile.coordinate[0]/22] = temp;
                    }
                }else if(tile.direction == 2 || tile.direction == 0){
                    if(tile.coordinate[1]+ 2 * 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                    }else if(tile.coordinate[1] + 3 * 22>= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                    }
                }
            }else if(tile.brand == 6){
                if(tile.direction == 1){
                    if(tile.coordinate[1] + 2*22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 2*22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 2*22 >= height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 2];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }
                }else if(tile.direction == 2){
                    if(tile.coordinate[1] + 2 * 22 >= height[tile.coordinate[0]/22] ){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                    }else if(tile.coordinate[1] + 3 * 22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22+ 1];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 3 * 22;
                    }
                }else if(tile.direction == 3){
                    if(tile.coordinate[1] + 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 2 * 22 >= height[tile.coordinate[0]/22 +1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 2 * 22;
                    }else if(tile.coordinate[1] - 22 >= height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22+2];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }
                }else if(tile.direction == 0){
                    if(tile.coordinate[1] + 3 * 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 3 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                    }else if( tile.coordinate[1] + 2 * 22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 + 1];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                    }
                }
            }else if(tile.brand == 7){
                if(tile.direction == 1 || tile.direction == 3){
                    if(tile.coordinate[1] + 22 >= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 22;
                        height[tile.coordinate[0]/22 + 2] = temp;
                    }else if(tile.coordinate[1] + 2 *22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }else if(tile.coordinate[1] + 2*22 >= height[tile.coordinate[0]/22 + 2]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +2];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 2] = temp - 22;
                    }
                }else if(tile.direction == 2 || tile.direction == 0){
                    if(tile.coordinate[1] + 3 * 22>= height[tile.coordinate[0]/22]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22];
                        height[tile.coordinate[0]/22] = temp - 2 * 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 3 * 22;
                    }else if(tile.coordinate[1] +2 * 22 >= height[tile.coordinate[0]/22 + 1]){
                        attached = true;
                        int temp = height[tile.coordinate[0]/22 +1];
                        height[tile.coordinate[0]/22] = temp - 22;
                        height[tile.coordinate[0]/22 + 1] = temp - 2 * 22;
                    }
                }
            }
            //tile.coordinate[1] >= height[tile.coordinate[0]/22] - tile.height
            //for(int i = 0; i < 20; i ++){
              //  boolean full = true;
                //for(int j = 0; j < 10; j ++){
                  //  if(height[j] < 441 - 22 * i){
                    //    full = false;
                      //  break;
                    //}
                //}
                //if(full){
                  //  for(int k = 0; k < tiles.size(); k ++){
                    //    tiles.get(k).coordinate[1] -= 22;
                   // }
              //  }
           // }
            
            if(attached){
                tiles.add(tile);
                
                tile = tile1;
                tile1 = tile2;
                tile2 = tile3;
                tile3 = new Tiles();
                
                countNumber = 50;
            }
            boolean exceed = false;
            for(int i = 0; i < 10; i ++){
                if(height[i] <= 1){
                    t.stop();
                    run = false;
                    gameOver = true;
                }
            }
        
            repaint();
        }
    }

    //keyListener接口
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(tile.coordinate[0] >= 23){
                tile.coordinate[0] -= 22;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
   
    }
    
}
