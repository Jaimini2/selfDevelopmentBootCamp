package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q77)Coin Sum infinite - Permutations
 * You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 * NOTE:
 * Coins in set A will be unique. Expected space complexity of this problem is O(B).
 * The answer can overflow. So, return the answer % (106 + 7).
 */
public class CoinSumInfinite {

    public int solve(int[]A,int B){

        int[]dp = new int[B+1];
        int n = B;

        Arrays.fill(dp,0);

        int ans = maxSum(A,dp,n);

        return ans;
    }

  /*  *
     * Memoization
     * @param A
     * @param dp
     * @param n
     * @return
     */
    private int maxSum(int[] A, int[] dp, int n) {

        if(n ==0){
            return 1;
        }

        int x = 0;
        //dp expression
        for (int i =0 ; i < A.length;i++){

            if(n-A[i] >= 0){

                x = x + maxSum(A,dp,n-A[i]);

            }
        }
        dp[n] = x;
        return dp[n];
    }


    /**
     * Tabulation
     * @param
     */
    public int maxSumTab(int[] A, int[] dp, int n){
        //base condition
        //here in this case we are considering 0 as also one way
        dp[0] = 1;
        for (int i = 1; i<= n;i++){
            for (int coin =0 ; coin < A.length;coin++){
                if(i >= A[coin]){
                    dp[i] = dp[i] + dp[i-A[coin]];

                }
            }
        }

        return dp[n];

    }
    public static void main(String[] args) {

        int A[] ={1, 2, 3};
        int B = 4;
        CoinSumInfinite cm = new CoinSumInfinite();
        int ans = cm.solve(A,B);
        System.out.println(ans);



    }
}
