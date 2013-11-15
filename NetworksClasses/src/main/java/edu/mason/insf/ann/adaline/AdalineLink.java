package edu.mason.insf.ann.adaline;

import edu.mason.insf.ann.BaseLink;
import edu.mason.insf.ann.utils.Helper;
import edu.mason.insf.ann.utils.Constants;

/**
 *
 */
public class AdalineLink extends BaseLink {

    /**
     *
     */
    public AdalineLink()
    {
        super();
        Double value = Helper.generateRandomDouble(-1,1);
        this.value.put(Constants.WEIGHT,value);
    }
}
