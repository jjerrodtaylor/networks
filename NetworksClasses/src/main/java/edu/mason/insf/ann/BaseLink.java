package edu.mason.insf.ann;

import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:49 PM
 *
 * This is a base class that is used to represent links between nodes in a neural network.
 */
public  class BaseLink {


    protected Double weight;
    protected int id;
    protected HashMap<Integer, Double> value;
    protected BaseNode inNode;
    protected BaseNode outNode;
    protected int valueSize;

    /**
     *
     */
    public BaseLink()
    {
        super();

        inNode = null;
        outNode = null;
        //use randomly generated double as initial weight
        weight = Helper.generateRandomDouble(-1,1);
        value = new HashMap<Integer, Double>();
        value.put(Constants.WEIGHT,weight);
    }

    /**
     *
     * @return
     */
    public int getValueSize() {
        return valueSize;
    }

    /**
     *
     * @param valueSize
     */
    public void setValueSize(int valueSize) {
        this.valueSize = valueSize;
    }

    /**
     *
     * @param id
     * @return
     */
    public Double getValue(int id)
    {
        return value.get(id);
    }

    /**
     *
     * @param id
     * @param newValue
     */
    public void setValue(int id, double newValue)
    {
        this.value.put(id,newValue);
    }

    /**
     *
     * @param node
     */
    public void setInNode(BaseNode node)
    {
        this.inNode = node;
    }

    /**
     *
     * @return
     */
    public BaseNode getInNode()
    {
        return this.inNode;
    }

    /**
     *
     * @param node
     */
    public void setOutNode(BaseNode node)
    {
        this.outNode = node;
    }

    /**
     *
     * @return
     */
    public BaseNode getOutNode()
    {
        return this.outNode;
    }

    /**
     *
     * @param newVal
     */
    public void updateWeight(double newVal)
    {
        this.setValue(Constants.WEIGHT, newVal);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double getInValue(int nodeValue)
    {
        return inNode.getValue(nodeValue);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double getOutValue(int nodeValue)
    {
        return outNode.getValue(nodeValue);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double getInError(int nodeValue)
    {
        return inNode.getError(nodeValue);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double getOutError(int nodeValue)
    {
        return outNode.getError(nodeValue);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double weightedInValue(int nodeValue)
    {
        //I don't understand why you get the value at weight yet. But hopefully I will later
        Double inNodeValue = inNode.getValue(nodeValue);
        Double weightedValue = value.get(Constants.WEIGHT);
        return inNodeValue * weightedValue;
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double weightedOutValue(int nodeValue)
    {
        return outNode.getValue(nodeValue) * value.get(Constants.WEIGHT);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double weightedInError(int nodeValue)
    {
        return inNode.getError(nodeValue) * value.get(Constants.WEIGHT);
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    public Double weightedOutError(int nodeValue)
    {
        return outNode.getError(nodeValue) * value.get(Constants.WEIGHT);
    }

}
