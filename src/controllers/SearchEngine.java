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

import jdk.jfr.events.ExceptionThrownEvent;
import models.Flight;


/**
 * Class built for retrieval of inital ArrayList of Flight
 * objects and subsequent filtering of said list. Searching
 * generates a new list while filtering narrows the list down.
 */
public class SearchEngine {

    private DatabaseRetriever DBConnection;
    private ArrayList<Flight> flightList;
    private ArrayList<Flight> filteredFlightList;
    private int passengerQty;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Constructor for SearchEngine class
     * @param DBConnection
     */

    public SearchEngine(){
        DBConnection = new DatabaseRetriever();
    }

    /**
     *  Search for flights given some criterias
     * @param departureDate
     * @param departureLocation
     * @param arrivalLocation
     * @param passengerQty
     * @return
     */
    public ArrayList<Flight> searchFlightByCriteria(String departureDate, String departureLocation, String arrivalLocation, int passengerQty){
        try{
            flightList = DBConnection.retrieveFlightsByCriteria(departureDate, departureLocation, arrivalLocation, passengerQty);
        } catch (Exception e){
            System.err.println("Message: "+e.getMessage());
        }
        this.passengerQty = passengerQty;
        return flightList;
    }

    /**
     * Method for further narrowing of already created list of Flight objects. Allows further
     * specifications to be made on what flights are included.
     * @param flightListToFilter
     * @param dateFrom
     * @param dateTo
     * @param wantSagaSeats
     * @param wantWifi
     * @param priceDescending
     * @param maxPrice
     * @return
     */

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
                flightDate = dateFormat.parse(flight.getDepartureDate());
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

            if(flightEligible){
                filteredFlightList.add(flight);
            }

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