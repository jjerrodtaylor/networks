package edu.mason.insf.gc;

import edu.mason.insf.gc.utils.Constants;

public class Algorithm {

    /**
     * This function returns a string of random 1s and 0s of the desired length.
     * @param length
     * @return
     */
    String getRandomBits(int length)
    {
        String bits = "";

        for(int i=0; i<length; i++)
        {
            if(Constants.RANDOM_NUMBER > 0.5)
            {
                bits += "1";
            }
            else
            {
                bits += "0";
            }
        }

        return bits;
    }

    /**
     * This function converts a binary string into a decimal integer
     * @param bits
     * @return
     */
    int binToDec(String bits)
    {
        int val = 0;
        int value_to_add = 1;

        //you want to start from the end of the binary string
        for(int i = bits.length(); i > 0; i--)
        {
            //you're only adding value for positions that have a 1
            if(bits.indexOf(i-1) == 1)
            {
                val += value_to_add;
            }
            value_to_add *= 2;
        }

        return val;
    }

    /**
     * Given a chromosome this function will step through the genes one at a time and insert
     * the decimal values of each gene (which follow the operator -> number -> operator rule)
     * into a buffer. Returns the number of elements in the buffer.
     *
     * These are the original notes from the C++ source code. I have to look up what a buffer is.
     * I haven't had to use a pointer since junior year.
     * @param bits
     * @param buffer
     * @return
     */
    int parseBits(String bits, int buffer)
    {
        //counter for buffer position
        int cBuff = 0;

        /*
        * step through bits a gene at a time until end and store decimal values
        * of valid operators and numbers. Don't forget we are looking for operator -
        * number - operator - number and so on ... We ignore the unused genes 1111
        * and 1110
        *
        * I'm not sure where he got these genes from. I'll have to go back and reread his other notes.
        * */

        //flag to determine if we are looking for an operator or a number
        boolean bOperator = true;

        //storage for decimal value of currently tested gene
        int this_gene = 0;

        for(int i=0; i<Constants.CHROMO_LENGTH; i+= Constants.GENE_LENGTH)
        {
            //convert the current gene to decimal
            //I don't understand why he does this.
            this_gene = this.binToDec(bits.substring(i,(int)Constants.GENE_LENGTH));

            //find a gene which represents an operator
            if(bOperator)
            {
                //if( (this_gene < 10) || (this_gene > 13))
            }
        }

        return 1;
     }

}
