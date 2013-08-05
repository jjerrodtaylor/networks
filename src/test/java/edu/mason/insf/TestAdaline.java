package edu.mason.insf;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;
import edu.mason.insf.ann.BiasNode;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.adaline.AdalineLink;
import edu.mason.insf.ann.adaline.AdalineNode;
import edu.mason.insf.ann.adaline.AdalineNetwork;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
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
public class TestAdaline {

    AdalineNetwork aNetwork = new AdalineNetwork(.45);

    @Test
    public void testInitializeNodes()
    {
        //test initializing the nodes
        aNetwork.initializeNodes(3);
        assertNotNull(aNetwork.getNodeList().get(0));
        assertNotNull(aNetwork.getNodeList().get(1));
        assertNotNull(aNetwork.getNodeList().get(2));

        //test initializing the links
        aNetwork.initializeLinks(3);
        assertNotNull(aNetwork.getLinkList().get(0));
        assertNotNull(aNetwork.getLinkList().get(1));
        assertNotNull(aNetwork.getLinkList().get(2));

        //test connecting everything together
        aNetwork.connectNodesAndLinks();
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(0).getInNode(), aNetwork.getLinkList().get(0).getInNode());
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(1).getInNode(), aNetwork.getLinkList().get(1).getInNode());
        assertEquals(aNetwork.getAdalineNode().getInLinks().get(2).getInNode(), aNetwork.getLinkList().get(2).getInNode());
    }
}
