package lesson7.serializator;
import lesson7.student.Student;

import java.io.IOException;

public interface Serializator{

    /**
     * Сериализует класс {@link lesson7.student.Student}
     * @param o объект
     * @param fileName имя файла
     */

    void serialize(Object o, String fileName) throws IOException;

    Student deserialize(String fileName) throws IOException, ClassNotFoundException;

}
