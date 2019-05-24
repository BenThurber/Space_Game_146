package Environment.Events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.GameEnvironment;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Scientist;

public class SpacePlagueTest {
	private SpacePlague spacePlagueUnderTest;
	private CrewMember crewMemberUnderTest;
	private CrewMember[] testMembers;
	private GameEnvironment environment;
	
	@Before
	public void setUp() {
		testMembers = new CrewMember[4];
		testMembers[0] = new Scientist("John");
    		testMembers[1]= new Scientist("Tester");
    		testMembers[2] = new Scientist("Arbiter");
    		crewMemberUnderTest = testMembers[1];
    		environment = new GameEnvironment();
    		environment.crew.addNewCrewMembers(testMembers);
    		environment.setDays(5);
        spacePlagueUnderTest = new SpacePlague(environment, environment.crew);
        
    }
	
	@Test
    public void testInitiate() {
        // Setup
		
        // Run the test
        spacePlagueUnderTest.initiate();

        // Verify the results
        boolean anyHavePlague = false;
        for (CrewMember member: environment.crew.getCrewMemberArray()) {
        		if (member.hasSpacePlague()) {
        			anyHavePlague = true;
        			break;
        		}
        }
        assertTrue(anyHavePlague);
    }
}
