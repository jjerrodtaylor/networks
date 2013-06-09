package edu.mason.insf;
import edu.mason.insf.ann.*;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/17/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodesTest {

    BaseNode baseNode = new BaseNode();
    BiasNode biasNode = new BiasNode(1.0);
    //FeedForwardNode feedForwardNode = new FeedForwardNode();
    InputNode inputNode = new InputNode();

    @Test
    public void testValue()
    {
        //all node types should be able to do this
        baseNode.setValue(0, 2.0);
        assertEquals(2.0,baseNode.getValue(0),0);

        biasNode.setValue(0, 2.0);
        assertEquals(2.0,biasNode.getValue(0),0);

//        feedForwardNode.setValue(0, 2.0);
//        assertEquals(2.0,feedForwardNode.getValue(0),0);

        inputNode.setValue(0, 2.0);
        assertEquals(2.0,inputNode.getValue(0),0);
    }



    @Test
    public void testError()
    {
        baseNode.setError(0, 2.0);
        assertEquals(2.0,baseNode.getError(0),0);

        biasNode.setError(0, 2.0);
        assertEquals(2.0,biasNode.getError(0),0);

//        feedForwardNode.setError(0, 2.0);
//        assertEquals(2.0,feedForwardNode.getError(0),0);

        inputNode.setError(0, 2.0);
        assertEquals(2.0,inputNode.getError(0),0);
    }



    @Test
    public void testInLinks()
    {
        LinkedList<BaseLink> inLinks = new LinkedList<BaseLink>();
        inLinks.add(new BaseLink());

        baseNode.setInLinks(inLinks);
        assertEquals(inLinks.get(0),baseNode.getInLinks().get(0));

        biasNode.setInLinks(inLinks);
        assertEquals(inLinks.get(0),biasNode.getInLinks().get(0));

//        feedForwardNode.setInLinks(inLinks);
//        assertEquals(inLinks.get(0),feedForwardNode.getInLinks().get(0));

        inputNode.setInLinks(inLinks);
        assertEquals(inLinks.get(0),inputNode.getInLinks().get(0));
    }

    @Test
    public void testOutLinks()
    {
        LinkedList<BaseLink> outLinks = new LinkedList<BaseLink>();
        outLinks.add(new BaseLink());

        baseNode.setOutLinks(outLinks);
        assertEquals(outLinks.get(0),baseNode.getOutLinks().get(0));

        biasNode.setOutLinks(outLinks);
        assertEquals(outLinks.get(0),biasNode.getOutLinks().get(0));

//        feedForwardNode.setOutLinks(outLinks);
//        assertEquals(outLinks.get(0),feedForwardNode.getOutLinks().get(0));

        inputNode.setOutLinks(outLinks);
        assertEquals(outLinks.get(0),inputNode.getOutLinks().get(0));
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
