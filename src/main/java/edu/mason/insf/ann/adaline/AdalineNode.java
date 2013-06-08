package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.FeedForwardNode;
import edu.mason.insf.ann.IFeedForward;
import edu.mason.insf.ann.utils.Constants;

/**
 * The class that implements the adeline node model
 */
public class AdalineNode extends FeedForwardNode implements IFeedForward
{

    public AdalineNode(double learningRate)
    {
        value.set(Constants.LEARNING_RATE, learningRate);
    }

    public void learn()
    {
        double nodeError = value.get(Constants.NODE_VALUE)* -2.0;
        error.set(Constants.NODE_ERROR, nodeError);
        BaseLink link;
        int count = inLinks.size();
        double delta;

        for(int i = 0; i < count; i++)
        {
            delta = value.get(Constants.LEARNING_RATE) * inLinks.get(i).getInValue(Constants.WEIGHT);
            inLinks.get(i).updateWeight(delta);
        }
    }

    public double transferFunction(double value)
    {
        if(value < 0)
        {
            return -1.0;
        }
        else
        {
            return 1.0;
        }
    }

    public String getName() {
        return "AdalineNode";
    }
}
