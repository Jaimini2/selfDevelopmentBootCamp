package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q78) Coin Sum Infinite -Combinations
 * You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 * NOTE:
 * Coins in set A will be unique. Expected space complexity of this problem is O(B).
 * The answer can overflow. So, return the answer % (106 + 7).
 */
public class CoinSumInfiniteII {


    public int solve(int[]A,int B){

       //solved using memoization
        int[][]memoDP = new int[A.length+1][B+1];
        // Initialize dp array with -1 to indicate uncomputed states
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(memoDP[i], -1);
        }
        int ans = 0;
         //ans = coinSum(A,memoDP,A.length,B);

         ans = coinSumTab(A,B);

        return ans;

    }

    /**
     * Using Tabulation
     * @param A
     * @param B
     * @return
     */
    private int coinSumTab(int[] A, int B) {
        int[] dp = new int[B + 1];

        // Initialize dp array: there's one way to make a sum of 0 (by using no coins)
        dp[0] = 1;
        //Iterate over the coins
        for (int coin : A) {
            for (int i = coin; i <= B; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[B];
    }

    private int coinSum(int[] A, int[][] dp, int n, int coinCap) {

        if(coinCap == 0){
            return 1;
        }

        //base case , if n ==0 or n < 0
        if(n ==0 || coinCap < 0){
            return 0;
        }
        //if already computed ,return the stored value
        if (dp[n][coinCap] != -1){
            return dp[n][coinCap];
        }

        int x = 0;
        //compute the number of ways to form the sum B using the available coins
        //option 1 : include the nth coin and reduce the sum
        int incl = coinSum(A,dp,n,coinCap- A[n-1]);

        //option 2 : exclue the nth coin and do not reduce the sum
        int excl = coinSum(A,dp,n-1,coinCap);

        dp[n][coinCap] = incl + excl;

        return dp[n][coinCap];
    }

    public static void main(String[] args) {

        int A[] ={3,1,4};
        int B = 5;
        CoinSumInfiniteII cm = new CoinSumInfiniteII();
        int ans = cm.solve(A,B);
        System.out.println(ans);

    }
}
