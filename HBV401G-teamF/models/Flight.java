package models;

public class Flight {
	// PRIVATE VARIABLES
	private String String;
	private int price;
	private String flightNumber;
	private String departureLoc;
	private String departureTime;
	private String depAirportId;
	private String arrivalLoc;
	private String arrivalTime;
	private String arrAirportId;
	private String gate;
	private int numSeats;
	private int bookedSeats;
	private int numSagaSeats;
	private int bookedSagaSeats;
	private ConnectFlight connectFlight;
	private PassengerLuxuries passengerLuxuries;
	
	// CONSTRUCTOR
	public Flight(String String, int price, String flightNumber, String departureLoc, String departureTime, 
			String depAirportId, String arrivalLoc, String arrivalTime, String arrAirportId, 
			String gate, int numSeats, int bookedSeats, int numSagaSeats, int bookedSagaSeats, 
			Array connectFlight, Array passengerLuxuries) {
		
		this.String = String;
		this.price = price;
		this.flightNumber = flightNumber;
		this.departureLoc = departureLoc;
		this.departureTime = departureTime;
		this.depAirportId = depAirportId;
		this.arrivalLoc = arrivalLoc;
		this.arrivalTime = arrivalTime;
		this.arrAirportId = arrAirportId;
		this.gate = gate;
		this.numSeats = numSeats;
		this.bookedSeats = bookedSeats;
		this.numSagaSeats = numSagaSeats;
		this.bookedSagaSeats = bookedSagaSeats;
		this.connectFlight = new ConnectFlight(connectFlight[0], connectFlight[1], 
											   connectFlight[2], connectFlight[3]);
		this.passengerLuxuries = new PassengerLuxuries(passengerLuxuries[0], passengerLuxuries[1],
													   passengerLuxuries[2], passengerLuxuries[3]);
		
	}
	
	// PRIVATE METHODS
	private boolean isConnectedFlight() {
		// ToDo...
	}
	
	// GET/SET METHODS
	public String getString() {
		return String;
	}

	public void setString(String String) {
		this.String = String;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureLoc() {
		return departureLoc;
	}

	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepAirportId() {
		return depAirportId;
	}

	public void setDepAirportId(String depAirportId) {
		this.depAirportId = depAirportId;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getArrAirportId() {
		return arrAirportId;
	}

	public void setArrAirportId(String arrAirportId) {
		this.arrAirportId = arrAirportId;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public int getNumSagaSeats() {
		return numSagaSeats;
	}

	public void setNumSagaSeats(int numSagaSeats) {
		this.numSagaSeats = numSagaSeats;
	}

	public int getBookedSagaSeats() {
		return bookedSagaSeats;
	}

	public void setBookedSagaSeats(int bookedSagaSeats) {
		this.bookedSagaSeats = bookedSagaSeats;
	}
	
	
}
