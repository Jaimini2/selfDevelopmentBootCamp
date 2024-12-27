package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q79)Longest Common Subsequence
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 * You need to return the length of such longest common subsequence.
 */
public class LongestCommonSubSequence {

    public int solve(String A,String B){

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];

       for (int[] a : dp){
           Arrays.fill(a,-1);
       }

        int ans = lcs(A,B,n,m,dp);

        return ans;

    }

    /**
     * Using memoization
     * @param s1
     * @param s2
     * @param n
     * @param m
     * @param dp
     * @return
     */

    private int lcs(String s1, String s2, int n, int m, int[][] dp) {

        if(n == 0 || m == 0){
            return 0;
        }

        if (dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            dp[n][m] = 1 + lcs(s1,s2,n-1,m-1,dp);
        }else{
            int ans = Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1,s2,n,m-1,dp));
            dp[n][m] = ans;
        }

        return dp[n][m];

    }

    /**
     * Using tabulation
     * Bottom Up Approach
     * @param A
     * @param B
     * @return
     */
    public int lcs_tab(String A,String B){

        int n = A.length();
        int m = B.length();
        int[][]dp = new int[n+1][m+1];


        /*for (int[] a : dp){
            Arrays.fill(a,0);
        }*/

        for (int i =0 ; i <= A.length();i++){
            for (int j =0 ; j <= m;j++){
                if(A.charAt(i) == A.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        LongestCommonSubSequence lcs = new LongestCommonSubSequence();

       String A = "abbcdgf";
       String B = "bbadcgf";
            int ans = lcs.solve(A,B);
        System.out.println(ans);

    }
}
