package test;

import controllers.SearchEngine;
import models.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by egill on 4/15/2016.
 */
public class TestSearchEngine {
    /**
     * Instance variables
     */
    private SearchEngine searchEngine;
    private ArrayList<Flight> flightListAll;
    private SimpleDateFormat format;
    private SimpleDateFormat timeFormat;


    @Before
    public void setUp() throws Exception {
        searchEngine = new SearchEngine();
        format = new SimpleDateFormat("yyyy-mm-dd");
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        flightListAll = searchEngine.searchFlightByCriteria("2016-04-20", "Iceland", "CasaBlanca", 4);
    }

    @After
    public void tearDown() throws Exception {
        flightListAll.clear();
    }

    @Test
    public void testFilterWifiFlights() throws Exception{
        ArrayList<Flight> filteredWifiList = searchEngine.filterFlightList(flightListAll,"2016-01-01", "2016-12-30",false,true,false,0);

        for(Flight flight : filteredWifiList){
            assertEquals(true, flight.getPassengerLuxuries().isWifiAvailable());
        }
    }

    @Test
    public void testDescendingPriceOrder() throws Exception{
        ArrayList<Flight> filteredDescendingList = searchEngine.filterFlightList(flightListAll,"2016-01-01", "2016-12-30",false, false, true, 0);

        //Some large value here that is guaranteed to be larger than the most expensive flight
        double oldPrice = 1000000000;

        for (Flight flight : filteredDescendingList){
            assertTrue(flight.getPrice() <= oldPrice);
            oldPrice = flight.getPrice();
        }
    }

    @Test
    public void testAscendingPriceOrder() throws Exception{
        ArrayList<Flight> filteredAscendingList = searchEngine.filterFlightList(flightListAll,"2016-01-01", "2016-12-30",false, false, false, 0);

        // Negative value guaranteed to be lower than least expensive flight
        double tmpPrice = 0;

        for(Flight flight : filteredAscendingList){
            assertTrue(flight.getPrice() >= tmpPrice);
            tmpPrice = flight.getPrice();
        }
    }

    @Test
    public void testSagaAvailability() throws Exception{
        ArrayList<Flight>  filteredSagaList = searchEngine.filterFlightList(flightListAll,"2016-01-01", "2016-12-30",true,false,false,0);
        for (Flight flight : filteredSagaList){
            int numAvailableSagaSeats = flight.getNumSagaSeats()-flight.getBookedSagaSeats();
            assertTrue(numAvailableSagaSeats > 0);
        }
    }

    @Test
    public void testWithinDateFrame() throws Exception{
        String dateFromString = "2016-04-03";
        String dateToString = "2016-04-04";
        Date dateFrom = format.parse(dateFromString);
        Date dateTo = format.parse(dateToString);

        ArrayList<Flight>  filteredDateList = searchEngine.filterFlightList(flightListAll,dateFromString, dateToString,false,false,false,0);
        for (Flight flight : filteredDateList){
            Date flightDate = format.parse(flight.getDepartureDate());
            assertTrue(dateFrom.compareTo(flightDate) <= 0 && dateTo.compareTo(flightDate) >= 0);
        }
    }
}
