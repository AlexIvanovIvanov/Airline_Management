package Airline.models.plane;

import Airline.models.person.Pilot;

public interface Plane {
    int getPlaneNumber();

    String getPaneManufacturer_Model();

    void setPilot(Pilot pilot);
}
