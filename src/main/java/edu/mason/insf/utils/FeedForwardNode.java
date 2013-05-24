package edu.mason.insf.utils;

import edu.mason.insf.BaseNode;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class FeedForwardNode extends BaseNode
{
    public FeedForwardNode()
    {
        super();
    }

    public double transferFunction(double value)
    {
        return 0.0;
    }

    public void run(int mode)
    {

    }

    public String getName()
    {
        return "";
    }
}
