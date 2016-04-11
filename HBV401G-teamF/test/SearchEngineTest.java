package test;

import org.junit.*;
import static org.junit.Assert.*;
//import controllers.SearchEngine;
import models.*;
import java.util.ArrayList;
import org.junit.Test;
import test.SearchEngineMock;

public class SearchEngineTest {


	private SearchEngineMock mockSearchEngine = new SearchEngineMock();
	ArrayList<Flight> flightListLondon;
	ArrayList<Flight> flightListAprilThird;
	ArrayList<Flight> flightListAll;

	@Before
	public void setUp(){
		flightListLondon = mockSearchEngine.searchFlightByCriteria("London", "02.02.16", "Keflavik", "06.06.16", 10);
		flightListAprilThird = mockSearchEngine.searchFlightByCriteria("Dont Care", "03.04.16", "Keflavik", "06.06.16", 5);
		flightListAll = mockSearchEngine.searchFlightByCriteria("No Preference", "Don't care", "Keflavik", "Don't care", 1);	
	}

	@After
	public void tearDown(){
		flightListLondon.clear();
		flightListAprilThird.clear();
		flightListAll.clear();
	}

	@Test
	public void testCorrectDatesForAllFlights() {
		String dateArray[] = {"02.04.16", "03.04.16", "03.04.16"};
		assertTrue(flightListAll.size() == 3);
		for(int i = 0; i < dateArray.length ; i++){
			assertEquals(dateArray[i], flightListAll.get(i).getDate());
		}		
	}


	@Test
	public void testLondonFlight(){
		assertTrue(flightListLondon.size() == 1);
		for(Flight currentFlightElement: flightListLondon){
			assertEquals("London", currentFlightElement.getArrivalLoc());
		}
	}
	
	@Test
	public void testDateFlight(){
		assertTrue(flightListAprilThird.size() == 2);
		for(Flight currentFlightElement: flightListAprilThird){
			assertEquals("03.04.16", currentFlightElement.getDate());
		}
	}
}
