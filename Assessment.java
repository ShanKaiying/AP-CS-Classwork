/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

/**
 *
 * @author kaiyingshan
 */
public class Assessment {
    public String assessmentTitle;
    public int maxMark;
    public Assessment(String a, int m){
        this.assessmentTitle = a;
        this.maxMark = m;
    }
    
    public void outputAssessmentDetils(){
        System.out.println("Assessment title: " + this.assessmentTitle);
        System.out.println("Max mark:" + this.maxMark);
    }
}
