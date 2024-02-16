/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Misho
 */
public class Student implements Serializable {
    public String name;
    public float grade;
    public static int SID = 0;
    public int ID;

    public Student() {
        ID = SID++;
    }
  
    public static void setName(String name, Student s) {
        if(Validation.validateName(name))
        s.name = name;
        else s.name = new String();
    }

    public static void setGrade(float grade, Student s) {
        if(Validation.validateGrade(grade))
        s.grade = grade;
        else s.grade = 0;
    }
    
    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    public int getID() {
        return ID;
    }
    public String gradeToLetter(){
        if(grade>=90) return "A";
        else if(grade < 90 && grade >= 85) return "A-";
        else if(grade < 85 && grade >= 80) return "B+";
        else if(grade < 80 && grade >= 75) return "B";
        else if(grade < 75 && grade >- 70) return "B-";
        else if(grade < 70 && grade >= 65) return "C+";
        else if(grade < 65 && grade >= 60) return "C";
        else if(grade < 60 && grade >= 55) return "C-";
        else if(grade < 55 && grade >= 52.5) return "D+";
        else if(grade >= 50) return "D";
        else return "F";
    }

}
