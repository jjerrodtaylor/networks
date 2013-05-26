package edu.mason.insf.gc.utils;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/25/13
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GCHelper {

    public static int generateRandomInteger(int min, int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
