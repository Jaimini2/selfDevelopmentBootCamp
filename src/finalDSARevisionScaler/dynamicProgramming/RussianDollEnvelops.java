package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q81) RussianDollEnvelope
 * Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * Find the maximum number of envelopes you can put one inside other.
 */
public class RussianDollEnvelops {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // Sort the envelopes by height and then by width in descending order
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                    // Sort by width in descending order
                } else {
                    return a[0] - b[0];
                    // Sort by height in ascending order
                }
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        RussianDollEnvelops rd = new RussianDollEnvelops();

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int ans = rd.maxEnvelopes(envelopes);
        System.out.println("Maximum number of envelopes you can put one inside another: " + ans);

    }
    }
