package Lesson7HomeWork;

import java.lang.reflect.Proxy;

public class Main {
    public static void main (String[] args){
        ServiceImpl service = new ServiceImpl();
        Handler handler = new Handler(service);
        Service proxy =(Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        System.out.println(proxy.doHardWork("Work2", 10D));
        System.out.println(proxy.doHardWork("Work3", 20D));
    }
}
