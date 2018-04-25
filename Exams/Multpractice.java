/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2007;

/**
 *
 * @author kaiyingshan
 */
public class Multpractice implements StudyPractice{
    private int firstNum;
    private int secNum;
    
    public Multpractice(int i, int j){
        this.firstNum = i;
        this.secNum = j;
    }

    @Override
    public String getProblem() {
        return this.firstNum + " TIMES " + this.secNum;
    }

    @Override
    public void nextProblem() {
        this.secNum ++;
    }
    
    public static void main(String[] args){
        Multpractice m = new Multpractice(1,2);
        for(int i = 0; i < 10; i ++){
            System.out.println(m.getProblem());
            m.nextProblem();
        }
    }
    
}
