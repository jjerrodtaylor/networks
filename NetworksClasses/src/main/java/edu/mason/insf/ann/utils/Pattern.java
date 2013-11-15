package edu.mason.insf.ann.utils;

import java.util.LinkedList;

/**
 *
 * @param <T>
 */
public class Pattern<T extends Comparable<T>> {

    public int id;
    public LinkedList<T> inputSet;
    public LinkedList<T> outputSet;

    /**
     *
     */
    public Pattern()
    {
        super();
        inputSet = new LinkedList<T>();
        outputSet = new LinkedList<T>();
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
        return inputSet.size();
    }

    /**
     *
     * @return
     */
    public int getOutputPatternSize() {
        return outputSet.size();
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
    public void setInputSet(LinkedList<T> inputSet) {
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
    public void setOutputSet(LinkedList<T> outputSet) {
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
