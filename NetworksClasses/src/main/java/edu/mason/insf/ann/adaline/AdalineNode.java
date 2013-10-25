package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNode;
import edu.mason.insf.ann.IFeedForward;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;

import java.util.LinkedList;

/**
 * The class that implements the adeline node model
 */
public class AdalineNode extends BaseNode implements IFeedForward
{

    public AdalineNode()
    {
        super();
    }

    public AdalineNode(Double learningRate)
    {
        value.put(Constants.LEARNING_RATE,learningRate);

        //initialize the node with a value between -1 and 1.
        value.put(Constants.WEIGHT, Helper.generateRandomDouble(-1,1));
    }

    /*
    * The delta rule changes the weight values by a percentage called the learning rate.
    * The learning rate is used to adjust the weights of the links.
    * */
    public void learn()
    {
        Double nodeValue = value.get(Constants.NODE_VALUE);
        double nodeError = nodeValue * -2.0;
        error.put(Constants.NODE_ERROR, nodeError);
        BaseLink link;
        int count = inLinks.size();
        double delta;

        for(int i = 0; i < count; i++)
        {
            link = inLinks.get(i);
            Double learningRate = value.get(Constants.LEARNING_RATE);
            Double value = inLinks.get(i).getInValue(Constants.NODE_VALUE);
            delta = learningRate * value * nodeError;
            inLinks.get(i).updateWeight(delta);
        }
    }

    public void run()
    {
        double total = 0;

        //find out how many input links there are
        int count = inLinks.size();

        for(int i = 0; i< count-1; i++)
        {
            //grab a specific link in sequence
            BaseLink specificInLink = inLinks.get(i);
            Double weightedValue = specificInLink.weightedInValue(Constants.NODE_VALUE);
            total += weightedValue;
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
