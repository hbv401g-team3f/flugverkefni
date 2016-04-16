package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import controllers.SearchEngine;
import javafx.scene.control.ListView;
import models.Flight;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserInterface {


    public DatePicker datePicker;
    public ComboBox departureLocation;
    public ComboBox arrivalLocation;
    public ComboBox passengerQty;
    public ListView resultDisplay;


    @FXML
    void initialize() {
        assert departureLocation != null : "fx:id=\"departureLocation\" was not injected: check your FXML file 'UISettingz.fxml'.";
        assert arrivalLocation != null : "fx:id=\"arrivalLocation\" was not injected: check your FXML file 'UISettingz.fxml'.";
        assert passengerQty != null : "fx:id=\"passengerQty\" was not injected: check your FXML file 'UISettingz.fxml'.";
        assert resultDisplay != null : "fx:id=\"resultDisplay\" was not injected: check your FXML file 'UISettingz.fxml'.";

        departureLocation.getItems().clear();
        departureLocation.getItems().addAll("Akureyri","Egilsstaðir","Ísafjörður","Reykjavík");

        arrivalLocation.getItems().clear();
        arrivalLocation.getItems().addAll("Akureyri","Egilsstaðir","Ísafjörður","Reykjavík");

        passengerQty.getItems().clear();
        passengerQty.getItems().addAll("1","2","3","4","5","6","7","8","9");

        resultDisplay.getItems().clear();
    }

    public UserInterface() {
    }

    public void executeSearch(ActionEvent actionEvent) {

        resultDisplay.getItems().clear();

        String departureDate = String.valueOf(datePicker.getValue());
        String departureLoc = String.valueOf(departureLocation.getValue());
        String travelDestination = String.valueOf(arrivalLocation.getValue());
        int passengerQuantity = Integer.parseInt(String.valueOf(passengerQty.getValue()));

        SearchEngine searchEngine = new SearchEngine();

        ArrayList<Flight> flightList = searchEngine.searchFlightByCriteria(departureDate, departureLoc, travelDestination, passengerQuantity);
        
        for(Flight flight : flightList) {
            String displayFlight = flight.getDepartureLoc() + " til " + flight.getArrivalLoc() + ": " + flight.getDepartureDate()
                                    + flight.getDepartureTime();
            resultDisplay.getItems().add(displayFlight);
        }
        resultDisplay.getItems().add("lel");
    }
}
