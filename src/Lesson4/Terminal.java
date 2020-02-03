package Lesson4;

public interface Terminal {
    TerminalServer server();
    void addClient(Person person, double money, int pinCode);
    void enterPinCode(Person person) throws Exception;
    void putDeposit(int money, Person person) throws Exception;
    void getDeposit(int money, Person person);
    void balance(Person person);
}
