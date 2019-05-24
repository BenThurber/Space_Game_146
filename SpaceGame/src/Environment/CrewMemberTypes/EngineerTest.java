package Environment.CrewMemberTypes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.Ship;

public class EngineerTest {
	private Engineer engineerUnderTest;

    @Before
    public void setUp() {
        engineerUnderTest = new Engineer("name", 0);
    }

    @Test
    public void testRepairSheilds() {
        // Setup
        final Ship ship = new Ship();
        ship.addToSheildLevel(-95);

        // Run the test
        engineerUnderTest.repairSheilds(ship);

        // Verify the results
        assertEquals(100-95 + engineerUnderTest.SHEILD_REPAIR_AMOUNT, ship.getSheildLevel());
    }
}
