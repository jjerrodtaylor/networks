package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/7/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdalineLink extends BaseLink {

    public AdalineLink()
    {
        super();
        Double value = Helper.generateRandomDouble(-1,1);
        this.value.put(Constants.WEIGHT,value);
    }
}
