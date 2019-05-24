package Environment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;

public class GameEnvironmentTest {

	private CrewMember crewMemberUnderTest;
	private CrewMember[] testMembers;
	private GameEnvironment environment;
	private Crew crewUnderTest;
	private GameEnvironment gameEnvironmentUnderTest;


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
    		crewUnderTest = new Crew();
    		gameEnvironmentUnderTest = new GameEnvironment();
    }
	

    @Test
    public void testSetDays() {
        // Setup
        final int days = 7;

        // Run the test
        gameEnvironmentUnderTest.setDays(days);

        // Verify the results
        assertTrue(gameEnvironmentUnderTest.getTotalDays() == days && gameEnvironmentUnderTest.getShipPartsTotalMissing() == 2*days/3);
    }
}
