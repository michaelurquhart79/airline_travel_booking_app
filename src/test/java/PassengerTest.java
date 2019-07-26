import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger1;

    @Before
    public void before() {
        passenger1 = new Passenger("Bob Smith", 1);
    }

    @Test
    public void passengerHasName() {
        assertEquals("Bob Smith", passenger1.getName());
    }

    @Test
    public void passengerHasBagNumber() {
        assertEquals(1, passenger1.getNumberOfBags());
    }

}
