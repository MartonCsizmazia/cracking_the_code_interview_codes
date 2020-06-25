package com.codecool;

public class BigO {

    private int pairSumSequence(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i+1);
        }
        return sum;
    }

    private int pairSum(int a, int b) {
        return a+b;
    }
}
