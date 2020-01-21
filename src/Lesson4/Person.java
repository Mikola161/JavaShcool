package Lesson4;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean equals(Person other){
        if (!(other instanceof Person)) return false;
        if (other == null) return false;
        Person o = (Person) other;
        return this.name.equals(o.name) & this.surname.equals(o.surname);
    }
}
