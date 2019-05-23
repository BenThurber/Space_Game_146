package Environment.CrewMemberTypes;

import Environment.GameEnvironment;
import Environment.Locations.Planet;
import Environment.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CrewMemberTest {

    private CrewMember crewMemberUnderTest;

    @Before
    public void setUp() {
        crewMemberUnderTest = new CrewMember("name", 0);
    }

    @Test
    public void testSleep1() {
        // Setup

        // Run the test
        crewMemberUnderTest.sleep();

        // Verify the results
    }

    @Test
    public void testEat1() {
        // Setup

        // Run the test
        crewMemberUnderTest.eat();

        // Verify the results
    }

    @Test
    public void testUseMedicalItem1() {
        // Setup

        // Run the test
        crewMemberUnderTest.useMedicalItem();

        // Verify the results
    }

    @Test
    public void testReceiveHealingFromDoctor1() {
        // Setup

        // Run the test
        crewMemberUnderTest.receiveHealingFromDoctor();

        // Verify the results
    }

    @Test
    public void testRepairSheilds1() {
        // Setup
        final Ship ship = null;

        // Run the test
        crewMemberUnderTest.repairSheilds(ship);

        // Verify the results
    }

    @Test
    public void testPilotShip() {
        // Setup

        // Run the test
        crewMemberUnderTest.pilotShip();

        // Verify the results
    }

    @Test
    public void testSearchPlanet() {
        // Setup
        final Planet planet = null;
        final GameEnvironment environment = null;
        final int findShipPartSucsessRate = 0;
        final String foundPartMessage = "foundPartMessage";
        final String couldntFindPartMessage = "couldntFindPartMessage";

        // Run the test
        crewMemberUnderTest.searchPlanet(planet, environment, findShipPartSucsessRate, foundPartMessage, couldntFindPartMessage);

        // Verify the results
    }

    @Test
    public void testSearchPlanet1() {
        // Setup
        final Planet planet = null;
        final GameEnvironment environment = null;

        // Run the test
        crewMemberUnderTest.searchPlanet(planet, environment);

        // Verify the results
    }

    @Test
    public void testAddHealth() {
        // Setup
        final int addedHealth = 0;

        // Run the test
        crewMemberUnderTest.addHealth(addedHealth);

        // Verify the results
    }

    @Test
    public void testAddHunger() {
        // Setup
        final int addedHunger = 0;

        // Run the test
        crewMemberUnderTest.addHunger(addedHunger);

        // Verify the results
    }

    @Test
    public void testAddExhaustion() {
        // Setup
        final int addedExhaustion = 0;

        // Run the test
        crewMemberUnderTest.addExhaustion(addedExhaustion);

        // Verify the results
    }

    @Test
    public void testKill() {
        // Setup

        // Run the test
        crewMemberUnderTest.kill();

        // Verify the results
    }

    @Test
    public void testHasSpacePlague() {
        // Setup

        // Run the test
        final boolean result = crewMemberUnderTest.hasSpacePlague();

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testSetNumActionsReset() {
        // Setup

        // Run the test
        crewMemberUnderTest.setNumActionsReset();

        // Verify the results
    }

    @Test
    public void testDecrementNumActions() {
        // Setup

        // Run the test
        final boolean result = crewMemberUnderTest.decrementNumActions();

        // Verify the results
        assertTrue(result);
    }
}
