package test;

import controllers.SearchEngine;
import models.Flight;
import java.util.ArrayList;


import static org.junit.Assert.*;

/**
 * Created by stefa on 4/3/2016.
 */
public class SearchEngineTest {


    private SearchEngine searchEngine;
    private ArrayList<Flight> flightListLondon;;
    private ArrayList<Flight> flightListAprilThird;
    private ArrayList<Flight> flightListAll;
    private ArrayList<Flight> filteredListOne;
    private ArrayList<Flight> filteredListTwo;
    private ArrayList<Flight> filteredListThree;



    @Before
    public void setUp() throws Exception {
        searchEngine = new SearchEngine(new DatabaseRetrieverMock());

        flightListLondon = searchEngine.searchFlightByCriteria("London", "02.02.16", "Keflavik", "06.06.16", 10);
        flightListAprilThird = searchEngine.searchFlightByCriteria("Dont Care", "03.04.16", "Keflavik", "06.06.16", 5);
        flightListAll = searchEngine.searchFlightByCriteria("No Preference", "Don't care", "Keflavik", "Don't care", 1);
        filteredListOne = searchEngine.filterFlightList(flightListAll, null, null, true, true, false);
        filteredListTwo = searchEngine.filterFlightList(flightListAll, "01.04.16", "04.04.16", false, true, true);
        filteredListThree = searchEngine.filterFlightList(flightListAll, "10.04.16", "05.05.16", false, false, false);
    }

    @After
    public void tearDown() throws Exception {
        flightListLondon.clear();
        flightListAprilThird.clear();
        flightListAll.clear();
    }


    @Test
    public void testOne() throws Exception{

    }
}