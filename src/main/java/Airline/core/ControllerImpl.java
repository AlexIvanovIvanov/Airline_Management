package Airline.core;

import Airline.common.ConstantMessages;
import Airline.common.ExceptionMessages;
import Airline.models.person.Pilot;
import Airline.models.plane.CargoPlane;
import Airline.models.plane.PassengerPlane;
import Airline.models.plane.Plane;
import Airline.repositories.PilotesRepository;
import Airline.repositories.PlaneRepository;
import Airline.repositories.VehicleRepository;
import Airline.repositories.WorkerRepository;
import Airline.models.utility_methods.UtilityMethods;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ControllerImpl implements Airline.core.Controller {
    Scanner scanner = new Scanner(System.in);

    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private int countMadeVeicles;

    //Alex
    private PlaneRepository planeRepository;
    private PilotesRepository pilotesRepository;

    //constructor
    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.countMadeVeicles = 0;

        //Alex
        this.planeRepository = new PlaneRepository();
        this.pilotesRepository = new PilotesRepository();
    }

    //Alex methods

    //AddPlane PassangerPlane 123456 Boing-747
    public String addPlane(String type, int planeNumber, String manufacturerAndModel) {
        Plane plane;
        if (type.equals("CargoPlane")) {
            plane = new CargoPlane(planeNumber, manufacturerAndModel);
        } else if (type.equals("PassengerPlane")) {
            plane = new PassengerPlane(planeNumber, manufacturerAndModel);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.PLANE_TYPE_DOESNT_EXIST);
        }
        planeRepository.add(plane);
        return String.format(ConstantMessages.ADDED_PLANE, manufacturerAndModel, planeNumber);
    }

    //AddPilotToThePilotsRepository Ivan Perov 35 12345678
    public String addPilotToThePilotsRepository(String firstName, String secondName, int age, int pilotNumber, int flyingHours) {

        Pilot pilot = new Pilot(firstName, secondName, age, pilotNumber, flyingHours);

        pilotesRepository.add(pilot);

        return String.format(ConstantMessages.ADDED_PILOT, firstName, secondName, pilotNumber);
    }

    //AddPilotToPlane 123456 12345678
    public String addPilotToPlane(int planeNumber, int pilotNumber) {
        Plane plane = this.planeRepository.findByPlaneNumber(planeNumber);
        Pilot pilot = this.pilotesRepository.findByPilotNumber(pilotNumber);

        if (plane == null) {
            return String.format(ExceptionMessages.PLANE_NOT_FOUND);
        }

        if (pilot == null) {
            return String.format(ExceptionMessages.PILOT_NOT_FOUND);
        }

        plane.setPilot(pilot);

        return String.format(ConstantMessages.ADDED_PILOT_TO_PLANE,
                pilotNumber, pilot.getName(), plane.getPaneManufacturer_Model(), planeNumber
        );

    }

    //StatisticsForThePilots
    public String statisticsForThePilots() {
        StringBuilder sb = new StringBuilder();
        int pilotCounter = 1;

        System.out.println();
        sb.append("<<< Statistic about the pilots in the airline:   >>>").append(System.lineSeparator());
        sb.append("The airline currently employs: ").append(this.pilotesRepository.getRepositoryData().size()).append(" pilots.").append(System.lineSeparator());


        for (Pilot pilot : this.pilotesRepository.getRepositoryData()) {
            sb.append(System.lineSeparator());
            sb.append("Pilot: ").append(pilotCounter++).append(System.lineSeparator());
            sb.append("Name: ").append(pilot.getName()).append(System.lineSeparator());
            sb.append("PilotNumber: ").append(pilot.getPilotNumber()).append(System.lineSeparator());
            sb.append("Flying hours: ").append(pilot.getFlyingHours()).append(System.lineSeparator());
        }

        Pilot mostExperistPilot = UtilityMethods.getTheMostExperianst(pilotesRepository.getRepositoryData());

        sb.append(System.lineSeparator());
        sb.append("The pilot mit the most experianse is: ").append(mostExperistPilot.getName()).append(System.lineSeparator());
        sb.append("He heas: ").append(mostExperistPilot.getFlyingHours()).append(" howers in the air.");

        return sb.toString().trim();
    }

    //StatisticsForThePlanes
    public String statisticsForThePlanes() {
        StringBuilder sb = new StringBuilder();

        System.out.println();
        List<Plane> passangerPlanesList = this.planeRepository.getRepositoryData().stream().filter(p->p.getClass().getSimpleName().equals("PassengerPlane")).collect(Collectors.toList());
        List<Plane> cargoPlanesList = this.planeRepository.getRepositoryData().stream().filter(p->p.getClass().getSimpleName().equals("CargoPlane")).collect(Collectors.toList());

        sb.append("<<< Statistic about the planes in the airline:   >>>").append(System.lineSeparator());
        sb.append("Number of passenger planes in the airline: ").append(passangerPlanesList.size()).append(System.lineSeparator());
        sb.append("Number of cargo planes in the airline: ").append(cargoPlanesList.size()).append(System.lineSeparator());


        return sb.toString().trim();
    }

