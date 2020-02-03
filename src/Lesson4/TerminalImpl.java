package Lesson4;

import Lesson4.Exception.AccessDeniedException;

import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private PinValidator pinValidator;
    private TerminalServer server;
    private  boolean accessTerminal;
    private Person person;

    public TerminalImpl() {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator();
    }

    public TerminalServer server(){
        return server;
    }

    public void addClient(Person person, double money, int pinCode){
        server.addClient(money, person, pinCode);
    }

    public void enterPinCode(Person person)  {
        try {
            Scanner in = new Scanner(System.in);
            if (!server.depositStatus(person)) {
                System.out.printf("Enter pin-code for client, Name: %s, Surname: %s.\nPin-Code:  ", person.getName(), person.getSurname());
                int pinCode = in.nextInt();
                if (pinValidator.comparePinCode(pinCode, server, person)) accessTerminal = true;
                else {
                    accessTerminal = false;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void putDeposit(int money, Person person){
        try {
            enterPinCode(person);
            if (accessTerminal) server.putDeposit(money, person);
            else throw new AccessDeniedException();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getDeposit(int money, Person person){
        try {
            enterPinCode(person);
            if (accessTerminal) server.getDeposit(money, person);
            else throw new AccessDeniedException();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void balance(Person person){
        try {
            enterPinCode(person);
            if (accessTerminal) {
                double balance = server.balance(person);
                System.out.println("Your balance is: " + balance);
            } else throw new AccessDeniedException();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
