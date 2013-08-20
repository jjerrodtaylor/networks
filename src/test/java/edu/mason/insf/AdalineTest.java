package edu.mason.insf;


import edu.mason.insf.ann.adaline.AdalineNetwork;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import edu.mason.insf.ann.utils.Constants;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/8/13
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class AdalineTest {

    Helper helper = new Helper();
    AdalineNetwork aNetwork = new AdalineNetwork(.45);
    ArrayList<String> testData = helper.readFileToMemory("/Users/jamaaltaylor/Documents/workspace/networks/src/test/resources/breastcancer.csv");
    ArrayList<Pattern<Double>> inputPatterns = helper.turnListToPattern(testData);
    ArrayList<Pattern<Double>> trainingData = helper.partitionDataSet(.1, inputPatterns);

    @Test
    public void testInitializeNodes()
    {
        aNetwork.setTrainingData(trainingData);
        assertNotNull(aNetwork.getTrainingData());

        //test initializing the nodes
        aNetwork.initializeNodes(10);
        assertNotNull(aNetwork.getNodeList().get(0));
        assertNotNull(aNetwork.getNodeList().get(1));
        assertNotNull(aNetwork.getNodeList().get(2));

        //test initializing the links
        aNetwork.initializeLinks(11);
        assertNotNull(aNetwork.getLinkList().get(0));
        assertNotNull(aNetwork.getLinkList().get(1));
        assertNotNull(aNetwork.getLinkList().get(2));


        //test connecting everything together
        aNetwork.connectNodesAndLinks();
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(0).getInNode(), aNetwork.getLinkList().get(0).getInNode());
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(1).getInNode(), aNetwork.getLinkList().get(1).getInNode());
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(2).getInNode(), aNetwork.getLinkList().get(2).getInNode());

        aNetwork.connectBiasNode();

        aNetwork.setInputNodeValues(trainingData.get(0));
        assertEquals((double)5.0,(double)aNetwork.getNodeList().get(0).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(1).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(2).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(3).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)2.0,(double)aNetwork.getNodeList().get(4).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(5).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)3.0,(double)aNetwork.getNodeList().get(6).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(7).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(8).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)2.0,(double)aNetwork.getNodeList().get(9).getValue(Constants.NODE_VALUE),0.0);

        aNetwork.trainNetwork();

    }
}
