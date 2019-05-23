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
    }
	
	
	@Test
    public void testExecuteCrewMemberAction() {
        // Setup
        final CrewMember member = null;
        final String task = "task";

        // Run the test
        environment.executeCrewMemberAction(member, task);

        // Verify the results
    }

}
