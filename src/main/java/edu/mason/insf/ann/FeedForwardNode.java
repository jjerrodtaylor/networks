package edu.mason.insf.ann;

import edu.mason.insf.ann.BaseNode;

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
        double total = 0;
        int count = inLinks.size();

        for(int i = 0; i< count; i++)
        {
            total += inLinks.get(i).weightedInValue();
        }
    }

    public String getName()
    {
        return "FeedForwardNode";
    }
}
