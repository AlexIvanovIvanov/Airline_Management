package Airline.models.tool;

import Airline.common.ExceptionMessages;

public class ToolImpl implements Tool {
    //descriprtion of the tool


    //fields
    private int power;


    //constructor

    public ToolImpl(int power) {
        this.setPower(power);
    }


    //power setter and getter

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {         //create from met by "geenrate getters and setters"
        return power;
    }

    // methods from the interface


    @Override
    public void decreasesPower() {
        int currentPower = this.getPower();
        currentPower -= 5;
        if (currentPower < 0) {
            currentPower = 0;
        }
        this.setPower(currentPower);
    }

    @Override
    public boolean isUnfit() {
        return this.getPower() > 0;    //    return this.getPower() == 0
    }
}
