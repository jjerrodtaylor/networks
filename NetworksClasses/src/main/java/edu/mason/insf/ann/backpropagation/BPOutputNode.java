package edu.mason.insf.ann.backpropagation;

import edu.mason.insf.ann.utils.Constants;

public class BPOutputNode extends BPNode {

    public BPOutputNode(double learnRate, double momentum, int vSize, int eSize)
    {
        super();
        value.put(Constants.LEARNING_RATE,learnRate);
        value.put(Constants.MOMENTUM,momentum);
    }

    public double computerError()
    {
        double error = value.get(Constants.NODE_VALUE)*
                       (1.0-value.get(Constants.NODE_VALUE))*
                       (value.get(Constants.NODE_ERROR)-value.get(Constants.NODE_VALUE));
        return 0.0;
    }

    /*
    * I need to read over the learning algorithm more
    * */
    public void learn()
    {

    }


}
