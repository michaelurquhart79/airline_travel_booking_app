import java.util.ArrayList;

public class Flight {
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportType destination;
    private AirportType departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, AirportType destination, AirportType departureAirport, String departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public AirportType getDestination() {
        return this.destination;
    }

    public AirportType getDepartureAirport() {
        return this.departureAirport;
    }


    public int numberBooked() {
        return this.passengers.size();
    }

    public int numberOfAvailableSeats() {
        return this.plane.getCapacityFromEnum() - numberBooked();
    }

    public void bookPassenger(Passenger passenger) {
        if (numberOfAvailableSeats() > 0) {
            this.passengers.add(passenger);
        }
    }
}
