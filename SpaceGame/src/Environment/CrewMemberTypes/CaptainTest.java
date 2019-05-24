package Environment.CrewMemberTypes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaptainTest {

	private Captain captainUnderTest;

	@Before
	public void setUp() {
		captainUnderTest = new Captain("name", 0);
	}

	@Test
	public void testSleep() {  // Test that exhaustion goes from 95 to 0 for captain
		// Setup
		captainUnderTest.addExhaustion(95);
		// Run the test
		captainUnderTest.sleep();

		// Verify the results
		assertEquals(captainUnderTest.getExhaustion(), 0);
	}

	@Test
	public void testEat() {  // Test that hunger goes from 95 to 0 for captain
		// Setup
		captainUnderTest.addExhaustion(95);
		// Run the test
		captainUnderTest.sleep();

		// Verify the results
		assertEquals(captainUnderTest.getHunger(), 0);
	}

	@Test
	public void testUseMedicalItem() {   // Test that health goes from 5 to 100 for captain
		// Setup
		captainUnderTest.addExhaustion(-95);
		// Run the test
		captainUnderTest.useMedicalItem();

		// Verify the results
		assertEquals(captainUnderTest.getHealth(), 100);
	}

	@Test
	public void testReceiveHealingFromDoctor() {
		captainUnderTest = new Captain("Tester");
		CrewMember member = new CrewMember("Tester");
		captainUnderTest.addHealth(-95);
		captainUnderTest.receiveHealingFromDoctor();
		assertEquals(100, captainUnderTest.getHealth());
		assertEquals(captainUnderTest.MAX_ACTIONS, captainUnderTest.getNumActions());
	}

	@Test
	public void testAddHealth() {
		// Setup
		final int addedHealth = -50;

		// Run the test
		captainUnderTest.addHealth(addedHealth);

		// Verify the results
		assertEquals(100 + addedHealth + captainUnderTest.CAPTAIN_HEALTH_DAMAGE_REDUCTION, captainUnderTest.getHealth());
	}

	@Test
	public void testAddExhaustion() {
		// Setup
		final int addedExhaustion = 50;

		// Run the test
		captainUnderTest.addExhaustion(addedExhaustion);

		// Verify the results
		assertEquals(0 + addedExhaustion - captainUnderTest.CAPTAIN_EXHAUSTION_DAMAGE_REDUCTION, captainUnderTest.getExhaustion());
	}

	@Test
	public void testAddHunger() {
		// Setup
		final int addedHunger = 50;

		// Run the test
		captainUnderTest.addHunger(addedHunger);

		// Verify the results
		assertEquals(0 + addedHunger - captainUnderTest.CAPTAIN_HUNGER_DAMAGE_REDUCTION, captainUnderTest.getHunger());
	}

}
