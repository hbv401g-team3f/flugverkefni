package controllers;


import models.Flight;

import java.util.ArrayList;

/**
 * Created by stefa on 4/11/2016.
 */
public class JDBCfikt {

    public static void main(String[] args) {
        DatabaseRetriever DBC = new DatabaseRetriever();

        ArrayList<Flight> flightList = new ArrayList<>();

        try {
            System.out.println("Retrieving results");
            flightList = DBC.retrieveFlightsByCriteria("2016-04-20", "Iceland", "Casablanca", 1);
        } catch (Exception e)
        {
            System.err.println("Shiiii "+ e.getMessage());
        }

        System.out.println("Displaying results:");

        for(Flight currentFlight : flightList){
            System.out.println("Flight number: "+currentFlight.getFlightNumber()+", Price: " +currentFlight.getPrice()+", Wifi Availablle? "+ currentFlight.getPassengerLuxuries().isWifiAvailable());
        }

    }

}
