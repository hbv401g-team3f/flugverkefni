package controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
import models.Flight;

import java.sql.*;

public class DatabaseUpdater {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/database_retriever?autoReconnect=true&useSSL=false";
    private static final String USER = "";
    private static final String PASS = "";


    public void updateFlight(Flight flightToBook, int bookedSeatQty, boolean bookSagaSeats) {

        String query = "update flight set bookedSeats = bookedSeats + ? WHERE flightNumber = ? AND departureDate = ?";

        if (bookSagaSeats) {
            query = "update flight set bookedSagaSeats = bookedSagaSeats + ? WHERE flightNumber = ? AND departureDate = ?";
        }

        String flightNumber = flightToBook.getFlightNumber();
        String departureDate = flightToBook.getDepartureDate();
        try {
            try {
                Class.forName(JDBC_DRIVER);
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }

            System.out.println("Establishing a connection to the DB)");
            Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            System.out.println("connection success");
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, bookedSeatQty);
            statement.setString(2, flightNumber);
            statement.setString(3, departureDate);
            statement.executeUpdate();

            System.out.println("Update successful");
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}