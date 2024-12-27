package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q73)N Digit Numbers
 * Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
 * Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
 * Since the answer can be large, output answer modulo 1000000007
 */
public class NDigitNumbers {

    public int solve(int A, int n) {

        int dp[][] = new int[A+1][n + 1];
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for (int i =1; i < 10;i++){
            ans += countNumbers(A-1,n-i,dp);
            ans %= 1000000007;
        }
        return ans;
    }

    private int countNumbers(int idx, int n, int[][] dp) {

        if (n < 0) {
            return 0;
        }
        if (idx == 0 && n == 0) {
            return 1;
        }

        if (idx == 0) {
            return 0;
        }

        if (dp[idx][n] != -1) {
            return dp[idx][n];
        }

        int ans = 0;
        for (int i =0 ; i < 10;i++){
                ans = ans + countNumbers(idx - 1,n-i,dp);
                ans%=1000000007;
        }

         dp[idx][n] = ans;
        return dp[idx][n];
    }

    public int solveByIteration(int A, int B) {
        int MOD = 1000000007;
        int[][] dp = new int[A + 1][B + 1];
        // Base case: There is one way to make a sum of 0 with 0 digits.
        // dp[0][0] = 1;
        // Fill the DP table iteratively

        // Initialize the DP table
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], 0);
        }
        // Base case: There are no ways to have a sum if no digits are left except the sum 0. dp[0][0] = 1;
        for (int i = 1; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                    }
                }
            }
        }
        // Sum up all the ways to form a number of length A with sum n, starting from digit 1 to 9
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            if (B >= i) {
                ans = (ans + dp[A - 1][B - i]) % MOD;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        NDigitNumbers nd = new NDigitNumbers();

        int A = 2;
        int B = 4;

        int ans = nd.solve(A,B);
        System.out.println(ans);


    }
}
