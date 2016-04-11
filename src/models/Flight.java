package models;

/**
 * Created by - Flight Group - HBV401G
 * Spring 2016
 *
 *
 * Flight class, where each instance of this class
 * represents one flight, it implements Comparable
 * so it is possible to sort flights depending on
 * price criteria.
 */
public class Flight implements Comparable<Flight>{


    /**
     * Instance variables for various flight properties.
     */
    private int price;
    private String flightNumber;
    private String departureLoc;
    private String departureDate;
    private String departureTime;
    private String depAirportId;
    private String arrivalLoc;
    private String arrivalDate;
    private String arrivalTime;
    private String arrAirportId;
    private int numSeats;
    private int bookedSeats;
    private int numSagaSeats;
    private int bookedSagaSeats;
    private ConnectFlight connectFlight;
    private PassengerLuxuries passengerLuxuries;

    /**
     * The flight constructor with all of it's properties
     * @param departureDate
     * @param price
     * @param flightNumber
     * @param departureLoc
     * @param departureTime
     * @param depAirportId
     * @param arrivalLoc
     * @param arrivalDate
     * @param arrivalTime
     * @param arrAirportId
     * @param numSeats
     * @param bookedSeats
     * @param numSagaSeats
     * @param bookedSagaSeats
     * @param connectFlight
     * @param passengerLuxBool
     * @param passengerLuxInt
     */
    public Flight(String departureDate, double price, String flightNumber, String departureLoc, String departureTime,
                  String depAirportId, String arrivalLoc, String arrivalDate, String arrivalTime, String arrAirportId,
                  int numSeats, int bookedSeats, int numSagaSeats, int bookedSagaSeats,
                  String[] connectFlight, boolean[] passengerLuxBool, int[] passengerLuxInt) {

        this.flightNumber = flightNumber;
        this.price = price;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureLoc = departureLoc;
        this.depAirportId = depAirportId;
        this.arrivalDate =  arrivalDate;
        this.arrivalTime = arrivalTime;
        this.arrivalLoc = arrivalLoc;
        this.arrAirportId = arrAirportId;

        this.numSeats = numSeats;
        this.bookedSeats = bookedSeats;
        this.numSagaSeats = numSagaSeats;
        this.bookedSagaSeats = bookedSagaSeats;




        // Create an instance of PassengerLuxuries and ConnectFlight objects
        if(connectFlight == null){
            this.connectFlight = null;
        }
        else{
            this.connectFlight = new ConnectFlight(connectFlight[0], connectFlight[1],
                    connectFlight[2], connectFlight[3]);
        }

        this.setPassengerLuxuries(new PassengerLuxuries(passengerLuxBool[0], passengerLuxBool[1],
                passengerLuxInt[0], passengerLuxInt[1]));

    }

    /**
     * This function compares prices between two different flight objects
     * @param flight1
     * @return
     */
    @Override
    public int compareTo(Flight flight1){
        int comparePrice = ((Flight) flight1).getPrice();

        return comparePrice - this.getPrice();
    }

    /**
     * Returns if the flight is connected or not.
     * @return
     */
    private boolean isConnectedFlight() {
        return connectFlight == null;
    }

    /*
        GET/SET  METHODS
     */
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

    public PassengerLuxuries getPassengerLuxuries() {
        return passengerLuxuries;
    }

    public void setPassengerLuxuries(PassengerLuxuries passengerLuxuries) { this.passengerLuxuries = passengerLuxuries; }


    public String getDate() {
        return date;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
