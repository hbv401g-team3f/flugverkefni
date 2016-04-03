package controllers;
/*
import java.sql.ResultSet;
import java.sql.SQLException;
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import models.Flight;


/**
 * @author stefa
 * The SearchEngine class is not ready yet - so it is
 * temporarily an interface so JUnit testing can be done
 * all unfinished methods and such will be commented out
 */
public class SearchEngine {

    private DatabaseRetriever DBConnection;
    private ArrayList<Flight> flightList;
    private ArrayList<Flight> filteredFlightList;
    private int passengerQty;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public SearchEngine(DatabaseRetriever DBConnection){
        this.DBConnection = DBConnection;
    }

    public ArrayList<Flight> searchFlightByCriteria(String travelDestination, String travelDate, String returnLocation, String returnDate, int passengerQty ){
        flightList = DBConnection.retrieveFlightsByCriteria(travelDestination, travelDate, returnLocation, returnDate, passengerQty);
        this.passengerQty = passengerQty;
        return flightList;
    }

    public ArrayList<Flight> filterFlightList(ArrayList<Flight> flightListToFilter, String dateFrom, String dateTo, boolean wantSagaSeats, boolean wantWifi, boolean priceDescending, int maxPrice){

        filteredFlightList = new ArrayList<Flight>();

        for(Flight flight : flightListToFilter){
            // Determines if the flight is within specified parameters
            boolean flightEligible = true;
            // Desired date restricitions
            Date dateFromWanted = new Date();
            Date dateToWanted = new Date();
            Date flightDate = new Date();
            try {
                dateFromWanted = dateFormat.parse(dateFrom);
                dateToWanted = dateFormat.parse(dateTo);
                flightDate = dateFormat.parse(flight.getDate());
            } catch(ParseException e) {
                System.err.println("String to Date parsing error:" + e.getMessage());
            }
            // Dates of flight available
            if(dateFromWanted.compareTo(flightDate) >= 0 && dateToWanted.compareTo(flightDate) <= 0){
                flightEligible = false;
            }
            // Reject flight if client wants Saga class seats but none are available
            int availableSagaSeats = flight.getNumSagaSeats() - flight.getBookedSagaSeats();
            if(wantSagaSeats && availableSagaSeats < passengerQty ){
                flightEligible = false;
            }

            // Reject flight if client wants wifi but none is available
            if(wantWifi && flight.getPassengerLuxuries().isWifiAvailable()){
                flightEligible = false;
            }

            // Reject flight if price is too high for client or and client does care about price (price != 0)
            if(flight.getPrice() > maxPrice && flight.getPrice() != 0){
                flightEligible = false;
            }

            filteredFlightList.add(flight);
        }

        // Determine how to sort list of flights
        Collections.sort(filteredFlightList);
        if(!priceDescending){
            ArrayList<Flight> tmpList = new ArrayList<Flight>();
            while(!filteredFlightList.isEmpty()){
                Flight tmpFlight = filteredFlightList.remove(0);
                tmpList.add(0,tmpFlight);
            }
            filteredFlightList = tmpList;
        }

        return filteredFlightList;
    }


}