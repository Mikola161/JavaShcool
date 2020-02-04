package lesson7Lecture.serializator;
import lesson7Lecture.student.Student;

import java.io.IOException;

public interface Serializator{

    /**
     * Сериализует класс {@link Lesson7HomeWork.ServiceImpl}
     * @param o объект
     * @param fileName имя файла
     */

    void serialize(Object o, String fileName) throws IOException;

    Student deserialize(String fileName) throws IOException, ClassNotFoundException;

}
