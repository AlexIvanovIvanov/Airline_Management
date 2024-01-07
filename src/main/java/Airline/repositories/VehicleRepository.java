package Airline.repositories;

import Airline.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;

public class VehicleRepository implements Repository<Vehicle>{
    //The vehicle repository is a repository for vehicles that await to be made.

    //fields
    private Collection<Vehicle> vehicles;

    //constructor
    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getRepositoryData() {
        return null;
    }


    //methods from the interface


    @Override
    public void add(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public boolean remove(Vehicle model) {
        return this.vehicles.remove(model); //will return true if this is possible
    }

    //@Override
    public Vehicle findByName(String name) {
        return this.vehicles.stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElse(null);
    }



}
