package edu.mason.insf;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * A class to test the Pattern Objects found in edu.mason.insf.ann.utils.Pattern
 */
public class PatternTest
{
    Pattern<Double> testPattern;

    /**
     *  The SetUp function that reads in data and initializes the testPattern object that will be tested.
     */
    @Before
    public void SetUp()
    {
        Helper helper = new Helper();
        ArrayList<String> testData = helper.readFileToMemory(Constants.TEST_FILE);
        //ArrayList<Pattern<Double>> inputPatterns = helper.turnListToPattern(testData);
        //testPattern = inputPatterns.get(0);
    }

    /**
     * A test for the getInputSet function.
     */
    @Test
    public void testInputSet()
    {
        assertNotNull(testPattern);
        assertEquals(0, testPattern.getInputSet().get(0),0);
    }

    /**
     * A test for the getOutputSet function.
     */
    @Test
    public void testOutputSet()
    {
        assertNotNull(testPattern);
        assertEquals(-1, testPattern.getOutputSet().get(0),0);
    }

    /**
     * A test for the getInputPatternSize function.
     */
    @Test
    public void testGetInputSetSize()
    {
        assertEquals(3, testPattern.getInputPatternSize());
    }

    /**
     * A test for the getOutputPatternSize function.
     */
    @Test
    public void testGetOutputSetSize()
    {
        assertEquals(1, testPattern.getOutputPatternSize());
    }

    /**
     * A test for the getInputPatternValue function.
     */
    @Test
    public void testGetInputPatternValue()
    {
        assertEquals(0.8863739834514472,testPattern.getInputPatternValue(1),0);
    }

    /**
     * Tests for the setInputPatterValue and setInputPatternValueAtIndex functions.
     */
    @Test
    public void testSetInputPatternValue()
    {
        testPattern.setInputPatternValue(21.0);
        assertEquals(21.0, testPattern.getInputPatternValue(testPattern.getInputPatternSize()-1),0);

        testPattern.setInputPatternValueAtIndex(22.0,0);
        assertEquals(22.0, testPattern.getInputPatternValue(0),0);
    }

    /**
     * Tests for the setOutputPatternValue and setOutputPatternValueAtIndex functions.
     */
    @Test
    public void testSetOutputPatternValue()
    {
        testPattern.setOutputPatternValue(31.0);
        assertEquals(31.0, testPattern.getOutputPatternValue(testPattern.getOutputPatternSize()-1),0);

        testPattern.setOutputPatternValueAtIndex(32.0,0);
        assertEquals(32.0, testPattern.getOutputPatternValue(0),0);
    }
}
