package java.edu.mason.insf;
import java.edu.mason.insf.utils.Pattern;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;



/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
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
    public void testInputPatternSize()
    {
        testPattern.setInputPatternSize(9);
        assertEquals(9, testPattern.getInputPatternSize());
    }

    @Test
    public void testOutputPatternSize()
    {
        testPattern.setOutputPatternSize(1);
        assertEquals(1, testPattern.getOutputPatternSize());
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
