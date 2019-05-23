package Environment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.Locations.Location;
import Environment.Locations.Planet;

public class ShipTest {
	
	private Ship shipUnderTest;
	
    @Before
    public void setUp() {
        shipUnderTest = new Ship();
    }

    @Test
    public void testAddToSheildLevel() {
        // Setup
        final int addedSheildEnergy = -22;

        // Run the test
        shipUnderTest.addToSheildLevel(addedSheildEnergy);

        // Verify the results
        assertEquals(100-22, shipUnderTest.getSheildLevel());
    }

    @Test
    public void testSetLocation1() {
        // Setup
        final Location location = new Planet();

        // Run the test
        shipUnderTest.setLocation(location);;

        // Verify the results
        assertTrue(shipUnderTest.getLocation().equals(location));
    }

    @Test
    public void testIsAlive() {
        // Setup

        // Run the test
        final boolean result = shipUnderTest.isAlive();

        // Verify the results
        assertTrue(result);
    }

}
