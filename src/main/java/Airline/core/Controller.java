package Airline.core;

public interface Controller {
//    String addWorker(String type, String workerName);
//
//    String addVehicle(String vehicleName, int strengthRequired);
//
//    String addToolToWorker(String workerName, int power);
//
//    String makingVehicle(String vehicleName);
//
//    String statistics();


    //Alex
    String addPlane(String type,int planeNumber, String manufacturerAndModel);

    String addPilotToThePilotsRepository(String firstName, String secondName, int age, int pilotNumber, int flyingHours);

    String addPilotToPlane(int planeNumber, int pilotNumber);

    String statisticsForThePilots();

    String statisticsForThePlanes();
}
