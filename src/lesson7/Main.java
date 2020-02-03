package lesson7;

import lesson7.serializator.Serializator;
import lesson7.serializator.impl.SerializatorImpl;
import lesson7.student.Student;

import java.io.IOException;

public class Main {

    public static final String FILENAME = "student";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Ivan", "Ivanon", 23, 1);
        Serializator serializator = new SerializatorImpl();
        serializator.serialize(student, FILENAME);
        System.out.println(student.getSecondName());
        Student outStudent =  serializator.deserialize(FILENAME);
        System.out.println(outStudent.getSecondName() + outStudent.getAge());
    }
}
