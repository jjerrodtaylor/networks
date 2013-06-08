package edu.mason.insf.ann;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BiasNode extends InputNode
{
    public BiasNode(Double bias)
    {
        super();
        this.setValue(0,bias);
    }

    final public void setValue(int id, double value)
    {
        this.value.add(id,value);
    }


    public Double getValue(int id)
    {
        return this.value.get(id);
    }

    public String getName()
    {
        return "BiasNode";
    }

}
