package edu.mason.insf.ann.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import edu.mason.insf.ann.InputNode;
import edu.mason.insf.ann.utils.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/8/13
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Helper {

    public Helper()
    {
        super();
    }

    public static double generateRandomDouble(int min, int max)
    {
        return min + (double)(Math.random() * ((max - min) + 1));
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
}
