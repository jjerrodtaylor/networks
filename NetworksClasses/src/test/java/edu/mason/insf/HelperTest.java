package edu.mason.insf;
import edu.mason.insf.ann.utils.Helper;
import java.util.ArrayList;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Pattern;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class HelperTest {

    Helper helper = new Helper();

    @Test
    public void testReadFileToMemory()
    {
        ArrayList<String> testData = helper.readFileToMemory(Constants.FILE_NAME);
        ArrayList<Pattern<Double>> testDataAsPattern = helper.turnListToPattern(testData);

        //make sure the entire data set is in memory
        assertEquals(699,testDataAsPattern.size());

        ArrayList<Pattern<Double>> trainingSet = helper.partitionDataSet(.10,testDataAsPattern);
        assertEquals(69, trainingSet.size());
    }
}
