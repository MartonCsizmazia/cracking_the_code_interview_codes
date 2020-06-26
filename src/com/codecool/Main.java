package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BigO bigO = new BigO();
        /*
        System.out.println(bigO.pairSumSequence(5));
        System.out.println(bigO.f(4));

        System.out.println(bigO.isPrime(31));

         */

        double[] list = new double []{0,0,1};


        System.out.println(Arrays.toString(bigO.tribonacci(list, 10)));
    }
}
