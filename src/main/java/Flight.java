import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportType destination;
    private AirportType departureAirport;
    private Date departureTime;

    public Flight (Plane plane, String flightNumber, AirportType destination, AirportType departureAirport, String departureTime) throws Exception {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;

        String pattern = "HH:mm dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        this.departureTime = simpleDateFormat.parse(departureTime);


//        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDepartureTime() {
        String pattern = "HH:mm dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(this.departureTime);
//        return this.departureTime;
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

    public double getTotalWeightFromPlane(){
        return this.plane.getTotalWeightFromEnum();
    }

    public int getCapacity() {
        return this.plane.getCapacityFromEnum();
    }

    public ArrayList<Passenger> getPassengers() {
        return new ArrayList<Passenger>(this.passengers);
    }
}
