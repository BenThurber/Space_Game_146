package Environment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;

public class CrewTest {
	
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
    public void testGetNumCrewMembers() {
        // Setup
        final int expectedResult = 3;
        crewUnderTest.addNewCrewMembers(testMembers);

        // Run the test
        final int result = crewUnderTest.getNumCrewMembers();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetCrewMember() {
        // Setup
        final int crewMemberID = testMembers[1].getCrewMemberID();
        final CrewMember expectedResult = testMembers[1];
        crewUnderTest.addNewCrewMembers(testMembers);

        // Run the test
        final CrewMember result = crewUnderTest.getCrewMember(crewMemberID);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetCrewMembersByName() {
        // Setup
        final String name = "name";
        final ArrayList<CrewMember> expectedResult = new ArrayList<>(Arrays.asList());

        // Run the test
        final ArrayList<CrewMember> result = crewUnderTest.getCrewMembersByName(name);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetCrewMembersBySpecialization() {
        // Setup
        final String specialization = "specialization";
        final boolean deadOrAlive = false;
        final ArrayList<CrewMember> expectedResult = new ArrayList<>(Arrays.asList());

        // Run the test
        final ArrayList<CrewMember> result = crewUnderTest.getCrewMembersBySpecialization(specialization, deadOrAlive);

        // Verify the results
        assertEquals(expectedResult, result);
    }
	
    @Test
    public void testGetCrewMembersBySpecialization1() {
        // Setup
        final String specialization = "specialization";
        final ArrayList<CrewMember> expectedResult = new ArrayList<>(Arrays.asList());

        // Run the test
        final ArrayList<CrewMember> result = crewUnderTest.getCrewMembersBySpecialization(specialization);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetNumLiveCrew() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = crewUnderTest.getNumLiveCrew();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetLiveCrewMemberArray() {
        // Setup
        final CrewMember[] expectedResult = new CrewMember[]{};

        // Run the test
        final CrewMember[] result = crewUnderTest.getLiveCrewMemberArray();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testResetCrewForNewDay() {
        // Setup

        // Run the test
        crewUnderTest.resetCrewForNewDay();

        // Verify the results
    }

    @Test
    public void testIsAlive() {
        // Setup
    		crewUnderTest.addNewCrewMembers(testMembers);
    	
        // Run the test
        final boolean result = crewUnderTest.isAlive();

        // Verify the results
        assertTrue(result);
    }

}
