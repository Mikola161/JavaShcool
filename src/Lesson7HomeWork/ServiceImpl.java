package Lesson7HomeWork;

import java.io.Serializable;

public class ServiceImpl implements Service, Serializable {



    @Cash(cashType = CashType.FILE, zip = true)
    @Override
    public double doHardWork(String string, double value) {
        return value;
    }
}
