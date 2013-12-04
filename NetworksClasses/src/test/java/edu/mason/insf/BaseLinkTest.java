package edu.mason.insf;
import edu.mason.insf.ann.adaline.AdalineLink;
import edu.mason.insf.ann.utils.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import edu.mason.insf.ann.base.BaseLink;
import edu.mason.insf.ann.base.BaseNode;


public class BaseLinkTest {

    BaseLink link = new BaseLink();
    AdalineLink adalineLink = new AdalineLink();
    BaseNode inNode = new BaseNode();
    BaseNode outNode = new BaseNode();

    @Test
    public void testNodes()
    {
        inNode.setValue(Constants.WEIGHT,1.0);
        inNode.setError(0,2.0);

        //assertEquals(1.0,inNode.getValue(0),0);
        //assertEquals(2.0,inNode.getError(0),0);

        link.setInNode(inNode);
        assertEquals(inNode, link.getInNode());


        link.setOutNode(outNode);
        assertEquals(outNode, link.getOutNode());

        //testing getting the value from the in Node
        assertEquals(1.0, link.getInValue(Constants.WEIGHT), 0.0);
    }
}
