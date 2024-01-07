package Airline.models.person;

public abstract class BasePerson implements Person{

    //fields
    private String firstName;
    private String secondName;
    private int age;

    //constructor
    public BasePerson(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.firstName + " " +this.secondName;
    }


}
