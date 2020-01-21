package Lesson4.Exception;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){ super("Insufficient funds in the account");}
    public InsufficientFundsException(String gripe){
        super(gripe);
    }
}
