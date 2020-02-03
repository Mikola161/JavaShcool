package Lesson4;

import Lesson4.Exception.InsufficientFundsException;
import Lesson4.Exception.NotMultipleException;

public class Deposit {
    private int numberOfDeposit;
    private double money;
    private Person person;
    private int pinCode;
    boolean blockStatus;

   public Deposit(int numberOfDeposit, double money, Person person, int pinCode){
        this.numberOfDeposit = numberOfDeposit;
        this.money = money;
        this.person = person;
        this.pinCode = pinCode;
        this.blockStatus = false;
    }

    public int getNumberOfDeposit() {
        return numberOfDeposit;
    }

    public double getMoney() {
        return money;
    }

    public Person getPerson() {
        return person;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void putMoney(int money) throws Exception{
       if((money % 100) == 0) this.money = this.money + money;
       else throw new NotMultipleException();
    }

    public void takeMoney(int money) throws Exception{
       if (this.money >= money) this.money = this.money - money;
       else throw  new InsufficientFundsException();
    }

    public boolean comparePinCode(int pinCode){
        return this.pinCode == pinCode;
    }

    public void setBlockStatus(boolean status){
       this.blockStatus = status;
    }
}
