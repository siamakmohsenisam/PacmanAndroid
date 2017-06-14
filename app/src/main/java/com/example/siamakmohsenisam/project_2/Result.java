package com.example.siamakmohsenisam.project_2;

/**
 * Created by siamakmohsenisam on 2017-05-25.
 */

public class Result {

    public static double numCatch=0;
    public static double numNoCatch=0;

    public static double score(){
        if (numCatch+numNoCatch != 0)
        return  (numCatch*100)/(numCatch+numNoCatch);
        return 0;
    }
}
