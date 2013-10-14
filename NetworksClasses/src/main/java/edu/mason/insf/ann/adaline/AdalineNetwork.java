package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNetwork;
import edu.mason.insf.ann.BiasNode;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import java.util.ArrayList;

public class AdalineNetwork extends BaseNetwork//  AdalineNode
{

    private BiasNode biasNode = new BiasNode(1.0);
    private AdalineNode adalineNode = null;
    private ArrayList<Pattern<Double>> trainingData;
    private ArrayList<Pattern<Double>> testData;
    private Helper helper = new Helper();

    public AdalineNetwork(Double learningRate)
    {
        adalineNode = new AdalineNode(learningRate);
    }

    public AdalineNode getAdalineNode()
    {
        return adalineNode;
    }

    public void setAdalineNode(AdalineNode adalineNode)
    {
        this.adalineNode = adalineNode;
    }

    public ArrayList<Pattern<Double>> getTrainingData()
    {
        return trainingData;
    }

    public void setTrainingData(ArrayList<Pattern<Double>> trainingData)
    {
        this.trainingData = trainingData;
    }

    public ArrayList<Pattern<Double>> getTestData()
    {
        return testData;
    }

    public void setTestData(ArrayList<Pattern<Double>> testData)
    {
        this.testData = testData;
    }

    public void connectBiasNode()
    {
        BaseLink newLink = new BaseLink();
        linkList.add(newLink);
        biasNode.createLinkTo(adalineNode,linkList.get(linkList.size()-1));
    }

    public void trainNetwork()
    {

        int good = 0;

        //train until all patterns are good.
        while(good < trainingData.size())
        {
            for(int i=0; i< trainingData.size(); i++)
            {
                this.setInputNodeValues(trainingData.get(i));
                adalineNode.run();
                //helper.printNetworkValues(nodeList, linkList, adalineNode, i, );

                Double percentage = adalineNode.getValue(Constants.NODE_VALUE) * .02;

                if(percentage < 0)
                {
                    percentage = percentage*-1;
                }

                Double answerToCompareTo = trainingData.get(i).getOutputSet().get(0);
                Double upperBound = adalineNode.getValue(Constants.NODE_VALUE)+percentage;
                Double lowerBound = adalineNode.getValue(Constants.NODE_VALUE)-percentage;
                if(answerToCompareTo <= lowerBound || answerToCompareTo >= upperBound)
                {
                    adalineNode.learn();
                }
                else
                {
                    good++;
                }
            }
        }
    }
}
