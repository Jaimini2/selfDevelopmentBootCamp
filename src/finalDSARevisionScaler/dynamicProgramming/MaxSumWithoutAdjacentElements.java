package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q70)Max sum without Adjacent Elements
 */
public class MaxSumWithoutAdjacentElements {

    public int solve(int[][] arr){

        int A[] = new int[arr[0].length];

        for (int i = 0; i < A.length;i++){
            A[i] = Math.max(arr[0][i],arr[1][i]);
        }
        int n = A.length;
        int dp[] = new int[A.length+1];

        Arrays.fill(dp,-1);

        int ans = maxSumIter(dp,A,n);
        return ans;
    }

    /**
     * Top Down Approach , memoization
     * @param dp
     * @param A
     * @param n
     * @return
     */
    private int maxSumRecurr(int[] dp, int[] A,int n) {
       if(n == 1){
           dp[n] = A[0];
           return A[0];
       }

       if(n == 0){
           return 0;
       }

       if(dp[n] != -1){
           return dp[n];
       }

       //memoization DP expression
       dp[n] = Math.max(maxSumRecurr(dp,A,n-1),maxSumRecurr(dp,A,n-2)+ A[n-1]) ;

       return dp[n];
    }

    /**
     * Iterative Approach
     * @param dp
     * @param A
     * @param n
     * @return
     */
    public int maxSumIter(int[]dp,int[]A,int n){
        dp[0] = A[0];
        dp[1] = Math.max(A[0],A[1]);

        for (int i = 2; i < n;i++){
            dp[i] = Math.max(A[i]-1,A[i-2]+A[i]);
        }

        return dp[n-1];
    }


    public static void main(String[] args) {


        int A[][]= {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
        };

        MaxSumWithoutAdjacentElements mx = new MaxSumWithoutAdjacentElements();
        int ans = mx.solve(A);
        System.out.println(ans);




    }
}
