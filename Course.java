/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.util.ArrayList;

/**
 *
 * @author kaiyingshan
 */
public class Course{

    /**
     * @param args the command line arguments
     */
    
    public String courseTitle;
    public int maxStudents;
    public ArrayList<Lesson> courseLesson = new ArrayList<>();
    public Assessment courseAssessment;
    
    public Course(String ct, int ms){
        this.courseTitle = ct;
        this.maxStudents = ms;
    }
    
    public void addLesson(String lessonTitle, int durationMinutes, boolean requireLab){
        if(courseLesson.size()< 50){
            Lesson l = new Lesson(lessonTitle, durationMinutes, requireLab);
            courseLesson.add(l);
        }
    }
    
    public void addAssessment(String assessmentTitle, int maxMark){
        this.courseAssessment = new Assessment(assessmentTitle, maxMark);
    }
    
    public void outputCourseDetails(){
        System.out.println("Course name: " + this.courseTitle);
        System.out.println("Student #: " + this.maxStudents);
        System.out.println("Lessons: ");
        for(Lesson c: courseLesson){
            c.outputLessonDetails();
        }
        System.out.println("Assessment: ");
        this.courseAssessment.outputAssessmentDetils();
    }
    
    
    public static void main(String[] args) {
        Course cs = new Course("Computer Science", 40);
        cs.addLesson("program design", 80, true);
        cs.addLesson("data structure", 160, true);
        cs.addLesson("mathematics analysis", 80, false);
        cs.addLesson("discrete mathematics", 160, false);
        cs.addLesson("algorithm", 160, true);
        cs.addAssessment("programming task: union find", 100);
        
        cs.outputCourseDetails();
    }

    
    
}
