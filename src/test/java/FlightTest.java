import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight1;
    private Plane plane1;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;


    @Before
    public void before() {
        plane1 = new Plane(PlaneType.FIXEDWING);
        flight1 = new Flight(plane1, "BA999", AirportType.CDG, AirportType.EDI, "09:00");
        passenger1 = new Passenger("Bob", 1);
        passenger2 = new Passenger("Mary", 0);
        passenger3 = new Passenger("Stu", 2);
    }

    @Test
    public void flightHasFlightNumber() {
        assertEquals("BA999", flight1.getFlightNumber());
    }

    @Test
    public void flightHasDepartureTime() {
        assertEquals("09:00", flight1.getDepartureTime());
    }

    @Test
    public void flightHasPlane() {
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void flightHasDestination() {
        assertEquals(AirportType.CDG, flight1.getDestination());
    }

    @Test
    public void flightHasDepartureAirport() {
        assertEquals(AirportType.EDI, flight1.getDepartureAirport());
    }

    @Test
    public void flightHasNoPassengersInitially () {
        assertEquals(0, flight1.numberBooked());
    }

    @Test
    public void flightHasNumberOfAvailableSeats() {
        assertEquals(2, flight1.numberOfAvailableSeats());
    }

    @Test
    public void canBookPassengerOntoFlight() {
        flight1.bookPassenger(passenger1);
        assertEquals(1, flight1.numberBooked());
        assertEquals(1, flight1.numberOfAvailableSeats());
    }
}
