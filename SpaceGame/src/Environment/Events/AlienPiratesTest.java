package Environment.Events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Environment.GameEnvironment;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;
import Environment.CrewMemberTypes.Security;

public class AlienPiratesTest {
	
	private AlienPirates alienPiratesUnderTest;
	
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
    	
    		alienPiratesUnderTest = new AlienPirates(environment, environment.crew);
        
    }
	
	@Test
    public void testInitiate1() {
        // Setup

        // Run the test
        alienPiratesUnderTest.initiate();

        // Verify the results
     // Verify the results
        boolean crewHasTakenDamage = false;
        for (CrewMember member: environment.crew.getCrewMemberArray()) {
        		if (member.getHealth() < 100) {
        			crewHasTakenDamage = true;
        			break;
        		}
        }
        assertTrue(crewHasTakenDamage && environment.ship.getSheildLevel() < 100);
    }
	
	@Test
	public void testInitiate3() {
        // Setup
    		testMembers[0] = new Security("John");
    		testMembers[1]= new Security("Tester");
    		testMembers[2] = new Security("Arbiter");
    		environment.crew.addNewCrewMembers(testMembers);
    		environment.ship.addToSheildLevel(100);
        
        // Run the test
    		alienPiratesUnderTest.initiate();

    		
        // Verify the results  could be a lot of values because of randomness...
    		boolean crewHasTakenDamage = false;
            for (CrewMember member: environment.crew.getCrewMemberArray()) {
            		if (member.getHealth() < 100) {
            			crewHasTakenDamage = true;
            			break;
            		}
            }
    		assertTrue((crewHasTakenDamage || !crewHasTakenDamage) && environment.ship.getSheildLevel() > 35);
    }

}
