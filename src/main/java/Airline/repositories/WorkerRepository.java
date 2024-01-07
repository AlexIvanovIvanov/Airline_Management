package Airline.repositories;

import Airline.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkerRepository implements Repository<Worker>{
    //depo za syhranenie na rabotnici


    //fields
    private Collection<Worker> workers;

    //constructor
    public WorkerRepository() {  // not in the task
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getRepositoryData() {
        return null;
    }

    @Override
    public void add(Worker model) {
        this.workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        return workers.remove(model);
    }

   // @Override
    public Worker findByName(String name) {
        return workers.stream()
                .filter(w -> w.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }






}
