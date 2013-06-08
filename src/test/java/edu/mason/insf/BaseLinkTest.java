package edu.mason.insf;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/17/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseLinkTest {

    BaseLink link = new BaseLink();
    BaseNode inNode = new BaseNode();

    public void testInNode()
    {
        inNode.setValue(0,1.0);
        inNode.setError(0,2.0);
        link.setInNode(inNode);
        assertEquals(1.0,inNode.getValue(0),0);
        assertEquals(2.0,inNode.getError(0),0);

    }
}
