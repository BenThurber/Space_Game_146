package Environment.Events;

import Environment.Crew;
import Environment.CrewMemberTypes.CrewMember;
import Environment.GameEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.MockitoAnnotations.initMocks;

public class EventTest {

    @Mock
    private GameEnvironment mockEnvironment;
    @Mock
    private Crew mockCrew;

    private Event eventUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        eventUnderTest = new Event(mockEnvironment, mockCrew);
    }

    @Test
    public void testInitiate() {
        // Setup

        // Run the test
        eventUnderTest.initiate();

        // Verify the results
    }

    @Test
    public void testInitiate1() {
        // Setup
        final ArrayList<CrewMember> crewDurringEvent = new ArrayList<>(Arrays.asList());

        // Run the test
        eventUnderTest.initiate(crewDurringEvent);

        // Verify the results
    }
}
