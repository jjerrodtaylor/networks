package edu.mason.insf;

import edu.mason.insf.ann.adaline.AdalineNetwork;
import edu.mason.insf.ann.adaline.AdalineNode;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import edu.mason.insf.ann.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;


public class AdalineTest {

    Helper helper = new Helper();
    AdalineNetwork aNetwork;
    //AdalineNode aNode = new AdalineNode();
    ArrayList<String> testData = helper.readFileToMemory(Constants.FILE_NAME);
    //ArrayList<Pattern<Double>> inputPatterns = helper.turnListToPattern(testData);
    //ArrayList<Pattern<Double>> trainingData = helper.partitionDataSet(.1, inputPatterns);

    @Before
    public void SetUp()
    {
        aNetwork = new AdalineNetwork();
        //aNetwork.setTrainingData(trainingData);
        aNetwork.initializeNodes(10,true);
        aNetwork.initializeLinks(10,true);
        aNetwork.connectNodesAndLinks(aNetwork.getAdalineNode());
    }

    @Test
    public void testConnectBiasNode()
    {
        assertEquals(aNetwork.getNodeList().get(0), aNetwork.getAdalineNode().getInLinks().get(0).getOutNode());
    }

    @Test
    public void testSetData()
    {
        assertNotNull(aNetwork.getTrainingData());
    }

    @Test
    public void testInitializeNodes()
    {
        assertNotNull(aNetwork.getNodeList().get(0));
        assertNotNull(aNetwork.getNodeList().get(1));
        assertNotNull(aNetwork.getNodeList().get(2));
    }

    @Test
    public void testInitializeLinks()
    {
        assertNotNull(aNetwork.getLinkList().get(0));
        assertNotNull(aNetwork.getLinkList().get(1));
        assertNotNull(aNetwork.getLinkList().get(2));
    }

    @Test
    public void testConnectNodesAndLinks()
    {
        assertEquals(aNetwork.getNode(0), aNetwork.getLinkList().get(0).getOutNode());
        assertEquals(aNetwork.getNode(1), aNetwork.getLinkList().get(1).getOutNode());
        assertEquals(aNetwork.getNode(2), aNetwork.getLinkList().get(2).getOutNode());
    }

    @Test
    public void testSetInputNodeValues()
    {
        //aNetwork.setInputNodeValues(trainingData.get(0),true);
        assertEquals((double)5.0,(double)aNetwork.getNodeList().get(1).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(2).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(3).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(4).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)2.0,(double)aNetwork.getNodeList().get(5).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(6).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)3.0,(double)aNetwork.getNodeList().get(7).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(8).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)1.0,(double)aNetwork.getNodeList().get(9).getValue(Constants.NODE_VALUE),0.0);
        assertEquals((double)2.0,(double)aNetwork.getNodeList().get(10).getValue(Constants.NODE_VALUE),0.0);
    }
}
