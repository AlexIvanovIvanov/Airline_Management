package Airline.repositories;

import Airline.models.plane.Plane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlaneRepository implements Repository<Plane>{

    //fields
    private Collection<Plane> planes;


    //Constructor
    public PlaneRepository() {
        this.planes= new ArrayList<>();
    }

    //methods from the interface
    @Override
    public Collection<Plane> getRepositoryData() {
        return Collections.unmodifiableCollection(planes);
    }

    @Override
    public void add(Plane plane) {
        this.planes.add(plane);
    }

    @Override
    public boolean remove(Plane plane) {
        return this.planes.remove(plane);
    }

    public Plane findByPlaneNumber(int planeNumebr) {
        return this.planes.stream().filter(p->p.getPlaneNumber() == planeNumebr).findFirst().orElse(null);
    }
}
