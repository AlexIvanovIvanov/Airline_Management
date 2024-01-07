package Airline;

import Airline.core.Engine;
import Airline.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();


    }
}
