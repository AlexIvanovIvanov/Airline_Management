package Airline.models.utility_methods;

import Airline.models.person.Pilot;

import java.util.Collection;

public class UtilityMethods {

    public static Pilot getTheMostExperianst(Collection<Pilot> pilots) {
        Pilot pilot = pilots
                .stream()
                .sorted((p1, p2) -> Double.compare(p2.getFlyingHours(), p1.getFlyingHours()))
                .limit(1)
                .findFirst()
                .orElse(null);

        return pilot;
    }


}
