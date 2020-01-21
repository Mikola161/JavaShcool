package Lesson4.Exception;

public class BlockDepositException extends Exception {
    public BlockDepositException(){super("You enter wrong ping-code 3 times! Deposit is locked.");}
    public BlockDepositException(String gripe){
        super(gripe);
    }
}
