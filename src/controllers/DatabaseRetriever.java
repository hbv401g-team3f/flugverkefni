package controllers;


import java.sql.*;
import java.util.ArrayList;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import models.Flight;




/**
 * This class isn't ready yet so
 * it is temporarily an interface so it
 * can serve as a guideline for the mock
 * database connection.
 */
public class DatabaseRetriever {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/database_retriever";

    static final String USER = "root";
    static final String PASS = "Rassapi7904";


    public DatabaseRetriever() {
    }



    public ArrayList<Flight> retrieveFlightsByCriteria(String departureDate, String departureLocation, String arrivalLocation, int passengerQty) throws SQLException {


        ArrayList<Flight> flightList = new ArrayList<>();

        String queryString = "SELECT * FROM flight f LEFT JOIN connect_flight c ON c.departureDate = f.departureDate " +
                "AND c.flightNumber = f.flightNumber LEFT JOIN passenger_luxuries p ON p.departureDate = f.departureDate " +
                "AND p.flightNumber = f.flightNumber WHERE f.departureDate = ? " +
                "AND f.departureLoc = ? AND f.arrivalLoc = ? AND ((f.numSeats+f.numSagaSeats)-(f.bookedSeats+f.bookedSagaSeats-?))>0";

        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }

            System.out.println("Establishing a connection to the DB)");
            //Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_retriever","root","Rassapi7904");

            System.out.println("Creating statement...");
            PreparedStatement statement = conn.prepareStatement(queryString);
            statement.setString(1, departureDate);
            statement.setString(2, departureLocation);
            statement.setString(3, arrivalLocation);
            statement.setInt(4, passengerQty);
            ResultSet results = statement.executeQuery();
            ArrayList<Flight> flightResults = new ArrayList<>();

            while (results.next()) {
                /*
                * Initialize value arrays for connectFlight objects and passengerLuxuries objects
                * */



                /*
                * Extract data from resultSet
                 */
                String flightNumber = results.getString("flightNumber");
                int price = results.getInt("price");


                String depDate = results.getString("departureDate");
                String departureTime = results.getString("departureTime");
                String departureLoc = results.getString("departureLoc");
                String depAirportId = results.getString("depAirportId");

                String arrivalDate = results.getString("arrivalDate");
                String arrivalTime = results.getString("arrivalTime");
                String arrivalLoc = results.getString("arrivalLoc");
                String arrAirportId = results.getString("arrAirportId");

                int numSeats = results.getInt("numSeats");
                int bookedSeats = results.getInt("bookedSeats");
                int numSagaSeats = results.getInt("numSagaSeats");
                int bookedSagaSeats = results.getInt("bookedSagaSeats");

                String connLoc = results.getString("connLoc");
                String connArrivalTime = results.getString("connArrivalTime");
                String connAirportId = results.getString("connAirportId");
                String connDepartTime = results.getString("connDepartTime");

                String[] connectFlight = new String[]{connLoc, connArrivalTime, connAirportId, connDepartTime};


                boolean wifiAvailable = results.getBoolean("wifiAvailable");
                boolean mealsAvailable = results.getBoolean("mealsAvailable");

                boolean[] passengerLuxBool = new boolean[]{wifiAvailable, mealsAvailable};


                int priceInFlightPoints = results.getInt("priceInFlightPoints");
                int flightPointsGained = results.getInt("flightPointsGained");

                int[] passengerLuxInt = new int[]{priceInFlightPoints, flightPointsGained};

                Flight tmpFlight = new Flight(depDate, price, flightNumber, departureLoc, departureTime,
                        depAirportId, arrivalLoc, arrivalDate, arrivalTime, arrAirportId, numSeats, bookedSeats,
                        numSagaSeats, bookedSagaSeats, connectFlight, passengerLuxBool, passengerLuxInt);

                flightResults.add(tmpFlight);

                System.out.println("Flight object added.");
                System.out.println("Flight number added: " + tmpFlight.getFlightNumber());
            }

            flightList = flightResults;

        } catch (SQLException e) {
            System.out.println("Error message: " + e.getMessage());
        }

        return flightList;
    }
}
