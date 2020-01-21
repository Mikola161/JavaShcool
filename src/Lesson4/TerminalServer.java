package Lesson4;

import Lesson4.Exception.СlientNotExistExсeption;

import java.util.HashMap;
import java.util.Map;

public class TerminalServer {
    private Map<Integer, Deposit> clientsMap = new HashMap<>();
    private Deposit deposit;
    Integer depositNumber = 0;

    public boolean depositStatus(Person person) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        Deposit d = clientsMap.get(depositNumber);
        return d.blockStatus;
    }

    public void addClient(double money, Person person, int pinCode){
        depositNumber++;
        deposit = new Deposit(depositNumber, money, person, pinCode);
        clientsMap.put(depositNumber, deposit);
    }

    public boolean containsDeposit(Person person){
        for(Map.Entry<Integer, Deposit> element : clientsMap.entrySet()){
            if(element.getValue().getPerson().equals(person)){
                return true;
            }
        }
        return false;
    }

    private Integer getDepositNumber(Person person) throws Exception{
        for(Map.Entry<Integer, Deposit> element : clientsMap.entrySet()){
            if(element.getValue().getPerson().equals(person)){
                return element.getValue().getNumberOfDeposit();
            }
        }
        throw new СlientNotExistExсeption();
    }

    public void putDeposit(int money, Person person) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        Deposit d = clientsMap.get(depositNumber);
        d.putMoney(money);
    }

    public void blockDeposit(Person person) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        Deposit d = clientsMap.get(depositNumber);
        d.setBlockStatus(true);
    }

    public boolean comparePinCode(Person person, int pinCode) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        return clientsMap.get(depositNumber).comparePinCode(pinCode);
    }

    public void getDeposit(int money, Person person) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        Deposit d = clientsMap.get(depositNumber);
        d.takeMoney(money);
    }

    public double balance(Person person) throws Exception {
        Integer depositNumber = getDepositNumber(person);
        Deposit d = clientsMap.get(depositNumber);
        return d.getMoney();
    }

}
