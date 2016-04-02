package test;

import org.junit.*;
import static org.junit.Assert.*;
import controllers.SearchEngine;
import models.*;
import java.util.ArrayList;

import org.junit.Test;

public class SearchEngineTest {

	private SearchEngine searchEngineInstance = new SearchEngine();
	private ArrayList<Flight> flightList = new ArrayList<Flight>();
	
	@Before
	public void setUp(){
		// Populate flightList with values for testing
		
		// Flight with all passenger luxuries and connecting flight
		String connectArray[] = {"London", "1830", "LGW", "1930"};
		boolean passBoolArray[] = {true, true};
		int passIntArray[] = {5000, 500};
		Flight flightOne = new Flight("02.04.16", 50000, "WW400", "Iceland", "1630", "KEF",
				"Alicante", "2230", "ALC", "5", 50, 40, 10, 5, connectArray, passBoolArray, passIntArray);
		flightList.add(flightOne);
		
		// Flight with all passenger luxuries but no connecting flight
		connectArray = null;
		passBoolArray = new boolean[] {false, true};
		passIntArray = new int[] {6000, 600};
		Flight flightTwo = new Flight("03.04.16", 70000, "FI300", "Iceland", "1000", "KEF",
				"San Francisco", "1430", "SFO", "17", 60, 40, 15, 10, connectArray, passBoolArray, passIntArray);
		flightList.add(flightTwo);
		
		// Fully-booked flight with no connecting flight
		connectArray = null;
		passBoolArray = new boolean[] {false,false};
		passIntArray = new int[] {3000, 400};
		Flight flightThree = new Flight("03.04.16", 70000, "WW250", "Iceland", "1215", "KEF",
				"London", "1500", "LGW", "3", 50, 50, 10, 10, connectArray, passBoolArray, passIntArray);
		flightList.add(flightThree);
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		assertFalse(flightList == null);
	}

}