//        @Override
//    public String statistics() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%d vehicles are ready!", countMadeVeicles)).append(System.lineSeparator());
//        sb.append("Info for workers:").append(System.lineSeparator());
//        workerRepository
//                .getWorkers()
//                .forEach(worker -> {
//                    sb.append(worker.toString());
//                });
//        return sb.toString().trim();
//    }

    //methods from the interface base Project
//    @Override
//    public String addWorker(String type, String workerName) {
//        //type (FirstShift or SeconShift)
//        Worker worker;
//        if (type.equals("FirstShift")) {
//            worker = new FirstShift(workerName);
//        } else if (type.equals("SecondShift")) {
//            worker = new SecondShift(workerName);
//        } else {
//            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
//        }
//        workerRepository.add(worker); //
//        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
//
//    }

//    @Override
//    public String addVehicle(String vehicleName, int strengthRequired) {
//        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
//        vehicleRepository.add(vehicle);
//
//        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
//    }

//    @Override
//    public String addToolToWorker(String workerName, int power) {
//        Worker worker = workerRepository.findByName(workerName);
//
//        if (worker == null) {
//            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
//        } else {
//            Tool tool = new ToolImpl(power); //syzdavame instruments dadaenata sila
//            worker.addTool(tool);
//            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
//        }
//
//    }

//    @Override
//    public String makingVehicle(String vehicleName) {
//        List<Worker> availableWorkers = workerRepository.getWorkers().stream()   //spisyk s validnite rabotnici          XXXX
//                .filter(worker -> worker.getStrength() > 70)
//                .collect(Collectors.toList());
//
//        if (availableWorkers.isEmpty()) {
//            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
//        }
//
//        Vehicle vehicle = vehicleRepository.findByName(vehicleName);   //namiram prevoznoto sredstvo za izrabotvane
//
//        Shop shop = new ShopImpl();  //create a new shop because in the shop we have the method "making"
//        int brokenTools = 0;
//        while (!availableWorkers.isEmpty() && !vehicle.reached()) { //dokato imam rabotnici i kolata ne egotova
//            Worker worker = availableWorkers.get(0);
//            shop.make(vehicle, worker);
//            brokenTools += (int) worker.getTools().stream().filter(Tool::isUnfit).count(); //dobavi nrgodnite instrumenti, tezi za koito unfit vryshta true
//
//            if (!worker.canWork() || worker
//                    .getTools()
//                    .stream()
//                    .noneMatch(t -> !t.isUnfit())) {                                                 //               XXXXXXXXX
//                //ne moje da raboti ako ili nqma sila ili nqma instrument kojto da ne e razvalen
//
//                availableWorkers.remove(worker);// maham rabotnika ako ne moje da raboti
//
//            }
//
//        }
//
//        //ili sa svyrschili rabotnicite ili kolata e gotova
//        if (vehicle.reached()) {
//            //imame gotova kola
//            countMadeVeicles++;
//            return String.format(ConstantMessages.VEHICLE_DONE, vehicle.getName(), "done")
//                    + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenTools);
//        } else {
//            //car not ready
//            return String.format(ConstantMessages.VEHICLE_DONE, vehicle.getName(), "not done")
//                    + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenTools);
//        }
//
//    }




}
