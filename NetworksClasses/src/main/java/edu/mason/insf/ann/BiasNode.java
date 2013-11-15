package edu.mason.insf.ann;


/**
 *
 */
public class BiasNode extends InputNode
{
    private Double bias;

    /**
     *
     * @param bias
     */
    public BiasNode(Double bias)
    {
        super();
        this.bias = bias;
    }

    /**
     *
     * @param id
     * @param value
     */
    public void setValue(int id, Double value)
    {
        this.value.put(id,value);
    }

    /**
     *
     * @param bias
     */
    public void setBias(Double bias)
    {
        this.bias = bias;
    }

    /**
     *
     * @return
     */
    public Double getBias()
    {
        return this.bias;
    }

    /**
     *
     * @param id
     * @return
     */
    public Double getValue(int id)
    {
        return this.value.get(id);
    }

    /**
     *
     * @return
     */
    public String getName()
    {
        return "BiasNode";
    }

}
