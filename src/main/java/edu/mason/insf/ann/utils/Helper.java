package edu.mason.insf.ann.utils;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/8/13
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Helper {

    public static double generateRandomDouble(int min, int max)
    {
        return min + (double)(Math.random() * ((max - min) + 1));
    }

}
