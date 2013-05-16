package main.java.edu.mason.insf;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public  abstract class BaseNode {

    private int ticket;

    protected int id;
    protected double value;
    protected int valueSize;
    protected double error;
    protected int errorSize;
    protected LinkedList inLinks;     //List for input Links
    protected LinkedList outLinks;    //List for output links

    abstract void run();

    abstract void learn();

    abstract void epoch();

    abstract void load();

    abstract void save();


}
