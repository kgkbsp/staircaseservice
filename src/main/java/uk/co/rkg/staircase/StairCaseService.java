package uk.co.rkg.staircase;

import org.springframework.stereotype.Component;

@Component
public class StairCaseService {

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
}
