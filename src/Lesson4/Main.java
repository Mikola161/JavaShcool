package Lesson4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  Exception{
        Person ivanovIvan = new Person("Ivan", "Ivanov");
        Person petrovPetr = new Person("Petr", "Petrov");
        TerminalImpl terminal = new TerminalImpl();
        terminal.addClient(ivanovIvan, 1000, 1234);
        terminal.addClient(petrovPetr, 2000, 4321);
        terminal.addClient(new Person("Sidor", "Sidorov"),10000,2222);
//        terminal.balance(ivanovIvan);
//        terminal.balance(petrovPetr);
//        terminal.balance(new Person("Sidor", "Sidorov"));
//        terminal.getDeposit(500, ivanovIvan);
//        terminal.balance(ivanovIvan);
        terminal.putDeposit(550, petrovPetr);
        terminal.balance(petrovPetr);
        Scanner in = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = in.nextLine();
        System.out.println("Input secondname: ");
        String surname = in.nextLine();
        Person client = new Person(name, surname);
        terminal.balance(client);

    }
}
