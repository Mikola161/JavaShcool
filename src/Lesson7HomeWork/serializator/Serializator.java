package Lesson7HomeWork.serializator;
import Lesson7HomeWork.Handler;

import java.io.IOException;

public interface Serializator{

    /**
     * Сериализует класс {@link Lesson7HomeWork.ServiceImpl}
     * @param o объект
     * @param fileName имя файла
     */

    void serialize(Object o, String fileName) throws IOException;

    Handler deserialize(String fileName) throws IOException, ClassNotFoundException;

}
