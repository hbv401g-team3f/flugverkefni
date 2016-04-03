package helperFunctions;

import java.util.Comparator;
import models.Flight;

public class FlightComparatorDescending implements Comparator<Flight> {
    @Override
    public int compare(Flight flight1, Flight flight2){
        return flight2.getPrice() - flight1.getPrice();
    }
}