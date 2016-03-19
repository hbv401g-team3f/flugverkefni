package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Flight;

public class SearchEngine {
	
	private DatabaseRetriever DBConnection;
	private ArrayList<Flight> flightList;
	
	public SearchEngine(){
		DBConnection = new DatabaseRetriever();
	}
	
	
	private void extractDataFromResultSet(ResultSet  results) throws SQLException{
		flightList = new ArrayList<Flight>();
		
		while(results.next()){
			//saekja dot.		
			flightList.add(new Flight());			
		}		
	}
	
	public ArrayList<Flight> searchFlightByCriteria(String departureDate, String returnDate, String departureLocation, String returnLocation, int passengerQty ){
		
		
		ResultSet flightResults = DBConnection.retrieveFlightsByCriteria(departureDate, returnDate, departureLocation, returnLocation, passengerQty);
		
		extractDataFromResultSet(flightResults);		
	
		return flightList;
	}
	
}