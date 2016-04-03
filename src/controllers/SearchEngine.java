package controllers;
/*
import java.sql.ResultSet;
import java.sql.SQLException;
*/

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Flight;
import test.DatabaseRetrieverMock;


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
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy")
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
            Date dateFromWantedInt = dateFormat.parse(dateFrom);
            Date dateToWantedInt = dateFormat.parse(dateTo);
            // Dates of flight available
            // TODO

            // Reject flight if client wants Saga class seats but none are available
            int availableSagaSeats = flight.getNumSagaSeats() - flight.getBookedSagaSeats();
            if(wantSagaSeats && availableSagaSeats < passengerQty ){
                flightEligible = false;
            }

            // Reject flight if client wants wifi but none is available
            if(wantWifi && flight.getPassengerLuxuries().isWifiAvailable()){
                flightEligible = false;
            }




        }
    }


}