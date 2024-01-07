package Airline.models.vehicle;

import Airline.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {

    //fields
    private String name;
    private int strengthRequired;

    //constructor
    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }


    // getters and setters for teh name

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    //getters and setters for strengthRequired


    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }

        this.strengthRequired = strengthRequired;
    }

    //methods from the interface

    @Override
    public boolean reached() {
        return this.getStrengthRequired() == 0;
    }

    @Override
    public void making() {
        int currentStrength = this.getStrengthRequired();
        currentStrength -= 5;
        if (currentStrength < 0) {
            currentStrength = 0;
        }

        this.setStrengthRequired(currentStrength);
    }
}
