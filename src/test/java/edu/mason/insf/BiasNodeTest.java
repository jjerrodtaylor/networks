package edu.mason.insf;

import edu.mason.insf.utils.BiasNode;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BiasNodeTest {

    BiasNode biasNode = new BiasNode();

    @Test
    public void testValue()
    {
        biasNode.setValue(1);
        assertEquals(1,biasNode.getValue(),0);
    }

    @Test
    public void testValueSize()
    {
        biasNode.setValueSize(1);
        assertEquals(1, biasNode.getValueSize());
    }

    @Test
    public void testError()
    {
        biasNode.setError(1);
        assertEquals(1,biasNode.getError(),0);
    }

    @Test
    public void testErrorSize()
    {
        biasNode.setErrorSize(1);
        assertEquals(1,biasNode.getErrorSize(),0);
    }

    @Test
    public void testInLinks()
    {
        LinkedList<BaseLink> inLinks = new LinkedList<BaseLink>();
        inLinks.add(new BaseLink());
        biasNode.setInLinks(inLinks);
        assertEquals(inLinks.get(0),biasNode.getInLinks().get(0));
    }

    @Test
    public void testOutLinks()
    {
        LinkedList<BaseLink> outLinks = new LinkedList<BaseLink>();
        outLinks.add(new BaseLink());
        biasNode.setOutLinks(outLinks);
        assertEquals(outLinks.get(0),biasNode.getOutLinks().get(0));
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
