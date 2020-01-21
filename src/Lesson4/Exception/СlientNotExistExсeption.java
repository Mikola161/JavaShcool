package Lesson4.Exception;

public class СlientNotExistExсeption extends Exception {
    public СlientNotExistExсeption(){super("Client is't exist");}
    public СlientNotExistExсeption(String gripe){
        super(gripe);
    }
}
