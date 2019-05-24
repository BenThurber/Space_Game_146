package Environment.CrewMemberTypes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.GameEnvironment;
import Environment.Ship;
import Environment.Locations.Planet;

public class CrewMemberTest {
	private CrewMember crewMemberUnderTest;
	private CrewMember[] testMembers;
	private GameEnvironment environment;
	//private Ship testShip;

    @Before
    public void setUp() {
    		testMembers = new CrewMember[4];
    		testMembers[0] = new Scientist("John");
    		testMembers[1]= new Navigator("Tester");
    		testMembers[2] = new Engineer("Arbiter");
    		crewMemberUnderTest = testMembers[1];
    		environment = new GameEnvironment();
    		environment.crew.addNewCrewMembers(testMembers);
    		environment.setDays(5);
    }
	
	@Test
	public void testSleep() {
		crewMemberUnderTest = new CrewMember("Tester");
		crewMemberUnderTest.addExhaustion(95);
		crewMemberUnderTest.sleep();
		assertEquals(95 + crewMemberUnderTest.EXHAUSTION_LVL_INCREASE_SLEEP, crewMemberUnderTest.getExhaustion());
	}

	@Test
	public void testEat() {
		crewMemberUnderTest = new CrewMember("Tester");
		crewMemberUnderTest.addHunger(54);
		crewMemberUnderTest.eat();
		assertEquals(54 + crewMemberUnderTest.HUNGER_LVL_INCREASE_EAT, crewMemberUnderTest.getHunger());
	}

	@Test
	public void testUseMedicalItem() {
		crewMemberUnderTest = new CrewMember("Tester");
		crewMemberUnderTest.addHealth(-77);
		crewMemberUnderTest.useMedicalItem();
		assertEquals(100-77 + crewMemberUnderTest.HEALTH_LVL_INCREASE_MED_ITEM, crewMemberUnderTest.getHealth());
		assertEquals(crewMemberUnderTest.MAX_ACTIONS-1, crewMemberUnderTest.getNumActions());
	}

	@Test
	public void testReceiveHealingFromDoctor() {
		crewMemberUnderTest = new CrewMember("Tester");
		crewMemberUnderTest.addHealth(-94);
		crewMemberUnderTest.receiveHealingFromDoctor();
		assertEquals(100-94 + crewMemberUnderTest.HEALTH_LVL_INCREASE_MED_ITEM, crewMemberUnderTest.getHealth());
		assertEquals(crewMemberUnderTest.MAX_ACTIONS, crewMemberUnderTest.getNumActions());
	}

	@Test
	public void testRepairSheildsShip() {
		crewMemberUnderTest = new CrewMember("Tester");
		Ship ship = new Ship();
		ship.addToSheildLevel(-43);
		crewMemberUnderTest.repairSheilds(ship);
		assertEquals(100-43 + crewMemberUnderTest.SHEILD_REPAIR_AMOUNT, ship.getSheildLevel());
	}

	@Test
    public void testSearchPlanet() {
        // Setup
        final Planet planet = new Planet();
        final int findShipPartSucsessRate = 75;
        final String foundPartMessage = "foundPartMessage";
        final String couldntFindPartMessage = "couldntFindPartMessage";

        // Run the test
        crewMemberUnderTest.searchPlanet(planet, environment, findShipPartSucsessRate, foundPartMessage, couldntFindPartMessage);

        // Verify the results
        assertTrue(environment.getShipPartsFound() == 1 || environment.getShipPartsFound() == 0);
    }
	
	@Test
    public void testKill() {
        // Setup

        // Run the test
        crewMemberUnderTest.kill();

        // Verify the results
        assertTrue(!crewMemberUnderTest.isAlive());
    }
	
    @Test
    public void testHasSpacePlague() {
        // Setup
    		crewMemberUnderTest.setHasSpacePlague(true);
        // Run the test
        final boolean result = crewMemberUnderTest.hasSpacePlague();

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testDecrementNumActions() {
        // Setup

        // Run the test
        final boolean result = crewMemberUnderTest.decrementNumActions();

        // Verify the results
        assertTrue(result && crewMemberUnderTest.getNumActions() == crewMemberUnderTest.MAX_ACTIONS - 1);
    }
}
