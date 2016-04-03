package helperFunctions;

import java.util.Comparator;
import models.Flight;

public class FlightComparatorAscending implements Comparator<Flight> {
    @Override
    public int compare(Flight flight1, Flight flight2){
        return flight1.getPrice() - flight2.getPrice();
    }
}