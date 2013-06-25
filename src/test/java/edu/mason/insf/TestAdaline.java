package edu.mason.insf;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;
import edu.mason.insf.ann.BiasNode;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.adaline.AdalineLink;
import edu.mason.insf.ann.adaline.AdalineNode;
import edu.mason.insf.ann.utils.Constants;
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
        Helper helper = new Helper();
        ArrayList<String> testData = helper.readFileToMemory("/Users/jamaaltaylor/Documents/workspace/networks/src/test/resources/breastcancer.csv");
        ArrayList<Pattern<Double>> inputPatterns = helper.turnListToPattern(testData);
        AdalineLink aLink = new AdalineLink();
        AdalineNode aNode = new AdalineNode(0.45);
        InputNode nodeArray[] = new InputNode[14];
        BaseLink linkArray[] = new BaseLink[13];

        nodeArray[0] = new InputNode();
        nodeArray[1] = new InputNode();
        nodeArray[2] = new InputNode();
        nodeArray[3] = new InputNode();
        nodeArray[4] = new InputNode();
        nodeArray[5] = new InputNode();
        nodeArray[6] = new InputNode();
        nodeArray[7] = new InputNode();
        nodeArray[8] = new InputNode();
        nodeArray[9] = new InputNode();
        nodeArray[10] = new InputNode();
        nodeArray[11] = new InputNode();
        nodeArray[12] = new BiasNode(1.0);

        linkArray[0] = new AdalineLink();
        linkArray[1] = new AdalineLink();
        linkArray[2] = new AdalineLink();
        linkArray[3] = new AdalineLink();
        linkArray[4] = new AdalineLink();
        linkArray[5] = new AdalineLink();
        linkArray[6] = new AdalineLink();
        linkArray[7] = new AdalineLink();
        linkArray[8] = new AdalineLink();
        linkArray[9] = new AdalineLink();
        linkArray[10] = new AdalineLink();
        linkArray[11] = new AdalineLink();
        linkArray[12] = new AdalineLink();


        nodeArray[0].createLinkTo(aNode, linkArray[0]);
        nodeArray[1].createLinkTo(aNode, linkArray[1]);
        nodeArray[2].createLinkTo(aNode, linkArray[2]);

        nodeArray[3].createLinkTo(aNode, linkArray[3]);
        nodeArray[4].createLinkTo(aNode, linkArray[4]);
        nodeArray[5].createLinkTo(aNode, linkArray[5]);

        nodeArray[6].createLinkTo(aNode, linkArray[6]);
        nodeArray[7].createLinkTo(aNode, linkArray[7]);
        nodeArray[8].createLinkTo(aNode, linkArray[8]);

        nodeArray[9].createLinkTo(aNode, linkArray[9]);
        nodeArray[10].createLinkTo(aNode, linkArray[10]);
        nodeArray[11].createLinkTo(aNode, linkArray[11]);
        nodeArray[12].createLinkTo(aNode, linkArray[12]);

        int good = testData.size();

        //go through each test pattern
        for(int i=0; i<inputPatterns.size(); i++)
        {
            //set the values of all of the input nodes
            for(int j=0; j<inputPatterns.get(i).getInputSet().size();j++)
            {
                nodeArray[j].setValue(Constants.NODE_VALUE,inputPatterns.get(i).getInputPatternValue(j));

                if(j == inputPatterns.get(i).getInputSet().size()-1)
                {
                    //run the adaline node
                    aNode.run();

                    if(inputPatterns.get(i).getOutputSet().get(j) != aNode.getValue(Constants.NODE_VALUE))
                    {
                        aNode.learn();
                    }
                    else
                    {
                        good++;
                    }
                }
            }
        }
    }
}
