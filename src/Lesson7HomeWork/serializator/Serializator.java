package Lesson7HomeWork.serializator;
import lesson7Lecture.student.Student;

import java.io.IOException;

public interface Serializator{

    /**
     * Сериализует класс {@link Student}
     * @param o объект
     * @param fileName имя файла
     */

    void serialize(Object o, String fileName) throws IOException;

    Student deserialize(String fileName) throws IOException, ClassNotFoundException;

}
