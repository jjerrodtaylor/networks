package edu.mason.insf;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public  class BaseLink {

    private int ticket;

    protected int id;
    protected double value;
    protected BaseNode inNode;
    protected BaseNode outNode;
    protected int valueSize;

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    //public abstract void setInNode(BaseNode node, int id);

    //public abstract void setOutNode(BaseNode node, int id);

}
