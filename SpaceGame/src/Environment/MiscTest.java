package Environment;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiscTest {

    @Test
    public void testCapitalize() {
        // Setup
        final String s = "result";
        final String expectedResult = "Result";

        // Run the test
        final String result = Misc.capitalize(s);

        // Verify the results
        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void testFormatWithHTML() {
        // Setup
        final String message = "message";
        final String align = "left";
        final String expectedResult = "<html><div align=\"left\">message</div></html>";
        
        // Run the test
        final String result = Misc.formatWithHTML(message, align);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNumberPlusMinusRandom() {
        // Setup
        final int num = 0;
        final int range = 0;
        final int expectedResult = 0;

        // Run the test
        final int result = Misc.numberPlusMinusRandom(num, range);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNumberRandomMinMax() {
        // Setup
        final int min = 0;
        final int max = 0;
        final int expectedResult = 0;

        // Run the test
        final int result = Misc.numberRandomMinMax(min, max);

        // Verify the results
        assertEquals(expectedResult, result);
    }


}
