/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import static java.awt.BorderLayout.NORTH;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author kaiyingshan
 */
public class TetrisFrame extends JFrame implements KeyListener{
    //public int line = 0;
    //public JLabel l1 = new JLabel("Score: " + line);
    TetrisPanel tp = new TetrisPanel();
    //JPanel p = new JPanel();
    //JTextArea l = new JTextArea("Introduction: This is a demo version of the game Tetris. The actions are controlled by keys. The \"up\" key means change direction 90 degree clockwise, \"down\" means to bottom, left is to left, and right is to right.");
    
    
    public TetrisFrame(){
        super("Tetris Game");
        Container c = this.getContentPane(); //获取面板容器
        
        c.add(tp);
        tp.setBounds(0, 0, 222, 442);
        tp.setBackground(new Color(176,196,222));
        this.addKeyListener(this);
        tp.setOpaque(true);
        this.setBounds(20, 20, 350, 550);
        
        
        //接下来设置位置和大小，然后可以加一些其他的元素.
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args){
        TetrisFrame tf = new TetrisFrame();
        if(TetrisPanel.run == false){
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            boolean inside = false;
            for(int i = 0; i < tp.currentRectangles.size(); i++){
                for(int j = 0; j < tp.rectangles.size(); j ++){
                    if(tp.currentRectangles.get(i).getMinX()>=tp.rectangles.get(j).getMinX() && tp.currentRectangles.get(i).getMinX()<=tp.rectangles.get(j).getMaxX() && tp.currentRectangles.get(i).getMinY()>=tp.rectangles.get(j).getMinY() && tp.currentRectangles.get(i).getMinY()<=tp.rectangles.get(j).getMaxY()){
                        inside = true;
                    }
                }
            }
            if(tp.tile.coordinate[0] >= 22 && tp.tile.coordinate[0] < 44 ){
                tp.tile.coordinate[0] = 1;
            }else if(tp.tile.coordinate[0] >= 44){
                tp.tile.coordinate[0] -= 22;
            }
            if(inside){
                tp.tile.coordinate[0] += 22;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(tp.tile.coordinate[0] + tp.tile.width <= 225 && tp.tile.coordinate[0] + tp.tile.width >= 198){
                tp.tile.coordinate[0] = 221 - tp.tile.width;
            }else if(tp.tile.coordinate[0] < 198){
                tp.tile.coordinate[0] += 22;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            tp.tile.changeDirection();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(TetrisPanel.run == true){
                tp.t.suspend();
                TetrisPanel.run = false;
            }else if (TetrisPanel.run == false && TetrisPanel.gameOver == false){
                tp.t.resume();
                TetrisPanel.run = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            tp.countNumber = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
