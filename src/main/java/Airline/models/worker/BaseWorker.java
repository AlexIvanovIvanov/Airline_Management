package Airline.models.worker;

import Airline.common.ExceptionMessages;
import Airline.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker {

    //fields

    private String name;
    private int strength;                   //The strength of a worker.
    private Collection<Tool> tools;

    //constructor

    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    //name getters and setters

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    //strength getters and setters

    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;
    }

    //toos getters and setters

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    // methods from the interface Worker

    @Override
    public void working() {
        int currentStrength = this.getStrength();
        currentStrength -= 10;
        if (currentStrength < 0) {
            currentStrength = 0;
        }
        this.setStrength(currentStrength);
    }

    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.getStrength() > 0;   //if > 0 true else false
    }

    @Override
    public String toString() {
        long leftTools = this.tools.stream().filter(tool -> tool.getPower()>0).count();              //xxxxxxxxxxx filtrirame samo instrument sys sila po golqma ot 0 i gi broim

        StringBuilder sb =new StringBuilder();
        sb.append("Name: " + name+", Strength: "+ strength).append(System.lineSeparator());
        sb.append("Tools: "+ leftTools + "fit left").append(System.lineSeparator());
        return sb.toString().trim();
    }
}
