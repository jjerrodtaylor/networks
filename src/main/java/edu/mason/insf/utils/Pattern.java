package main.java.edu.mason.insf.utils;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/15/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pattern<T> {

    public int id;
    public int inputPatternSize;
    public int outputPatternSize;
    public LinkedList<T> inputSet;
    public LinkedList<T> outputSet;

    public Pattern()
    {
        super();
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getInputPatternSize() {
        return inputPatternSize;
    }

    /**
     *
     * @param inputPatternSize
     */
    public void setInputPatternSize(int inputPatternSize) {
        this.inputPatternSize = inputPatternSize;
    }

    /**
     *
     * @return
     */
    public int getOutputPatternSize() {
        return outputPatternSize;
    }

    /**
     *
     * @param outputPatternSize
     */
    public void setOutputPatternSize(int outputPatternSize) {
        this.outputPatternSize = outputPatternSize;
    }

    /**
     *
     * @return
     */
    public LinkedList<T> getInputSet() {
        return inputSet;
    }

    /**
     *
     * @param inputSet
     */
    public void setInputSet(LinkedList inputSet) {
        this.inputSet = inputSet;
    }

    /**
     *
     * @return
     */
    public LinkedList<T> getOutputSet() {
        return outputSet;
    }

    /**
     *
     * @param outputSet
     */
    public void setOutputSet(LinkedList outputSet) {
        this.outputSet = outputSet;
    }

    /**
     *
     * @param index
     * @return
     */
    public T getInputPatternValue(int index)
    {
        return this.getInputSet().get(index);
    }

    /**
     *
     * @param value
     */
    public void setInputPatternValue(T value)
    {
        this.getInputSet().add(value);
    }

    /**
     * Adds a value to the end of the input pattern list.
     * @param index
     * @return
     */
    public T getOutputPatternValue(int index)
    {
        return this.getOutputSet().get(index);
    }

    /**
     * Adds a value to the end of the output pattern list
     * @param value
     */
    public void setOutputPatternValue(T value)
    {
        this.getOutputSet().add(value);
    }

}
