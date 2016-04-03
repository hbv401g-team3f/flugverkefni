package controllers;
/*
import java.sql.ResultSet;
import java.sql.SQLException;
*/

import java.util.ArrayList;
import models.Flight;



/**
 * @author stefa
 * The SearchEngine class is not ready yet - so it is
 * temporarily an interface so JUnit testing can be done
 * all unfinished methods and such will be commented out
 */
public interface SearchEngine {
	
	//private DatabaseRetriever DBConnection;
	//private ArrayList<Flight> flightList;
	
	/*
	public SearchEngine(){
		DBConnection = new DatabaseRetriever();
	}
	*/
	
	
	/*
	public ArrayList<Flight> searchFlightByCriteria(String departureDate, String returnDate, String departureLocation, String returnLocation, int passengerQty ){
		
		ArrayList<Flight> flightResults = DBConnection.retrieveFlightsByCriteria(departureDate, returnDate, departureLocation, returnLocation, passengerQty);
		
		extractDataFromResultSet(flightResults);		
	
		return flightList;
	}
	*/
	
	public ArrayList<Flight> searchFlightByCriteria(String travelDestination, String travelDate, String returnLocation, String returnDate, int passengerQty );
	
	
}