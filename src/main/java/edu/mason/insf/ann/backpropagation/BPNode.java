package edu.mason.insf.ann.backpropagation;

import edu.mason.insf.ann.IFeedForward;

public class BPNode implements IFeedForward {

    public double transferFunction(double value)
    {
        return 1.0/(1.0+Math.exp(-value));
    }

    public void run()
    {

    }
}
