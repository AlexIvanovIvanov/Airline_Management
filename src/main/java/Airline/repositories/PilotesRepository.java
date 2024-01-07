package Airline.repositories;

import Airline.models.person.Pilot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PilotesRepository implements Repository<Pilot>{

    //fields
    private Collection<Pilot> pilots;

    //Constructor
    public PilotesRepository() {
        this.pilots = new ArrayList<>();
    }

    //methods from the interface
    @Override
    public Collection<Pilot> getRepositoryData() {
        return Collections.unmodifiableCollection(pilots);
    }

    @Override
    public void add(Pilot pilot) {
    this.pilots.add(pilot);
    }

    @Override
    public boolean remove(Pilot pilot) {
        return this.pilots.remove(pilot);
    }

    public Pilot findByPilotNumber(int pilotNumber) {
        return this.pilots.stream().filter(p->p.getPilotNumber() == pilotNumber).findFirst().orElse(null);
    }
}
