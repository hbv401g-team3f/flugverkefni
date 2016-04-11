package controllers;


import java.sql.*;
import java.util.ArrayList;

import models.Flight;

import javax.lang.model.type.ArrayType;


/**
 * This class isn't ready yet so
 * it is temporarily an interface so it
 * can serve as a guideline for the mock
 * database connection.
 */
public class DatabaseRetriever implements DatabaseConnection {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/thingy";

    static final String USER = "username";
    static final String PASS = "password";


    DatabaseRetriever(){
    }


    private ArrayList<Flight> queryDatabase(String query){
        Connection conn = null;
        Statement statement = nuill;

        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Establishing a connection to the DB)");
            conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);

            System.out.println("Creating statement...");
            statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Flight> flightResults = new ArrayList<Flight>();

            while(results.next()){
                String flightNumber = results.getString("flightNumber");
                int price = results.getInt("price");
                String departureDate = results.getString("departureDate");
                String departureLoc = results.getString("departureLoc");
                String departureTime = results.getString("departureTime");
                String arrivalLoc = results.getString("arrivalLoc");
                String arrivalDate = results.getString("arrivalDate");
                String arrivalTime = results.getString("arrivalDate");
                int numSeats = results.getInt("numSeats");
                int bookedSeats = results.getInt("bookedSeats");
                int numSagaSeats = results.getInt("numSagaSeats");
                int bookedSagaSeats = results.getInt("bookedSagaSeats");

                flightResults.add(new Flight());
            }
        }


        return results;
    }

    public ArrayList<Flight> retrieveFlightsByCriteria(String departureDate, String returnDate, String departureLocation, String returnLocation, int passengerQty)
	{

		String queryString = "SELECT * FROM flight, connectflight, passengerluxuries WHERE "


		ArrayList<Flight> flightList = queryDatabase(queryString);
		return flightList;
	}
}