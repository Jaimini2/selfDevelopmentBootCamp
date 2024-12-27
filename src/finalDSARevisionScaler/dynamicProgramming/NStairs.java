package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q52)N stairs , dp - One Dimensional , both Iterative and Memoization approach
 */
public class NStairs {

    public int climbStairs(int A){
        int[] dp = new int[A+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i =2; i < dp.length;i++){
            //dp expression
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[A];
    }

    public int memoizedClimbStairs(int n){

        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

        int ans = climbingStairs(n,dp);

        return ans;


    }

    private int climbingStairs(int n, int[] dp) {
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

         dp[n] = climbingStairs(n-1,dp) + climbingStairs(n-2,dp);

        return dp[n];
    }

    public static void main(String[] args) {
        NStairs ns = new NStairs();
        int ans = ns.memoizedClimbStairs(5);
        System.out.println(ans);
    }
}
