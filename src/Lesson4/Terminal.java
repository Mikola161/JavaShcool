package Lesson4;

public interface Terminal {
    public TerminalServer server();
    public void addClient(Person person, double money, int pinCode);
    public void enterPinCode(Person person) throws Exception;
    public void putDeposit(int money, Person person) throws Exception;
    public void getDeposit(int money, Person person);
    public void balance(Person person);




}
