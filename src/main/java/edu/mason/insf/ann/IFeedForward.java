package edu.mason.insf.ann;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/6/13
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IFeedForward {

    public double transferFunction(double value);

    public void run();

}
