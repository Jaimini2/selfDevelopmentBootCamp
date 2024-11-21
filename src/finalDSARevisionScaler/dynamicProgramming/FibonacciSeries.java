package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Q53) FibonacciSeries - dp- One Dimensional
 *
 *
 */
public class FibonacciSeries {

    public  int solve_fib(int n ){
        int[]    dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = fibonacci(n,dp);


        return ans;
    }

    private int fibonacci(int n,int[]dp) {

        if(n == 0 || n ==1){
            dp[n] = n;
            return n;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int a = fibonacci(n-1,dp);
        int b = fibonacci(n-2,dp);
        dp[n] = a + b;
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciSeries fb = new FibonacciSeries();
        int n = 6;

        System.out.println(fb.solve_fib(n));
    }
}
