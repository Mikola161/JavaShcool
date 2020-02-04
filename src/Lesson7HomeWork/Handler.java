package Lesson7HomeWork;

import lesson7Lecture.serializator.Serializator;
import lesson7Lecture.serializator.impl.SerializatorImpl;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Handler implements InvocationHandler {
    private Object object;
    private Map<String, Double> map = new HashMap<>();
    private static final String FILENAME  = "Service";
    private Serializator serializator = new SerializatorImpl();
    public Handler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        try {
            if (args != null) {
                if (method.isAnnotationPresent(Cash.class)) {
                    Cash annotation = method.getAnnotation(Cash.class);
                    if (annotation.cashType() == CashType.FILE) {
                        serializator.serialize(object, FILENAME);
                    }
                    if (annotation.zip() == true){
                        System.out.println("You need zip file");
                    }

                    if (map.containsKey(args[0])) {
                        System.out.println("The value from cash");
                    } else {
                        map.put((String) args[0], (Double) method.invoke(object, args));
                    }
                    System.out.println("For key: " + args[0] + ", the value is: " + map.get(args[0]));
                    return map.get(args[0]);
                } else return method.invoke(object, args);

            }
            return null;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
