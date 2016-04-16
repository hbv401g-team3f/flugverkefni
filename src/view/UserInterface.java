package view;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.text.SimpleDateFormat;

public class UserInterface {


    public DatePicker datePicker;
    public ComboBox departureLocation;
    public ComboBox arrivalLocation;
    public ComboBox passengerQty;

    public UserInterface() {
    }

    public void executeSearch(ActionEvent actionEvent) {
        String departureDate = String.valueOf(datePicker.getValue());
        String departureLoc = String.valueOf(departureLocation.getValue());
        String travelDestination = String.valueOf(arrivalLocation.getValue());
        int passengerQuantity = Integer.parseInt(String.valueOf(passengerQty.getValue()));
    }
}
