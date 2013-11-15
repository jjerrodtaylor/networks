package edu.mason.insf.ann;


import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Pattern;

import java.util.ArrayList;

/**
 *
 */
public class BaseNetwork extends BaseNode {

    protected ArrayList<InputNode> nodeList = new ArrayList<InputNode>();
    protected ArrayList<BaseLink> linkList = new ArrayList<BaseLink>();

    /**
     *
     * @return
     */
    public ArrayList<InputNode> getNodeList()
    {
        return nodeList;
    }

    /**
     *
     * @param number
     * @return
     */
    public BaseNode getNode(int number)
    {
        return this.nodeList.get(number);
    }

    /**
     *
     * @param nodeList
     */
    public void setNodeList(ArrayList<InputNode> nodeList)
    {
        this.nodeList = nodeList;
    }

    /**
     *
     * @return
     */
    public ArrayList<BaseLink> getLinkList()
    {
        return linkList;
    }

    /**
     *
     * @param linkList
     */
    public void setLinkList(ArrayList<BaseLink> linkList)
    {
        this.linkList = linkList;
    }

    /**
     *
     * @param inputPattern
     */
    public void setInputNodeValues(Pattern<Double> inputPattern)
    {
        for(int i=0; i<nodeList.size()-1; i++)
        {
            nodeList.get(i).setValue(Constants.NODE_VALUE, inputPattern.getInputPatternValue(i));
        }
        nodeList.get(nodeList.size()-1).setValue(Constants.NODE_VALUE,inputPattern.getOutputPatternValue(0));
    }

    /**
     *
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
     *
     * @param numberOfLinks
     */
    public void initializeLinks(int numberOfLinks)
    {
        for(int i=0; i<numberOfLinks; i++)
        {
            BaseLink newLink = new BaseLink();
            linkList.add(newLink);
        }
    }

    /**
     *
     * @param numberOfNodes
     */
    public void initializeNodes(int numberOfNodes)
    {
        BiasNode biasNode = new BiasNode(1.0);

        for(int i=0; i<numberOfNodes;i++)
        {
            InputNode newNode = new InputNode();
            nodeList.add(newNode);
        }
    }
}
