package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q74) 0-1 Knapsack Problem
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 * Also given an integer C which represents knapsack capacity.
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * NOTE:
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class BoundedKnapsack {

    public int solve(int[] A, int[] B, int C) {
        int n =B.length;
        int[][]dp = new int[n+1][C+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

       /* for (int i = 1;i <= B.length;i++){
            for (int j = 1; j <= c;j++){
                if()
            }
        }*/

        int ans = maxValue(A,B,dp,n,C);

        return ans;

    }

    private int maxValue(int[] A, int[] B, int[][] dp, int n, int cap) {

        if(n <= 0 || cap == 0){
            return 0;
        }

        if (dp[n][cap] != -1) { return dp[n][cap]; }

        if(B[n-1] > cap){
            dp[n][cap] = maxValue(A,B,dp,n-1,cap);
        }else{
            int included = maxValue(A,B, dp,n-1,cap - B[n-1]) + A[n-1];
            int excluded = maxValue(A,B,dp,n-1,cap);
            dp[n][n] = Math.max(included,excluded);

        }
        return dp[n][n];
    }

    public static void main(String[] args) {

        BoundedKnapsack bk = new BoundedKnapsack();

        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int  C = 50;

        int ans = bk.solve(A,B,C);
        System.out.println(ans);


    }

}
