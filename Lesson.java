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
public class Lesson {
    public String lessonTitle;
    public int durationMinutes;
    public boolean requireLab;
    
    public Lesson(String l, int d, boolean r){
        this.lessonTitle = l;
        this.durationMinutes = d;
        this.requireLab = r;
    }
    
    public void outputLessonDetails(){
        System.out.println("Course name: " + this.lessonTitle);
        System.out.println("Time duration: " + this.durationMinutes + " minutes");
        if(this.requireLab){
            System.out.println("Lab required");
        }else{
            System.out.println("Lab not required");
        }
    }
}
