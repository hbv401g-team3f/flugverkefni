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
	
		
	public ArrayList<Flight> searchFlightByCriteria(String departureDate, String returnDate, String departureLocation, String returnLocation, int passengerQty ){
		
		
		ArrayList<Flight> flightResults = DBConnection.retrieveFlightsByCriteria(departureDate, returnDate, departureLocation, returnLocation, passengerQty);
		
		extractDataFromResultSet(flightResults);		
	
		return flightList;
	}
	
}