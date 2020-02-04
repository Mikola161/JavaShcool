package Lesson7HomeWork;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cash {
    CashType cashType() default CashType.JVM;
    int ignoreValue() default 0;
    boolean zip() default false;
}



