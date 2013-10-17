package edu.mason.insf.ann;


public class BiasNode extends InputNode
{
    private Double bias;

    public BiasNode(Double bias)
    {
        super();
        this.bias = bias;
    }

    public void setValue(int id, Double value)
    {
        this.value.put(id,value);
    }

    public void setBias(Double bias)
    {
        this.bias = bias;
    }

    public Double getBias()
    {
        return this.bias;
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
