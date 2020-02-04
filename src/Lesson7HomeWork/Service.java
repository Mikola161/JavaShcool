package Lesson7HomeWork;

public interface Service {

    @Cash(cashType = CashType.FILE, zip = true)
    double doHardWork(String string, double value);
}
