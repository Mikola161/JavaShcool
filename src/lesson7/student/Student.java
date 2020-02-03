package lesson7.student;

import lesson7.human.Human;

import java.io.Serializable;

public class Student extends Human implements Serializable {
    private int course;


    public Student(String firstName, String secondName, int age, int course) {
        super(firstName, secondName, age);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

}
