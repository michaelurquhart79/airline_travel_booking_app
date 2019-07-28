import java.util.ArrayList;
import java.util.BitSet;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }


    public Flight getFlight() {
        return this.flight;
    }

    public double getBagWtResPerPassenger() {
        return ((this.getTotalWeightFromFlight()/2) / (this.getCapacity()));
    }

    public double getTotalWeightFromFlight() {
        return this.flight.getTotalWeightFromPlane();
    }

    public int getCapacity() {
        return this.flight.getCapacity();
    }

    public ArrayList<Passenger> getPassengers() {
        return this.flight.getPassengers();
    }

    public int checkedBagsCount() {
        ArrayList<Passenger> passengers = getPassengers();
        int bagCount = 0;
        for (Passenger passenger: passengers) {
            bagCount += passenger.getNumberOfBags();
        }
        return bagCount;
    }

    public double bagWeightCheckedIn() {
        return (getBagWtResPerPassenger() * checkedBagsCount());
//        this function assumes that the bag weight reserved per person is equal to the weight of one bag
    }

    public double bagWeightRemaining() {
        return (getTotalWeightFromFlight()/2) - bagWeightCheckedIn();
    }
}
