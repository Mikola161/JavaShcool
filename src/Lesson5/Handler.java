package Lesson5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.lang.reflect.InvocationTargetException;

public class Handler<K, B> implements InvocationHandler {
    private Object object;
    private Map<K, B> map = new HashMap<>();

    public  Handler (MyClass object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {

        if (args!= null) {
            for (Object arg : args) {
                if (method.isAnnotationPresent(Cash.class)) {
                    if (map.containsKey(arg)) {
                        System.out.println("The value from cash");
                    } else {
                        map.put((K)arg, (B) method.invoke(object, arg));
                    }
                    System.out.println("For key: " + arg + ", the value is: " + map.get(arg));
                    return map.get(arg);
                }
                else return method.invoke(object, args);
            }
        }
        return null;
    }
}
