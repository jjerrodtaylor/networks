package edu.mason.insf.ann.backpropagation;
import edu.mason.insf.ann.base.BaseNode;
import edu.mason.insf.ann.IFeedForward;

public class BPNode extends BaseNode implements IFeedForward {

    public BPNode()
    {
        super();
    }

    public double transferFunction(double value)
    {
        return 1.0/(1.0+Math.exp(-value));
    }

    public void run()
    {

    }
}
