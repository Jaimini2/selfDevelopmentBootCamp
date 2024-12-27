package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q75)UnboundedKnapsack Problem
 * Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 */
public class UnboundedKnapsack {

    public int solve(int A, int[] B, int[] C) {

        int[] dp = new int[B.length + 1];
        int n = B.length;

        int[] dpTab = new int[A+1];
        Arrays.fill(dp, -1);

        Arrays.fill(dpTab,-1);

        int ans = maxProfit_tabulation(B, C, A, dpTab, n);

        return ans;

    }

    /**
     * solved using Memoization
     * @param val
     * @param wt
     * @param cap
     * @param dp
     * @param n
     * @return
     */
    private int maxProfit(int[] val, int[] wt, int cap, int[] dp, int n) {
        //handling base case
        if (n == 0 || cap <= 0) {
            return 0;
        }

        //making sure we are returning the value if it is calculated once
        if (dp[n] != -1) {
            return dp[n];
        }

        if (wt[n - 1] > cap) {
            dp[n] = maxProfit(val, wt, cap, dp, n - 1);
        } else {
            int incl = maxProfit(val, wt, cap - wt[n - 1], dp, n - 1) + val[n-1];
            int excl = maxProfit(val, wt, cap, dp, n - 1);
            dp[n] = Math.max(incl, excl);
        }
        return dp[n];
    }

    private int maxProfit_tabulation(int[] val, int[] wt, int cap, int[] dp, int n){
        int max = 0;
        for (int i =1 ; i <= cap;i++){
            for (int j = 0; j < n;j++){
                if(i - wt[j] >= 0){
                    max  = Math.max(max,val[j] + dp[i-wt[j]]);
                }
            }
            dp[i] = max;
        }
        return dp[cap];
    }

    public static void main(String[] args) {

        UnboundedKnapsack uk = new UnboundedKnapsack();
        int[] B = {6, 7};
        int[] C = {5, 5};
        int A = 10;
        int ans = uk.solve(A, B, C);
        System.out.println(ans);


    }
}
