package Environment;

import Environment.CrewMemberTypes.CrewMember;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CrewTest {

    private Crew crewUnderTest;

    @Before
    public void setUp() {
        crewUnderTest = new Crew(Arrays.asList());
    }

    @Test
    public void testAddNewCrewMembers() {
        // Setup
        final CrewMember[] newMembers = new CrewMember[]{};

        // Run the test
        crewUnderTest.addNewCrewMembers(newMembers);

        // Verify the results
    }

    @Test
    public void testAddNewCrewMembers1() {
        // Setup
        final List<CrewMember> members = Arrays.asList();

        // Run the test
        crewUnderTest.addNewCrewMembers(members);

        // Verify the results
    }

    @Test
    public void testAddCrewMember() {
        // Setup
        final CrewMember newCrewMember = null;

        // Run the test
        crewUnderTest.addCrewMember(newCrewMember);

        // Verify the results
    }

    @Test
    public void testGetNumCrewMembers() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = crewUnderTest.getNumCrewMembers();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetCrewMember() {
        // Setup
        final int crewMemberID = 0;
        final CrewMember expectedResult = null;

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

        // Run the test
        final boolean result = crewUnderTest.isAlive();

        // Verify the results
        assertTrue(result);
    }
}
