package src.finalDSARevisionScaler.dynamicProgramming;

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

    /**
     * Iterative Approach ,also known as Bottom Up Approach
     * @param n
     * @return
     */
    public int iterativeFib(int n){

        int dp[] = new int[n+1];

        dp[0]=0;
        dp[1]=1;

        for (int i =2 ; i <=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        FibonacciSeries fb = new FibonacciSeries();
        int n = 8;


        System.out.println(fb.solve_fib(n));
    }
}
