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
public class Course implements Serializable{
    
    public String name;
    public ArrayList<Student> students;

    public Course(String name) {
        setName(name);
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

     public void setName(String name) {
        if(Validation.validateName(name))
        this.name = name;
        else this.name = new String();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public static void addStudent(Student s, Course c){
        if(!c.students.contains(s)) c.students.add(s);
    }
    public static void removeStudent(Student s, Course c){
        if(c.students.contains(s)) c.students.remove(s);
    }
        public static void save (ArrayList<Course> courses, String path) throws FileNotFoundException, IOException{
        if (courses.isEmpty()){
            System.out.println("No data to save");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (path))) {
            oos.writeObject(courses);
        }
    }
   public static ArrayList<Course> load(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
        ArrayList<Course> temp = new ArrayList<>((ArrayList<Course>) ois.readObject());
        if (temp.isEmpty()) 
            return new ArrayList<Course>();
        else 
            return temp;
    }
   }
   
   public static float getHighest(Course c){
       float max = 0;
       for(short i=0; i<c.students.size(); i++){
          if(c.students.get(i).getGrade()>max)
              max = c.students.get(i).getGrade();
       }
       return max;
   }
   public static float getLowest(Course c){
       float min = 100;
       for(short i=0; i<c.students.size(); i++){
          if(c.students.get(i).getGrade()<min)
              min = c.students.get(i).getGrade();
       }
       return min;
   }
   public static float getAverage(Course c){
       float sum = 0;
       for(short i=0; i<c.students.size(); i++){
              sum += c.students.get(i).getGrade();
       }
       return (sum/c.students.size());
   }
    
}
