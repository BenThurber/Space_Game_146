package Environment.Events;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Environment.Crew;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;
import Environment.GameEnvironment;



public class AsteroidBeltTest {
	
	private CrewMember crewMemberUnderTest;
	private CrewMember[] testMembers;
	private GameEnvironment environment;
	
    private Crew mockCrew;

    private AsteroidBelt asteroidBeltUnderTest;

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

    	asteroidBeltUnderTest = new AsteroidBelt(environment, environment.crew);
    }

    @Test
    public void testInitiate1() {
        // Setup
        final ArrayList<CrewMember> crewPiloting = environment.crew.getCrewMemberArray();
        environment.ship.addToSheildLevel(100);
        
        // Run the test
        asteroidBeltUnderTest.initiate(crewPiloting);

        // Verify the results
        assertTrue(environment.ship.getSheildLevel() < 100);
    }

    @Test
    public void testInitiate2() {
        // Setup
    		environment.ship.addToSheildLevel(100);
        
        // Run the test
        asteroidBeltUnderTest.initiate();

        // Verify the results
        assertTrue(environment.ship.getSheildLevel() < 100);
    }
    
    @Test
    public void testInitiate3() {
        // Setup
    		testMembers[0] = new Navigator("John");
    		testMembers[1]= new Navigator("Tester");
    		testMembers[2] = new Navigator("Arbiter");
    		environment.crew.addNewCrewMembers(testMembers);
    		environment.ship.addToSheildLevel(100);
        
        // Run the test
        asteroidBeltUnderTest.initiate();

        // Verify the results  could be a lot of values because of randomness...
        assertTrue(environment.ship.getSheildLevel() > 35);
    }

}
