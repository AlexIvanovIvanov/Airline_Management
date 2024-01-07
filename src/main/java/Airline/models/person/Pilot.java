package Airline.models.person;

public class Pilot extends BasePerson{

    int pilotNumber;
    int flyingHours;

    public Pilot(String firstName, String secondName, int age, int pilotNumber, int flyingHours) {
        super(firstName, secondName, age);
        this.pilotNumber = pilotNumber;
        this.flyingHours = flyingHours;
    }

    public int getPilotNumber() {
        return pilotNumber;
    }

    public int getFlyingHours() {
        return flyingHours;
    }
}
