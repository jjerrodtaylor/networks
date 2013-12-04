package edu.mason.insf;

import edu.mason.insf.ann.base.BaseNetwork;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseNetworkTest
{

    public BaseNetwork baseNetwork = new BaseNetwork();

    @Test
    public void testInitializeNodes()
    {
        baseNetwork.initializeNodes(5,true);
        assertEquals(6, baseNetwork.getNodeList().size());
    }

    @Test
    public void testInitializeLinks()
    {
        baseNetwork.initializeLinks(5, true);
        assertEquals(6, baseNetwork.getLinkList().size());
    }

    @Test
    public void SetUp()
    {

    }

}
