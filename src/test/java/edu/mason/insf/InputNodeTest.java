package edu.mason.insf;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;
import org.junit.Test;
import edu.mason.insf.ann.utils.InputNode;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputNodeTest {

    InputNode baseNode = new InputNode();

    @Test
    public void testFirstConstructor()
    {
        InputNode testInputNode = new InputNode(1);
        assertEquals(1, testInputNode.getValue(),0);
    }

    @Test
    public void testSecondConstructor()
    {
        InputNode testInputNode = new InputNode(1,2);
        assertEquals(1, testInputNode.getValue(),0);
        assertEquals(2, testInputNode.getError(),0);
    }

    @Test
    public void testValue()
    {
        baseNode.setValue(1);
        assertEquals(1,baseNode.getValue(),0);
    }

    @Test
    public void testValueSize()
    {
        baseNode.setValueSize(1);
        assertEquals(1, baseNode.getValueSize());
    }

    @Test
    public void testError()
    {
        baseNode.setError(1);
        assertEquals(1,baseNode.getError(),0);
    }

    @Test
    public void testErrorSize()
    {
        baseNode.setErrorSize(1);
        assertEquals(1,baseNode.getErrorSize(),0);
    }

    @Test
    public void testInLinks()
    {
        LinkedList<BaseLink> inLinks = new LinkedList<BaseLink>();
        inLinks.add(new BaseLink());
        baseNode.setInLinks(inLinks);
        assertEquals(inLinks.get(0),baseNode.getInLinks().get(0));
    }

    @Test
    public void testOutLinks()
    {
        LinkedList<BaseLink> outLinks = new LinkedList<BaseLink>();
        outLinks.add(new BaseLink());
        baseNode.setOutLinks(outLinks);
        assertEquals(outLinks.get(0),baseNode.getOutLinks().get(0));
    }

    @Test
    public void testCreateLinkTo()
    {
        BaseNode nodeA = new BaseNode();
        BaseNode nodeB = new BaseNode();

        nodeA.createLinkTo(nodeB);
        nodeB.createLinkTo(nodeA);

        //node A's outlink should be node B's in link
        assertEquals(nodeA.getOutLinks().get(0), nodeB.getInLinks().get(0));

        //node A's inlink should be node B's out link
        assertEquals(nodeA.getInLinks().get(0), nodeB.getOutLinks().get(0));
    }

}
