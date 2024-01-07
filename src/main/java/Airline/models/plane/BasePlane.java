package Airline.models.plane;

import Airline.models.person.Pilot;

public abstract class BasePlane implements Plane{

    //fields
    private int planeNumber;
    private String paneManufacturer_Model;
    private Pilot planesPilot;

    //Constructor
    public BasePlane(int planeNumber, String paneManufacturer_Model) {
        this.planeNumber = planeNumber;
        this.paneManufacturer_Model = paneManufacturer_Model;
    }

    //metods
    public void setPlanesPilot(Pilot planesPilot) {
        this.planesPilot = planesPilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        this.planesPilot = pilot;
    }

    @Override
    public int getPlaneNumber() {
        return this.planeNumber;
    }

    @Override
    public String getPaneManufacturer_Model() {
        return this.paneManufacturer_Model;
    }

    public Pilot getPlanesPilot() {
        return this.planesPilot;
    }




}
