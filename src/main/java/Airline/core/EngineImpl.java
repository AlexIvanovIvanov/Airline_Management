package Airline.core;

import Airline.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
//            case AddWorker:
//                result = addWorker(data);
//                break;
//            case AddVehicle:
//                result = addVehicle(data);
//                break;
//            case AddToolToWorker:
//                result = addToolToWorker(data);
//                break;
//            case MakingVehicle:
//                result = makingVehicle(data);
//                break;
//            case Statistics:
//                result = statistics();
//                break;
//            case Exit:
//                result = Command.Exit.name();
//                break;


            //Alex
            case AddPlane:
                result = addPlane(data);
                break;

            case AddPilotToThePilotsRepository:
                result = addPilottoThePilotsRepository(data);
                break;

            case AddPilotToPlane:
                result = addPilotToPlane(data);
                break;

            case StatisticsForThePilots:
                result = statisticsForThePilots();
                break;

            case StatisticsForThePlanes:
                result = statisticsForThePlanes();
                break;
        }
        return result;
    }



//    private String addWorker(String[] data) {
//        return controller.addWorker(data[0], data[1]);
//    }
//
//    private String addVehicle(String[] data) {
//        return controller.addVehicle(data[0], Integer.parseInt(data[1]));
//    }
//
//    private String addToolToWorker(String[] data) {
//        return controller.addToolToWorker(data[0], Integer.parseInt(data[1]));
//    }
//
//    private String statistics() {
//        return controller.statistics();
//    }
//
//    private String makingVehicle(String[] data) {
//        return controller.makingVehicle(data[0]);
//    }

    //Alex
    private String addPlane(String[] data) {
        return controller.addPlane(data[0], Integer.parseInt(data[1]), data[2]);
    }

    private String addPilottoThePilotsRepository(String[] data) {
        return controller.addPilotToThePilotsRepository(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
    }

    private String addPilotToPlane(String[] data){
        return controller.addPilotToPlane(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    private String statisticsForThePilots(){
        return controller.statisticsForThePilots();
    }

    private String statisticsForThePlanes(){
        return controller.statisticsForThePlanes();
    }



}
