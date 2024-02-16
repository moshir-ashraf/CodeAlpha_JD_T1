/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task1;

import java.io.EOFException;
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
public class Teacher implements Serializable {
    
    
    public String name;
    public static int EID = 0;
    public int ID;
    public String email;
    public String password;
    public ArrayList<Course> courses;
    public Teacher() {
        this("","","");
    }

    public Teacher(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        ID = EID++;
        courses = new ArrayList();
    }

    public String getName() {
        return name;
    }

     public void setName(String name) {
        if(Validation.validateName(name))
        this.name = name;
        else this.name = new String();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(Validation.validateEmail(email))
        this.email = email;
        else this.email = new String();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(Validation.validatePassword(password,name,email))
        this.password = password;
        else this.password = "password";
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course c){
        if(!courses.contains(c)) courses.add(c);
    }
    public void removeCourse(Course c){
        if(courses.contains(c)) courses.remove(c);
    }
    public void addStudentToCourse(Course c, Student s){
       Course.addStudent(s,c);
    }
    public void removeStudentFromCourse (Course c, Student s){
        Course.removeStudent(s, c);
    }
    public void setGrade(Student s, float grade){
        for(short i = 0; i<courses.size(); i++){
            if(courses.get(i).students.contains(s))
                Student.setGrade(grade, s);
        }
    }
     public static void save (ArrayList<Teacher> teachers, String path) throws FileNotFoundException, IOException{
        if (teachers.isEmpty()){
            System.out.println("No data to save");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (path))) {
            oos.writeObject(teachers);
        }
    }
  public static ArrayList<Teacher> load(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
        ArrayList<Teacher> temp = (ArrayList<Teacher>) ois.readObject();
        return temp;
    } catch (FileNotFoundException | EOFException ex) {
        return null;
    }
}

    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + ", ID=" + ID + ", email=" + email + '}';
    }

}
