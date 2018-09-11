package uk.co.rkg.staircase;

public class Stairs {

    // A simple recursive program number
    static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) {
        return fib(s + 1);
    }

    /* Driver program to test above function */
    public static void main (String args[])
    {
        System.out.println("Number of ways = "+ countWays(4));
    }

}
