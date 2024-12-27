package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q69)Minimum number of Squares
 */

public class MinimumNumberOfSquares {


    public int solve(int n){
        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

       int ans =  minSquares(n,dp);

       return ans;

    }

    /**
     *using Memoization
     * @param n
     * @param dp
     * @return
     */
    private int minSquares(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = n;
        for (int i = 1; i * i <= n; i++) {
            //dp expression
            int sq = i * i;
            min  = Math.min(min, minSquares(n-sq, dp) + 1);
        }
        dp[n] = min;
        return dp[n];

    }


    /**
     * solving using tabular form
     * @param n
     * @return
     */

    public int minSquares_tab(int n){
        int dp[] = new int[n+1];

        int ans = n;
        int min = n;



        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int  i = 1; i <= n;i++){
            for (int x = 1 ; x*x <= i;x++){
                //dp expresiion
                min = Math.min(dp[i],dp[i - x*x]+1);
                dp[i] = min;
            }
        }
        return dp[n];
        //return ans;
    }

    public static void main(String[] args) {

        int n = 6;
        MinimumNumberOfSquares mn = new MinimumNumberOfSquares();
       int ans = mn.minSquares_tab(n);
        System.out.println(ans);

    }
}
