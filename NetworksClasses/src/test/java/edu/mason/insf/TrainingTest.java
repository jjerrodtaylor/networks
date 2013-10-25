package edu.mason.insf;

import edu.mason.insf.ann.adaline.*;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import org.junit.Test;

import java.util.ArrayList;

public class TrainingTest {

    Helper helper = new Helper();
    AdalineNetwork aNetwork = new AdalineNetwork(.45,4);
    AdalineNode aNode = new AdalineNode();
    ArrayList<String> testData = helper.readFileToMemory(Constants.TEST_FILE);
    ArrayList<Pattern<Double>> inputPatterns = helper.turnListToPattern(testData);
    ArrayList<Pattern<Double>> trainingData = helper.partitionDataSet(.1, inputPatterns);

    @Test
    public void Train()
    {
        aNetwork.setTrainingData(trainingData);
        aNetwork.trainNetwork();
    }


}
