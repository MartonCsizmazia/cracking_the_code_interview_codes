package com.codecool;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;

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



    // Example 11
    // COMPLEXITY:O(n)
    public int factorial(int n){
        if(n<0){
            return -1;
        } else if (n==0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }




    //Example 12
    // COMPLEXITY:O(n!)
    public void permutation(String str){
        permutation(str, "");
    }

    public void permutation(String str, String prefix){
        if(str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0,i) + str.substring(i+1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }


    //Example 13
    // COMPLEXITY:O(n!)
    public int fib(int n) {
        if(n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    //Example 14
    // COMPLEXITY:O(2^n)
    public void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib2(i));
        }
    }

    public int fib2(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib2(n - 1) + fib2(n - 2);
    }

    //Example 15
    // COMPLEXITY:O(n)
    void allFib2(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib3(i, memo));
        }
    }

    public int fib3(int n, int[] memo) {
        if (n <= 0)return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];
        memo[n] = fib3(n - 1, memo) + fib3(n - 2, memo);
        return memo[n];
    }

    //Example 16
    // COMPLEXITY:O(log n)
    public int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powers0f2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    ////ADDITIONAL PROBLEMS////////////////////////////////////////////////////
    //1.
    // COMPLEXITY: O(b)
    int product(int a, int b) {
        int sum = 0;
        for (int i= 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }


    //2.
    // COMPLEXITY: O(b)
    int power(int a, int b) {
        if (b < 0) {
            return 0; // error
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

    //3.
    // COMPLEXITY: O(1)
    int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    //4.
    // COMPLEXITY: O(a/b)
    int div2(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }
    //5.
    // COMPLEXITY: O(log n)
    int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }
    int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root
        int guess = (min + max) / 2;
        if (guess *guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    //6.
    // COMPLEXITY: O(suare root n)
    int sqrt2(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }


    //9.
    // COMPLEXITY: O(suare root n)

    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }

        return copy;
    }
    int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }

        // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
    }


    //10.
    // COMPLEXITY: O(suare root n)

    int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    //11
    // COMPLEXITY: O(k*c^k)
    // EXPLANATION :
    /*
        0( kc^k ), where k is the length of the string and c is the number of characters in the alphabet. It takes
        0( ck ) time to generate each string. Then, we need to check that each of these is sorted, which takes
        O( k  ) time.
     */
    int numChars = 26;
    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isinOrder(prefix)) {
                System.out.println(prefix);
            } else {
                for (int i = 0; i < numChars; i++) {
                    char c = ithLetter(i);
                    printSortedStrings(remaining - 1, prefix + c);
                }
            }
        }
    }

    private char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }

    boolean isinOrder (String s){
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }


    //12
    // COMPLEXITY: O(b log b + a log b)
    //explanation:
    /*
    First,we have to sort array b,which takesO(b log b) time.Then,for each
    element in a, we do binary search in 0( log b) time. The second part takes O(a log b) time.
     */
    int intersection(int[] a, int[] b) {
        //mergesort(b);
        int intersect = 0;
        for (int x : a) {
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }
        return intersect;
    }


    public double[] tribonacci(double[] s, int n) {
        double[] p = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            System.out.println("iter");
            p[i] = p[i-1]+p[i-2]+p[i-3];
        }
        return p;
    }


    List <String> merge(String[] words, String[] more) {
        List<String> sentence = new ArrayList<String>();
        sentence.addAll(Arrays.asList(words));
        sentence.addAll(Arrays.asList(more));
        return sentence;


    }


}
