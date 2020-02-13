package Lesson7HomeWork;


import Lesson7HomeWork.serializator.Serializator;
import Lesson7HomeWork.serializator.impl.SerializatorImpl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Handler implements InvocationHandler, Serializable {
    private Object object;
    private Map map = new HashMap<>();
    private static final String FILENAME  = "Service";
    transient private Serializator serializator = new SerializatorImpl();
    private File file = new File(FILENAME);

    public Handler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        try {
            System.out.println(map.toString());
            if (args != null) {
                if (file.exists()){
                    Handler oldHandler = serializator.deserialize(FILENAME);
                    this.map = oldHandler.getMap();
                }

                if (method.isAnnotationPresent(Cash.class)) {
                    Cash annotation = method.getAnnotation(Cash.class);

                    if (annotation.zip()){
                        System.out.println("You need zip file");
                    }

                    if (this.map.containsKey(args[0])) {
                        System.out.println("The value from cash");
                    } else {
                        map.put(args[0], method.invoke(object, args));
                    }

                    if (annotation.cashType() == CashType.FILE) {
                        serializator.serialize(this, FILENAME);
                    }

                    System.out.println("For key: " + args[0] + ", the value is: " + map.get(args[0]));
                    return map.get(args[0]);

                } else return method.invoke(object, args);

            }
            return null;
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private Map getMap(){
        return this.map;
    }
}
