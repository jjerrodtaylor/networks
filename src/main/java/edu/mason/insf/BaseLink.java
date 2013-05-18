package edu.mason.insf;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public  class BaseLink {

    private int ticket=0;

    protected int id;
    protected double value;
    protected BaseNode inNode;
    protected BaseNode outNode;
    protected int valueSize;

    public BaseLink()
    {
        super();
        id=++ticket;
    }

    public int getValueSize() {
        return valueSize;
    }

    public void setValueSize(int valueSize) {
        this.valueSize = valueSize;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
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
}
