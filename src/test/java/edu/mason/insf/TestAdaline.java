package edu.mason.insf;

import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/8/13
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestAdaline {

    @Test
    public void testTranformData()
    {
        ArrayList<String> testData = Helper.readFileToMemory("/Users/jamaaltaylor/Documents/workspace/networks/src/test/resources/breastcancer.csv");
        ArrayList<Pattern<Integer>> inputPatterns = Helper.turnListToPattern(testData);
    }
}
