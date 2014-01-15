package edu.mason.insf.ann.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.AbstractQueue;
//import edu.mason.insf.ann.utils.Pattern;

import edu.mason.insf.ann.adaline.AdalineNetwork;

/**
 * A class containing helper functions for things that aren't directly related to neural networks
 **/
public class Helper {

    private BufferedWriter bw = null;
    private BufferedReader br = null;
    private LinkedList<String> tempList = null;
    private LinkedList<String> stringsToWrite = null;
    public FileOutputStream fOutStream = null;

    public Helper()
    {
        super();
    }

    public BufferedWriter getBufferedWritter(String nameOfFile)
    {
        if(bw == null)
        {
            try
            {
                bw = new BufferedWriter(new FileWriter(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return bw;
    }

    public BufferedWriter getBufferedWritter()
    {
        return bw;
    }

    public BufferedReader getBufferedReader(String nameOfFile)
    {
        if(br == null)
        {
            try
            {
                br = new BufferedReader(new FileReader(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return br;
    }

    public LinkedList<String> getTempList()
    {
        if(tempList == null)
        {
            tempList = new LinkedList<String>();
        }

        return tempList;
    }

    public LinkedList<String> getStringsToWrite()
    {
        if(stringsToWrite == null)
        {
            stringsToWrite = new LinkedList<String>();
        }

        return stringsToWrite;
    }

    /**
     * Generates a random double between the min and the max parameters
     * @param min
     * @param max
     * @return double
     */
    public static double generateRandomDouble(int min, int max)
    {
        return min + (double)(Math.random() * ((max - min) + 1));
    }

    /**
     * Function takes an Arraylist of Strings as well as the path for where the file should be written to.
     * @param linesToWrite
     * @param nameOfFile
     */
    public void writeFile(ArrayList<String> linesToWrite, String nameOfFile)
    {

        bw = this.getBufferedWritter(nameOfFile);

        for(String s: linesToWrite)
        {
            try
            {
                bw.write(s);
                bw.newLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param howMany
     * @return
     */
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

    public void writeStrings()
    {
        BufferedWriter bw = this.getBufferedWritter();
        LinkedList<String> stringsToWrite = this.getStringsToWrite();

        try
        {
            bw.write(stringsToWrite.pollFirst());
            bw.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void length1Rules(String[] splitString, String currentLine)
    {
        BufferedWriter bw = this.getBufferedWritter();
        LinkedList<String> tempList = this.getTempList();

        if(splitString[0].equalsIgnoreCase(""))
        {
            try
            {
            bw.write(currentLine);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            tempList.add(currentLine);
        }

    }

    public void length2Rules(String[] splitString, String currentLine)
    {
        BufferedWriter bw = this.getBufferedWritter();
        LinkedList<String> tempList = this.getTempList();
        LinkedList<String> stringsToWrite = this.getStringsToWrite();
        String finalString = null;

        if(tempList.size() >=2)
        {
            finalString = "";
            int size = tempList.size();
            for(int i = 0; i<size;i++)
            {
                finalString = finalString +" "+tempList.pollFirst();
            }

            finalString = finalString + " " + splitString[0];
            stringsToWrite.add(finalString);
            tempList.add(splitString[1]);

            this.writeStrings();
        }
        else
        {
            finalString = tempList.pollFirst()+" "+splitString[0];
            stringsToWrite.add(finalString);
            tempList.add(splitString[1]);
            this.writeStrings();
        }
    }

    public void length3Rules(String[] splitString, String currentLine)
    {
        LinkedList<String> stringsToWrite = this.getStringsToWrite();
        LinkedList<String> tempList = this.getTempList();
        BufferedWriter bw = this.getBufferedWritter();

        for(int i=0; i < splitString.length-1;i++)
        {
            stringsToWrite.add(splitString[i]);
            this.writeStrings();
        }

        tempList.add(splitString[splitString.length-1]);
    }

    public void bigTempRules()
    {
        LinkedList<String> tempList = this.getTempList();
        BufferedWriter bw = this.getBufferedWritter();

        String finalString = "";
        int length = tempList.size();
        for(int i=0; i<length;i++)
        {
            finalString = finalString+" "+tempList.pollFirst();
        }

        try
        {
            bw.write(finalString);
            bw.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void formatText(String fileToRead, String fileToWrite, String regex)
    {
        BufferedWriter bw = null;
        String currentLine = null;
        LinkedList<String> tempList = this.getTempList();
        String[] splitSting;
        String finalString = null;
        LinkedList<String> stringsToWrite = new LinkedList<String>();

        try
        {
            br = this.getBufferedReader(fileToRead);
            bw = this.getBufferedWritter(fileToWrite);

            while((currentLine = br.readLine()) != null)
            {
                splitSting = currentLine.split(regex);
                if(tempList.size() >= 3)
                {
                    this.bigTempRules();
                }
                if(splitSting.length == 1)
                {
                    this.length1Rules(splitSting,currentLine);
                }
                else if(splitSting.length ==2)
                {
                    this.length2Rules(splitSting,currentLine);
                }
                else
                {
                    this.length3Rules(splitSting,currentLine);
                }
            }

            bw.close();

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filepath
     * @return
     */
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

    /**
     *
     * @param listOfStrings
     * @return
     */
    public String turnListToString(ArrayList<String> listOfStrings)
    {
        String longString = "";

        for(int i =0; i < listOfStrings.size()-1; i++)
        {
            longString += listOfStrings.get(i);
        }
        return longString;
    }

    /**
     *
     * @param listOfStrings
     * @return
     */
    /*public ArrayList<Pattern<Double>> turnListToPattern(ArrayList<String> listOfStrings)
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
    } */

    /**
     *
     * @param s
     * @return
     */
    public String[] splitString(String s)
    {
        return s.split("(?!^)");
    }

    /**
     *
     * @param percentToPartition
     * @param dataSet
     * @return
     */
    /*public ArrayList<Pattern<Double>> partitionDataSet(Double percentToPartition, ArrayList<Pattern<Double>> dataSet)
    {
        ArrayList<Pattern<Double>> newList = new ArrayList<Pattern<Double>>();
        int lengthOfDataSet = dataSet.size();
        double partToPartition = lengthOfDataSet * percentToPartition;

        for(int i = 0; i<(int)partToPartition;i++)
        {
            newList.add(dataSet.get(i));
        }

        return newList;
    }*/

    /**
     *
     * @param aNetwork
     * @param iterationThroughData
     * @return
     */
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
            outputData = outputData + "Iteration: "+ iterationString+",";
            outputData = outputData + "Node " + nodeNumber + " Value : " + nodeValue+",";
            outputData = outputData + "Link " + nodeNumber + " Weight : " + linkWeight+",";
            outputData = outputData + "Adaline Node: " + aNetwork.getAdalineNode().getValue(Constants.NODE_VALUE)+",";
        }

        return outputData;
    }
}
