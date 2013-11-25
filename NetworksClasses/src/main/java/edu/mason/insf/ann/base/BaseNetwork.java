package edu.mason.insf.ann.base;


import edu.mason.insf.ann.BiasNode;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Pattern;

import java.util.ArrayList;

/**
 * A class that contains functions that would be needed by all types of neural networks.
 */
public class BaseNetwork extends BaseNode {


    protected ArrayList<InputNode> nodeList = new ArrayList<InputNode>();
    protected ArrayList<BaseLink> linkList = new ArrayList<BaseLink>();

    /**
     * A getter function that returns the list of nodes.
     * This function returns an arraylist of input nodes.
     * @return ArrayList<InputNode>
     */
    public ArrayList<InputNode> getNodeList()
    {
        return nodeList;
    }

    /**
     * A getter function that returns a specific node from the list of nodes.
     * This function returns a base node object.
     * @param number
     * @return BaseNode
     */
    public BaseNode getNode(int number)
    {
        return this.nodeList.get(number);
    }

    /**
     * A setter function that sets the list of nodes.
     * @param nodeList
     */
    public void setNodeList(ArrayList<InputNode> nodeList)
    {
        this.nodeList = nodeList;
    }

    /**
     * A getter function that returns the list of links that connect the different nodes.
     * This function returns ArrayList<BaseLink>
     * @return ArrayList<BaseLink>
     */
    public ArrayList<BaseLink> getLinkList()
    {
        return linkList;
    }

    /**
     * A function to set the list of links used to connect the different nodes.
     * @param linkList
     */
    public void setLinkList(ArrayList<BaseLink> linkList)
    {
        this.linkList = linkList;
    }

    /**
     * A function to set the values of the input nodes. This function takes a Pattern object of type double
     * and a boolean. When the boolean value passed is True then a bias node will be inserted into the node list.
     * No bias node will be inserted when the value is set to false.
     * @param inputPattern
     * @param  biasNodeAdded
     */
    public void setInputNodeValues(Pattern<Double> inputPattern, boolean biasNodeAdded)
    {
        if(biasNodeAdded)
        {
            for(int i=0; i<nodeList.size()-2;i++)
            {
                nodeList.get(i+1).setValue(Constants.NODE_VALUE, inputPattern.getInputPatternValue(i));
            }
        }
        else
        {
            for(int i=0; i<nodeList.size()-1; i++)
            {
                nodeList.get(i).setValue(Constants.NODE_VALUE, inputPattern.getInputPatternValue(i));
            }
        }

        nodeList.get(nodeList.size()-1).setValue(Constants.NODE_VALUE,inputPattern.getOutputPatternValue(0));
    }

    /**
     * A function to connect nodes and links to a specified node.
     * @param node
     */
    public void connectNodesAndLinks(BaseNode node)
    {
        for(int i=0; i < nodeList.size(); i++)
        {
            nodeList.get(i).createLinkTo(node, linkList.get(i));
            node.createLinkTo(nodeList.get(i), linkList.get(i));
        }
    }

    /**
     * A function to initialise a specified number of link objects for your neural network.
     * The function also takes a boolean that determines whether an extra link gets added for
     * a bias node or not.
     * @param numberOfLinks
     * @param addLinkForBiasNode
     */
    public void initializeLinks(int numberOfLinks, boolean addLinkForBiasNode)
    {
        for(int i=0; i<numberOfLinks; i++)
        {
            BaseLink newLink = new BaseLink();
            linkList.add(newLink);
        }

        if(addLinkForBiasNode)
        {
            linkList.add(new BaseLink());
        }
    }

    /**
     * A function to initialize a specified number of node objects for your neural network.
     * The function also takes a boolean that determines whether an extra node gets added for a
     * bias node of not.
     * @param numberOfNodes
     * @param addBiasNode
     */
    public void initializeNodes(int numberOfNodes, boolean addBiasNode)
    {
        BiasNode biasNode = new BiasNode(1.0);
        if(addBiasNode)
        {
            nodeList.add(biasNode);
        }

        for(int i=0; i<numberOfNodes;i++)
        {
            InputNode newNode = new InputNode();
            nodeList.add(newNode);
        }
    }
}
