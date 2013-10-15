package edu.mason.insf.ann;


import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Pattern;

import java.util.ArrayList;

public class BaseNetwork extends BaseNode {

    protected ArrayList<InputNode> nodeList = new ArrayList<InputNode>();
    protected ArrayList<BaseLink> linkList = new ArrayList<BaseLink>();

    public ArrayList<InputNode> getNodeList()
    {
        return nodeList;
    }

    public BaseNode getNode(int number)
    {
        return this.nodeList.get(number);
    }

    public void setNodeList(ArrayList<InputNode> nodeList)
    {
        this.nodeList = nodeList;
    }

    public ArrayList<BaseLink> getLinkList()
    {
        return linkList;
    }

    public void setLinkList(ArrayList<BaseLink> linkList)
    {
        this.linkList = linkList;
    }

    public void setInputNodeValues(Pattern<Double> inputPattern)
    {
        for(int i=0; i<nodeList.size()-1; i++)
        {
            nodeList.get(i).setValue(Constants.NODE_VALUE, inputPattern.getInputPatternValue(i));
        }
        nodeList.get(nodeList.size()-1).setValue(Constants.NODE_VALUE,inputPattern.getOutputPatternValue(0));
    }

    public void connectNodesAndLinks(BaseNode node)
    {
        for(int i=0; i < nodeList.size(); i++)
        {
            nodeList.get(i).createLinkTo(node, linkList.get(i));
            node.createLinkTo(nodeList.get(i), linkList.get(i));
        }
    }

    public void initializeLinks(int numberOfLinks)
    {
        for(int i=0; i<numberOfLinks; i++)
        {
            BaseLink newLink = new BaseLink();
            linkList.add(newLink);
        }
    }

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
