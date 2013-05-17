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
    protected LinkedList inLinks;     //List for input Links
    protected LinkedList outLinks;    //List for output links

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

    public LinkedList getInLinks()
    {
        return inLinks;
    }

    public LinkedList getOutLinks()
    {
        return outLinks;
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

}
