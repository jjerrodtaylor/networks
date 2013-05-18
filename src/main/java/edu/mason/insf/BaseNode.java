package edu.mason.insf;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseNode {

    private int ticket;

    protected int id;
    protected double value;
    protected int valueSize;
    protected double error;
    protected int errorSize;
    protected LinkedList<BaseLink> inLinks = new LinkedList<BaseLink>();     //List for input Links
    protected LinkedList<BaseLink> outLinks = new LinkedList<BaseLink>();    //List for output links

    public BaseNode()
    {
        super();
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double getError()
    {
        return error;
    }

    public void setError(double error)
    {
        this.error = error;
    }

    public int getId()
    {
        return id;
    }

    public LinkedList<BaseLink> getInLinks()
    {
        return inLinks;
    }

    public LinkedList<BaseLink> getOutLinks()
    {
        return outLinks;
    }

    public void setInLinks(LinkedList<BaseLink> inLinks) {
        this.inLinks = inLinks;
    }

    public void setOutLinks(LinkedList<BaseLink> outLinks) {
        this.outLinks = outLinks;
    }

    public void setValueSize(int valueSize)
    {
        this.valueSize = valueSize;
    }

    public int getValueSize()
    {
        return valueSize;
    }

    public void setErrorSize(int errorSize)
    {
        this.errorSize = errorSize;
    }

    public int getErrorSize()
    {
        return errorSize;
    }

    /**
     * Create a link from this node to another node
     * @param toNode
     * @param link
     */
    public void createLinkTo(BaseNode toNode, BaseLink link)
    {
        outLinks.add(link);
        toNode.getInLinks().add(link);
        //link.setOutNode(toNode, toNode.getId());
        //link.setInNode(this, this.id);
        link.setOutNode(toNode);
        link.setInNode(this);
    }

    public void createLinkTo(BaseNode toNode)
    {
        BaseLink link = new BaseLink();
        outLinks.add(link);
        toNode.getInLinks().add(link);
        //link.setOutNode(toNode, toNode.getId());
        //link.setInNode(this, this.id);
        link.setOutNode(toNode);
        link.setInNode(this);
    }

}
