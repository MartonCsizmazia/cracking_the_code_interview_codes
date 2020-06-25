package com.codecool;

import org.w3c.dom.Node;

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

    //Example 6
    //COMPLEXITY: O(n)  -> the time the algorithm runs, it doesnt matter if only half the lenght
    public void reverse (int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length -i -1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }


    //Example 7
    /*
    What is equivalent to O(n)?
    good answers:

    -O(N+P)  P < N/2
    -O(2N)
    -O(N +logN)

    n dominates in all the above
     */



    // Example 8
    /*
    array of string, sorted each string then sort the full array
    what is the runtime?

    s= longest string
    a= lenght of array

    sorting each string = O(s*log s)
    there are "a" string = a*s*log s

    sort all the strings = a* log a  number of comparison
    each string comparison takes = s    times

    string comparison all = a * s log a

    adding up = O(a*s(log a + log s))

     */


    // Example 9
    //COMPLEXITY: O(n)  the code touches each node in the tree once, therefore O(n)
    public int sum(Node node){
        if(node == null){
            return 0;
        }
        //return sum(node.left) + node.value + sum(node.right);
        return 0;
    }




    // Example 10
    //COMPLEXITY: O(square root of N)

    //EXPLANATION: loop stars at 2, ends when i*i = n
    //in other words, it stops when i = squareRoot(n), and thats the iteration number

    public boolean isPrime(int n){
        for (int i = 2; i*i <= n ; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    //Example 11
    public int factorial(int n){
        if(n<0){
            return -1;
        } else if (n==0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }












}
