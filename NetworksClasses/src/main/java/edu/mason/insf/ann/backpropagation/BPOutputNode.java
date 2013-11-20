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
    * I'm not sure if this is correct. I need to find out how to verify this.
    * */
    public void learn()
    {
        double delta;
        value.put(Constants.NODE_ERROR,this.computerError());

        for(int i=0; i<inLinks.size(); i++)
        {
            delta = value.get(Constants.LEARNING_RATE) *
                    value.get(Constants.NODE_ERROR) *
                    inLinks.get(i).getValue(Constants.WEIGHT);

            inLinks.get(i).updateWeight(delta);
        }
    }


}
