package controllers;
/*
import java.sql.ResultSet;
import java.sql.SQLException;
*/

import java.util.ArrayList;
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

	public SearchEngine(DatabaseRetriever DBConnection){
		this.DBConnection = DBConnection;
	}

    public ArrayList<Flight> searchFlightByCriteria(String travelDestination, String travelDate, String returnLocation, String returnDate, int passengerQty ){
        //Todo
    }

    public ArrayList<Flight> filterFlightList(String dateFrom, String dateTo, boolean wantSagaSeats, boolean wantWifi, boolean priceDescending){
        //Todo
    }


}