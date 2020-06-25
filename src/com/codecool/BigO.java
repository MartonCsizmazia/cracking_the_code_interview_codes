package com.codecool;

public class BigO{


    //COMPLEXITY: (O)1  -> only (O)1  exists any given time
                           //calls are not called simultaneusly, only 1 at the time
    public int pairSumSequence(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i+1);
        }
        return sum;
    }

    public int pairSum(int a, int b) {
        return a+b;
    }



    //COMPLEXITY: (O)n  -> only (O)n exists any given time
    public int f(int n){
        if(n<=1){
            //System.out.println("return 1");
            return 1;
        }
        //System.out.println("return (n-1)*2");
        return f(n-1)+f(n-1);
    }

}
