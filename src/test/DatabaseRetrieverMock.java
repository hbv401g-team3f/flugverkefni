package test;

import java.util.ArrayList;

import controllers.DatabaseRetriever;
import models.Flight;

public class DatabaseRetrieverMock implements DatabaseRetriever {

    private ArrayList<Flight> flightList = new ArrayList<Flight>();
    private String[] connectArray;
    private boolean[] passBoolArray;
    private int[] passIntArray;


    public ArrayList<Flight> retrieveFlightsByCriteria(String travelDate,
                                                       String returnDate, String travelDestination, String returnLocation, int passengerQty) {
        connectArray = null;
        passBoolArray = new boolean[]{false, false};
        passIntArray = new int[]{3000, 400};
        Flight flightLondon = new Flight("03.04.2016", 70000, "WW250", "Iceland", "1215", "KEF",
                "London", "1500", "LGW", 50, 50, 10, 10, connectArray, passBoolArray, passIntArray);
        flightList.add(flightLondon);

        connectArray = null;
        passBoolArray = new boolean[]{false, true};
        passIntArray = new int[]{6000, 600};
        Flight flightSanFran = new Flight("03.04.2016", 70000, "FI300", "Iceland", "1000", "KEF",
                "San Francisco", "1430", "SFO", 60, 40, 15, 10, connectArray, passBoolArray, passIntArray);
        flightList.add(flightSanFran);

        connectArray = new String[]{"London", "1830", "LGW", "1930"};
        passBoolArray = new boolean[]{true, true};
        passIntArray = new int[]{5000, 500};
        Flight flightAlicante = new Flight("02.04.2016", 50000, "WW400", "Iceland", "1630", "KEF",
                "Alicante", "2230", "ALC", 50, 40, 10, 5, connectArray, passBoolArray, passIntArray);
        flightList.add(flightAlicante);
        return flightList;

    }

    public ArrayList<Flight> queryDatabase(String query) {
        return null;
    }
}