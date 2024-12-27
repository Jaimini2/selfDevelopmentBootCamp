package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q80)Regular Expression Match
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatch {

    public int solve(String A,String B)
    {

        int n = A.length();
        int m = B.length();
        int[][]dp = new int[n+1][m+1];
        for (int[] a : dp){
            Arrays.fill(a,-1);
        }




        int ans = isMatch(A,B,n,m,dp) ? 1 : 0;

        return ans;
    }

    private boolean isMatch(String a, String b, int n, int m, int[][] dp) {

        //handling base conditions
        if(n ==0 && m ==0){
            return true;
        }else if(m == 0){
            return false;
        }
        else if(n == 0){
            for (int i =0;i < m;i++){
                if(b.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if (dp[n][m] != -1){
            return dp[n][m] == 1;
        }

        if(a.charAt(n-1) == b.charAt(m-1) || b.charAt(m-1) == '?'){
            dp[n][m] = isMatch(a,b,n-1,m-1,dp) ? 1 : 0;
           //return isMatch(a,b,n-1,m-1,dp);
           return dp[n][m] == 1;
        }else if(b.charAt(m-1) == '*'){
            dp[n][m] = isMatch(a,b,n,m-1,dp) || isMatch(a,b,n-1,m,dp) ? 1 : 0;
            return dp[n][m] == 1;
        }else{
            return dp[n][m] == 1;
        }
    }

    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        // Initialize dp array
        boolean[][] dp = new boolean[n + 1][m + 1];
        // Base case: empty pattern matches empty string
        dp[0][0] = true;
        // Fill the first row (pattern matches empty string)
        for (int j = 1; j <= m; j++) {
            if (B.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (B.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (B.charAt(j - 1) == '?' || A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    public static void main(String[] args) {

        String A = "abbcdgf";
        String B = "a*?cdf";

        RegularExpressionMatch rgm = new RegularExpressionMatch();
        int ans =  rgm.isMatch(A,B);
        System.out.println(ans);


    }
}
