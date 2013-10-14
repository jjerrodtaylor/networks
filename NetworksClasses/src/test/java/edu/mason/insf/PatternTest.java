package edu.mason.insf;
import edu.mason.insf.ann.utils.Pattern;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;



public class PatternTest
{
    public Pattern<Integer> testPattern = new Pattern<Integer>();

    @Test
    public void testPatternId()
    {
        testPattern.setId(1);
        assertEquals(1, testPattern.getId());
    }

    @Test
    public void testInputSet()
    {
        LinkedList<Integer> inputSet = new LinkedList<Integer>();
        inputSet.add(1);

        testPattern.setInputSet(inputSet);
        assertEquals((int)1, (int)testPattern.getInputSet().get(0));

    }

    @Test
    public void testOutputSet()
    {
        LinkedList<Integer> outputSet = new LinkedList<Integer>();
        outputSet.add(2);

        testPattern.setOutputSet(outputSet);
        assertEquals((int)2, (int)testPattern.getOutputSet().get(0));
    }
}
