package edu.mason.insf.utils;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BiasNode extends InputNode
{
    public BiasNode()
    {
        super();
    }

    final public void setValue(double value)
    {
        this.value = value;
    }


    public double getValue()
    {
        return this.value;
    }

}
