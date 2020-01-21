package Lesson4.Exception;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(){super("Wrong pin-code! Access denied!");}
    public AccessDeniedException(String gripe){
        super(gripe);
    }
}
