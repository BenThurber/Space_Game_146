package Environment.Events;

import Environment.Crew;
import Environment.GameEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class AlienPiratesTest {

    @Mock
    private GameEnvironment mockEnvironment;
    @Mock
    private Crew mockCrew;

    private AlienPirates alienPiratesUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        alienPiratesUnderTest = new AlienPirates(mockEnvironment, mockCrew);
    }

    @Test
    public void testInitiate1() {
        // Setup

        // Run the test
        alienPiratesUnderTest.initiate();

        // Verify the results
    }
}
