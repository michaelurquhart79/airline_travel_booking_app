import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

   private Plane smallPlane;

   @Before
   public void before(){
       smallPlane = new Plane(PlaneType.FIXEDWING);
   }

   @Test
    public void planeHasPlane(){
       assertEquals(PlaneType.FIXEDWING, smallPlane.getPlane());
   }

   @Test
    public void planehasCapacity(){
       assertEquals(2, smallPlane.getCapacityFromEnum());
   }

   @Test
    public void planeHasTotalWeight() {
       assertEquals(200.0, smallPlane.getTotalWeightFromEnum(), 0.01);
   }
}
