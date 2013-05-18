package edu.mason.insf;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/16/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface INode {

    public void run();

    public void learn();

    public void epoch();

    public void load();

    public void save();

    public void createLinkTo(BaseNode toNode, BaseLink link);

    public void connect(BaseNode fromNode, BaseNode toNode, BaseLink link);

    public void disconnect(BaseNode fromNode, BaseNode toNode);
}
