package Lesson7HomeWork.serializator.impl;

import Lesson7HomeWork.Handler;
import Lesson7HomeWork.serializator.Serializator;

import java.io.*;

public class SerializatorImpl implements Serializator {

    @Override
    public void serialize(Object o, String fileName) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {

            objectOutputStream.writeObject(o);

        }
    }

    @Override
    public Handler deserialize(String fileName) throws IOException, ClassNotFoundException {
        try(
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                )
        {
            return (Handler) objectInputStream.readObject();
        }
    }
}
