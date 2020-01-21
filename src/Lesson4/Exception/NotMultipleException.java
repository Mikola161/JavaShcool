package Lesson4.Exception;

public class NotMultipleException extends Exception{
    public NotMultipleException(){super("Contribution amount is not a multiple of 100");}
    public NotMultipleException(String gripe){
        super(gripe);
    }
}
