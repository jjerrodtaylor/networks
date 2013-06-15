package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;
import edu.mason.insf.ann.IFeedForward;
import edu.mason.insf.ann.utils.Constants;

/**
 * The class that implements the adeline node model
 */
public class AdalineNode extends BaseNode implements IFeedForward
{

    public AdalineNode(double learningRate)
    {
        value.put(Constants.LEARNING_RATE,learningRate);
    }

    public void learn()
    {
        double nodeError = value.get(Constants.NODE_VALUE)* -2.0;
        error.put(Constants.NODE_ERROR, nodeError);
        BaseLink link;
        int count = inLinks.size();
        double delta;

        for(int i = 0; i < count; i++)
        {
            delta = value.get(Constants.LEARNING_RATE) * inLinks.get(i).getInValue(Constants.WEIGHT);
            inLinks.get(i).updateWeight(delta);
        }
    }

    public void run()
    {
        double total = 0;
        int count = inLinks.size();

        for(int i = 0; i< count; i++)
        {
            total += inLinks.get(i).weightedInValue(i);
        }

        this.setValue(Constants.NODE_VALUE, this.transferFunction(total));
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
