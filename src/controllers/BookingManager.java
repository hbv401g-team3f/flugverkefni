package controllers;
        import models.Flight;

public class BookingManager {
    // PRIVATE VARIABLES
    private DatabaseUpdater databaseUpdater = new DatabaseUpdater();

    public void updateFlight(Flight flightToBook, int bookedSeatQty, boolean bookSagaSeats) {
        databaseUpdater.updateFlight(flightToBook, bookedSeatQty, bookSagaSeats);
    }
}