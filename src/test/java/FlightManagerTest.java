import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Flight flight1;
    private Plane plane1;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private FlightManager flightManager1;
//    private double bagWeight;


    @Before
    public void before() throws Exception {
        plane1 = new Plane(PlaneType.FIXEDWING);
        flight1 = new Flight(plane1, "BA999", AirportType.CDG, AirportType.EDI, "09:15 25-07-2019");
        passenger1 = new Passenger("Bob", 1);
        passenger2 = new Passenger("Mary", 0);
        passenger3 = new Passenger("Stu", 2);
        flightManager1 = new FlightManager(flight1);
    }

    @Test
    public void flightMangagerHasFlight() {
        assertEquals(flight1, flightManager1.getFlight());
    }

    @Test
    public void canDetermineBagWtReservedPerPassenger() {
        assertEquals(50.0, flightManager1.getBagWtResPerPassenger(), 0.01);
    }


    @Test
    public void canGetTotalWeightFromFlight() {
        assertEquals(200.0, flightManager1.getTotalWeightFromFlight(), 0.01);
    }

    @Test
    public void canGetCapacity() {
        assertEquals(2, flightManager1.getCapacity());
    }

    @Test
    public void canGetPassengerArrayList(){
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        assertEquals(2, flightManager1.getPassengers().size());
    }

    @Test
    public void canGetNumberOfBagsBookedIn(){
        flight1.bookPassenger(passenger3);
        flight1.bookPassenger(passenger2);
        assertEquals(2,flightManager1.checkedBagsCount());

    }

    @Test
    public void canCalculateBaggageWeightBookedIn() {
        flight1.bookPassenger(passenger3);
        flight1.bookPassenger(passenger2);
        assertEquals(100.0, flightManager1.bagWeightCheckedIn(), 0.01);
    }

    @Test
    public void canCalculateBaggageWeightRemaining() {
        flight1.bookPassenger(passenger3);
        flight1.bookPassenger(passenger2);
        assertEquals(0.0, flightManager1.bagWeightRemaining(), 0.01);
    }


    @Test
    public void canCalculateNegativeBaggageWeightRemaining() {
        flight1.bookPassenger(passenger3);
        flight1.bookPassenger(passenger1);
        assertEquals(-50.0, flightManager1.bagWeightRemaining(), 0.01);
//        This is obviously not ideal!!!! All the stuff to do with the baggage weight check
//        is in FlightManager but the bookPassenger() method is in Flight. Not sure how I would
//        prevent booking in of a passenger if there was no space for their bags. Don't want to
//        duplicate all the baggage stuff in Flight.
    }

}
