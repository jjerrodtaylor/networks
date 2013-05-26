package edu.mason.insf.ann.utils;

import edu.mason.insf.ann.BaseNode;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/24/13
 * Time: 8:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class InputNode extends BaseNode {

    public InputNode()
    {
        super();
    }

    public InputNode(double value)
    {
        super();
        this.value = value;
    }

    public InputNode(double value, double error)
    {
        super();
        this.value = value;
        this.error = error;

    }

}
