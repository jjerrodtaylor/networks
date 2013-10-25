package edu.mason.insf.ann.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.adaline.AdalineNetwork;
import edu.mason.insf.ann.adaline.AdalineNode;
import edu.mason.insf.ann.utils.Pattern;

public class Helper {

    public BufferedWriter bw = null;
    public FileOutputStream fOutStream = null;
    public Helper()
    {
        super();
    }

    public static double generateRandomDouble(int min, int max)
    {
        return min + (double)(Math.random() * ((max - min) + 1));
    }


    /*
    * A generic function to write data to a file.
    * */
    public void writeFile(ArrayList<String> linesToWrite, String nameOfFile)
    {
        try
        {
            bw = new BufferedWriter(new FileWriter(nameOfFile));

            for(String s: linesToWrite)
            {
                bw.write(s);
                bw.newLine();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void closeFileWriter()
    {
        try
        {
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> generateAdalineTrainingData(int howMany)
    {
        double x,y,y1,output;
        ArrayList<String> data = new ArrayList<String>();

        //data.add("i, x, y, output");

        for(int i=0; i<howMany; i++)
        {
            x = Helper.generateRandomDouble(-1,1);
            y = Helper.generateRandomDouble(-1,1);
            y1= (-5*x-2)/-4;

            if(y<y1)output=1;
            else output=-1;
            data.add(String.valueOf(i)+","+
                     String.valueOf(x)+","+
                     String.valueOf(y)+","+
                     String.valueOf(output));
        }

        return data;
    }

    public ArrayList<String> readFileToMemory(String filepath)
    {
        BufferedReader br = null;
        String currentLine = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        try
        {
            br = new BufferedReader(new FileReader(filepath));
            while((currentLine = br.readLine()) != null)
            {
                //fileContents.add(br.readLine());
                fileContents.add(currentLine);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return fileContents;
    }

    public String turnListToString(ArrayList<String> listOfStrings)
    {
        String longString = "";

        for(int i =0; i < listOfStrings.size()-1; i++)
        {
            longString += listOfStrings.get(i);
        }
        return longString;
    }

    public ArrayList<Pattern<Double>> turnListToPattern(ArrayList<String> listOfStrings)
    {
        //I'm just going to assume that they are all integers for right now.
        StringTokenizer st;
        ArrayList<Pattern<Double>> patterns = new ArrayList<Pattern<Double>>();

        for(String s:listOfStrings)
        {
            st = new StringTokenizer(s,",");
            int numberOfTokens = st.countTokens();
            //create a new input pattern
            Pattern<Double> patternSet = new Pattern<Double>();

            for(int i = 0; i< numberOfTokens;i++)
            {
                //get the values for the input set
                if(i <= numberOfTokens-2)
                {
                    //set the input pattern
                    patternSet.getInputSet().add(Double.parseDouble(st.nextToken()));
                }

                if(i == numberOfTokens-1)
                {
                    patternSet.getOutputSet().add(Double.parseDouble(st.nextToken()));
                }
            }

            //add the pattern to the list
            patterns.add(patternSet);
        }

        return patterns;
    }

    public String[] splitString(String s)
    {
        return s.split("(?!^)");
    }

    public ArrayList<Pattern<Double>> partitionDataSet(Double percentToPartition, ArrayList<Pattern<Double>> dataSet)
    {
        ArrayList<Pattern<Double>> newList = new ArrayList<Pattern<Double>>();
        int lengthOfDataSet = dataSet.size();
        double partToPartition = lengthOfDataSet * percentToPartition;

        for(int i = 0; i<(int)partToPartition;i++)
        {
            newList.add(dataSet.get(i));
        }

        return newList;
    }

    public String captureTrainingData(AdalineNetwork aNetwork, Integer iterationThroughData)
    {
        String outputData = "";

        //for each inputnode in the network
        for(int i=0; i<aNetwork.getNodeList().size(); i++)
        {
            String nodeValue = String.valueOf(aNetwork.getNodeList().get(i).getValue(Constants.NODE_VALUE));
            String linkWeight = String.valueOf(aNetwork.getLinkList().get(i).getValue(Constants.WEIGHT));
            String iterationString = String.valueOf(iterationThroughData);
            String nodeNumber = String.valueOf(i);
            outputData = outputData + "Iteration: "+ iterationString;
            outputData = outputData + "Node " + nodeNumber + " Value : " + nodeValue;
            outputData = outputData + "Link " + nodeNumber + " Weight : " + linkWeight;
            outputData = outputData + "Adaline Node: " + aNetwork.getAdalineNode().getValue(Constants.NODE_VALUE);
        }

        return outputData;
    }
}
