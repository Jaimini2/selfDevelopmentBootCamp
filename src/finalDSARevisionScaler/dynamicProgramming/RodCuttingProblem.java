package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q76)Rod Cutting Problem
 * Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 * Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 */
public class RodCuttingProblem {

    public int solve(int[]A){
        int n = A.length;
        int dp[] = new int[n+1];

        Arrays.fill(dp,0);

        int ans = maxProfit_tab(A,dp,n);

        return ans;
    }

    /**
     * Solved using memoization
     * @param A
     * @param dp
     * @param n
     * @return
     */
    private int maxProfit(int[] A, int[] dp, int n) {

        if(n ==0){
            return 0;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int maxValue = 0;
        for (int i =1 ; i<= n;i++){
        maxValue = Math.max(maxValue,A[i-1] + maxProfit(A,dp,n-i));
        }
        dp[n] =maxValue;

        return dp[n];
    }

    /**
     * solved using tabulation
     * @param
     */

    public int maxProfit_tab(int[] A, int[] dp, int n){

        int ans = 0;
        for (int i = 1; i <= n;i++){
            for (int j =1 ; j <=i ;j++){

                //dp expression
                dp[i] = Math.max(dp[i] , A[j-1] + dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        RodCuttingProblem rcp = new RodCuttingProblem();

        int A[] = {3, 4, 1, 6, 2};
        int ans = rcp.solve(A);
        System.out.println(ans);

    }
}
