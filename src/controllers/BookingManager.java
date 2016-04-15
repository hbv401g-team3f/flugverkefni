package controllers;
        import models.Flight;

public class BookingManager {
    // PRIVATE VARIABLES
    private DatabaseUpdater databaseUpdater = new DatabaseUpdater();

    private void updateFlight(Flight flightToBook, int bookedSeatQty, boolean isSagaClass) {
        databaseUpdater.updateFlight(flightToBook, bookedSeatQty, isSagaClass);
    }
}