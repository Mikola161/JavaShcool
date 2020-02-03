package Lesson5;

public class MyClass implements MyInterface {
    private int number;
    private String string;
    public static final String MONDAY ="MONDAY";

    public MyClass(){
        this.number = 1;
        this.string = "Hello";
    }

    @Override
    public int getNumber(){
        return number;
    }

    public String getString(){
        return string;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int sum(int i){
        int result = ++i;
        System.out.println(result);
        return i;
    }

    @Override
    public String word(String s) {
        return s + "!";
    }
}
