package edu.mason.insf;

import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.BaseNetwork;
import edu.mason.insf.ann.utils.Helper;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
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
