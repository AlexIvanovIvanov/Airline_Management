package Airline.models.shop;

import Airline.models.vehicle.Vehicle;
import Airline.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
