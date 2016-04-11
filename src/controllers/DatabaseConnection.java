package controllers;

import models.Flight;

import java.util.ArrayList;

/**
 * Created by stefa on 4/10/2016.
 */
public interface DatabaseConnection {

    private ArrayList<Flight> queryDatabase(String query);

    private String updateDatabase(String query);

}
