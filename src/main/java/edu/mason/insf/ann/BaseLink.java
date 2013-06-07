package edu.mason.insf.ann;

import edu.mason.insf.ann.utils.Constants;

import java.util.ArrayList;

/**
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:49 PM
 *
 * This is a base class that is used to represent links between nodes in a neural network.
 */
public  class BaseLink {

    private int ticket=0;

    public static final Integer WEIGHT = 0;
    protected int id;
    protected ArrayList<Double> value;
    protected BaseNode inNode;
    protected BaseNode outNode;
    protected int valueSize;

    public BaseLink(int size)
    {
        super();
        this.valueSize = size;

        if(valueSize <= 0)
        {
            value = null;
        }
        else
        {
            value = new ArrayList<Double>();
        }

        for(int i = 0; i < valueSize; i++)
        {
            this.value.add(i,0.0);
        }

        inNode = null;
        outNode = null;

        id=++ticket;
    }

    public int getValueSize() {
        return valueSize;
    }

    public void setValueSize(int valueSize) {
        this.valueSize = valueSize;
    }

    public Double getValue(int id)
    {
        return value.get(id);
    }

    public void setValue(int id, double newValue)
    {
        this.value.add(id, newValue);
    }

    //the original method signature. I'm not sure what you need the id for
    //public void setInNode(BaseNode node, int id)
    public void setInNode(BaseNode node)
    {
        this.inNode = node;
    }

    //the original method signature. I'm not sure what you need the id for
    //public void setOutNode(BaseNode node, int id)
    public void setOutNode(BaseNode node)
    {
        this.outNode = node;
    }

    public void updateWeight(double newVal)
    {
        this.setValue(Constants.WEIGHT, newVal);
    }

    public Double getInValue(int nodeValue)
    {
        return inNode.getValue(nodeValue);
    }

    public Double getOutValue(int nodeValue)
    {
        return outNode.getValue(nodeValue);
    }

    public Double getInError(int nodeValue)
    {
        return inNode.getError(nodeValue);
    }

    public Double getOutError(int nodeValue)
    {
        return outNode.getError(nodeValue);
    }

    public Double weightedInValue(int nodeValue)
    {
        //I don't understand why you get the value at weight yet. But hopefully I will later
        return inNode.getValue(nodeValue) * value.get(Constants.WEIGHT);
    }

    public Double weightedOutValue(int nodeValue)
    {
        return outNode.getValue(nodeValue) * value.get(Constants.WEIGHT);
    }

    public Double weightedInError(int nodeValue)
    {
        return inNode.getError(nodeValue) * value.get(Constants.WEIGHT);
    }

    public Double weightedOutError(int nodeValue)
    {
        return outNode.getError(nodeValue) * value.get(Constants.WEIGHT);
    }

}
