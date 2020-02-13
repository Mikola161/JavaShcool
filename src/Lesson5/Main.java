package Lesson5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        Class clas = myClass.getClass();
        Handler handler = new Handler<>(myClass);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(myClass.getClass().getClassLoader(),
                                                                    myClass.getClass().getInterfaces(),
                                                                    handler);

        try {
            while (clas != null){
                Method[] methods = clas.getDeclaredMethods();
                Field[] fields = clas.getDeclaredFields();
                System.out.println("The class: " + clas.getName());

                for(Field f : fields){
                    f.setAccessible(true);
                    System.out.println("Field: " + f.getName());
                    if(Modifier.isStatic(f.getModifiers())
                            & Modifier.isFinal(f.getModifiers())
                            & f.getType().toString().contains("String")
                            & f.getName().equals(f.get(myClass))){
                        System.out.println("The field's type is String. The value of field " + f.getName() + " equals name");
                    }
                }

                for (Method m : methods){
                    System.out.println("Method: " + m.getName());
                    if (m.getName().indexOf("get") == 0 ){
                        System.out.println("Getter: " + m.getName());
                    }
                }
                clas = clas.getSuperclass();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        proxy.sum(2);
        proxy.sum(4);
        proxy.sum(2);

        proxy.word("Hello");
        proxy.word("Help");
        proxy.word("Hello");

    }
}
