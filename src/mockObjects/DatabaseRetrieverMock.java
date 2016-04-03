package test;

import java.util.ArrayList;

import controllers.DatabaseRetriever;
import models.Flight;

public class DatabaseRetrieverMock implements DatabaseRetriever {

    public ArrayList<Flight> retrieveFlightsByCriteria(String departureDate,
                                                       String returnDate, String departureLocation, String returnLocation, int passengerQty){
        ArrayList<Flight> flightList = new ArrayList<Flight>();
        String[] connectArray;
        boolean[] passBoolArray;
        int[] passIntArray;
        // Populate flightList with values for testing

        // Flight with all passenger luxuries and connecting flight
        connectArray = new String[]{"London", "1830", "LGW", "1930"};
        passBoolArray = new boolean[]{true, true};
        passIntArray = new int[]{5000, 500};
        Flight flightAlicante = new Flight("02.04.16", 50000, "WW400", "Iceland", "1630", "KEF",
                "Alicante", "2230", "ALC", "5", 50, 40, 10, 5, connectArray, passBoolArray, passIntArray);
        flightList.add(flightAlicante);

        // Flight with all passenger luxuries but no connecting flight
        connectArray = null;
        passBoolArray = new boolean[] {false, true};
        passIntArray = new int[] {6000, 600};
        Flight flightSanFran = new Flight("03.04.16", 70000, "FI300", "Iceland", "1000", "KEF",
                "San Francisco", "1430", "SFO", "17", 60, 40, 15, 10, connectArray, passBoolArray, passIntArray);
        flightList.add(flightSanFran);

        // Fully-booked flight with no connecting flight
        connectArray = null;
        passBoolArray = new boolean[] {false,false};
        passIntArray = new int[] {3000, 400};
        Flight flightLondon = new Flight("03.04.16", 70000, "WW250", "Iceland", "1215", "KEF",
                "London", "1500", "LGW", "3", 50, 50, 10, 10, connectArray, passBoolArray, passIntArray);
        flightList.add(flightLondon);

        return flightList;
    }

    //I added this comment here so I can test to to commit this new connection shit thingy
}