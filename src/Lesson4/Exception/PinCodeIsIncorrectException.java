package Lesson4.Exception;

public class PinCodeIsIncorrectException extends Exception {
    public PinCodeIsIncorrectException(){super("Wrong pin-code!");}
    public PinCodeIsIncorrectException(String gripe){
        super(gripe);
    }
}
