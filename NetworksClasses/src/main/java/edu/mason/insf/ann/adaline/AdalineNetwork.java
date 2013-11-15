package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.BaseNetwork;
import edu.mason.insf.ann.BiasNode;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.utils.Constants;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Pattern;
import java.util.ArrayList;

/**
 *
 */
public class AdalineNetwork extends BaseNetwork
{

    private BiasNode biasNode = new BiasNode(1.0);
    private AdalineNode adalineNode = null;
    private ArrayList<Pattern<Double>> trainingData;
    private ArrayList<Pattern<Double>> testData;
    private Helper helper = new Helper();

    /**
     *
     */
    public AdalineNetwork()
    {
        adalineNode = new AdalineNode(.45);
        this.connectBiasNode();
    }

    /**
     *
     * @param learningRate
     * @param numOfNodes
     */
    public AdalineNetwork(Double learningRate, Integer numOfNodes)
    {
        adalineNode = new AdalineNode(learningRate);
        this.initializeNodes(numOfNodes);
        this.initializeLinks(numOfNodes);
        this.connectBiasNode();
    }

    /**
     *
     * @return
     */
    public BiasNode getBiasNode()
    {
        return this.biasNode;
    }

    /**
     *
     * @return
     */
    public BaseLink getBiasNodeLink()
    {
        return biasNode.getOutLinks().getFirst();
    }

    /**
     *
     * @return
     */
    public AdalineNode getAdalineNode()
    {
        return adalineNode;
    }

    /**
     *
     * @param adalineNode
     */
    public void setAdalineNode(AdalineNode adalineNode)
    {
        this.adalineNode = adalineNode;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pattern<Double>> getTrainingData()
    {
        return trainingData;
    }

    /**
     *
     * @param trainingData
     */
    public void setTrainingData(ArrayList<Pattern<Double>> trainingData)
    {
        this.trainingData = trainingData;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pattern<Double>> getTestData()
    {
        return testData;
    }

    /**
     *
     * @param testData
     */
    public void setTestData(ArrayList<Pattern<Double>> testData)
    {
        this.testData = testData;
    }

    /**
     *
     */
    private void connectBiasNode()
    {
        BaseLink newLink = new BaseLink();
        linkList.add(newLink);
        biasNode.createLinkTo(adalineNode,linkList.get(linkList.size()-1));
        adalineNode.createLinkTo(biasNode,linkList.get(linkList.size()-1));
    }

    /**
     *
     * @param caputreData
     */
    public void trainNetwork(Boolean caputreData)
    {

        int good = 0;
        ArrayList<String> outputData = new ArrayList<String>();

        //train until all patterns are good.
        while(good < trainingData.size())
        {
            for(int i=0; i< trainingData.size(); i++)
            {
                if(caputreData)
                {
                    outputData.add(helper.captureTrainingData(this,i));
                }

                this.setInputNodeValues(trainingData.get(i));
                adalineNode.run();

//                Double percentage = adalineNode.getValue(Constants.NODE_VALUE) * .02;
//
//                if(percentage < 0)
//                {
//                    percentage = percentage*-1;
//                }
//
//                Double answerToCompareTo = trainingData.get(i).getOutputSet().get(0);
//                Double upperBound = adalineNode.getValue(Constants.NODE_VALUE)+percentage;
//                Double lowerBound = adalineNode.getValue(Constants.NODE_VALUE)-percentage;
//                if(answerToCompareTo <= lowerBound || answerToCompareTo >= upperBound)
                if(trainingData.get(i).getOutputSet().get(0) != adalineNode.getValue(Constants.NODE_VALUE))
                {
                    adalineNode.learn();
                }
                else
                {
                    good++;
                }
            }
        }

        //if you are capturing data then write it to a file
        if(caputreData)
        {
            helper.writeFile(outputData,Constants.DESKTOP_PATH);
            helper.closeFileWriter();
        }
    }
}
