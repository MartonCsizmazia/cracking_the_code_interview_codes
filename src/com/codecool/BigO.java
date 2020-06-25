package com.codecool;

public class BigO{


    //COMPLEXITY: O(1)  -> only O(1)  exists any given time
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

    //RECURSIVE RUNTIME///////////////////
    //COMPLEXITY: O(n)   -> only (O)n exists any given time
    public int f(int n){
        if(n<=1){
            //System.out.println("return 1");
            return 1;
        }
        //System.out.println("return (n-1)*2");
        return f(n-1)+f(n-1);
    }



    //COMPLEXITY: O(n)    iterating trough twice doesnt matter
    public void foo(int[] array){
        int sum = 0;
        int product = 1;
        /*enchanced below
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
         */
        for (int value : array) {
            sum += value;
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }



    //COMPLEXITY: (O)n^2    n steps called n times
    public void printPairs(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }

    //COMPLEXITY: O(n^2)      long explanation in Book, page 46,47
    public void printUnorderedPairs(int[] array){
        for (int i = 0; i < array.length; i++) { // 4X
            for (int j = i+1; j < array.length; j++) { // 1: 2X, 2:3X, 3:4X, 4:5X
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }



    //O(ab)
    //COMPLEXITY: O(ab)    -> two different inputs
    // O(n^2) is a VERY COMMON MISTAKE here, the input matters very much
    //explanation on page 48
    public void printUnorderedPairs2(int[] arrayA, int[] arrayB){
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                System.out.println(arrayA[i] + "," + arrayB[j]);//O(1) work
            }
        }
    }

    //Example 5
    //COMPLEXITY: O(ab) nothing really changed from before
    public void printUnorderedPairs3(int[] arrayA, int[] arrayB){
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 100000; k++) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);//O(1) work
                }
            }
        }
    }

    //COMPLEXITY: O(n)  -> the time the algorithm runs, it doesnt matter if only half the lenght
    public void reverse (int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length -i -1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }









}
