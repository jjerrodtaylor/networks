package edu.mason.insf.ann;

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
    protected Double[] value;
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
            value = new Double [valueSize];
        }

        for(int i = 0; i < valueSize; i++)
        {
            value[i] = 0.0;
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

    public Double[] getValue()
    {
        return value;
    }

    public void setValue(Double[] value)
    {
        this.value = value;
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

    }

    public Double[] getInValue(int nodeValue)
    {
        return inNode.getValue();
    }

    public Double[] getOutValue()
    {
        return outNode.getValue();
    }

    public double getInError()
    {
        return inNode.getError();
    }

    public double outError()
    {
        return outNode.getError();
    }

    public double weightedInValue()
    {
        //I don't understand why you get the value at weight yet. But hopefully I will later
        return inNode.getValue() * value[WEIGHT];
    }

    public double weightedOutValue()
    {
        return outNode.getValue() * value[WEIGHT];
    }

    public double weightedInError()
    {
        return inNode.getError() * value[WEIGHT];
    }

    public double weightedOutError()
    {
        return outNode.getError() * value[WEIGHT];
    }

    //public int getSetSize()
    //{

    //}
}
