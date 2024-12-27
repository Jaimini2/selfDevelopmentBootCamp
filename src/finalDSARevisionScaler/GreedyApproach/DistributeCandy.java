package src.finalDSARevisionScaler.GreedyApproach;

import java.util.Arrays;

/**
 * Q60) Distribute Candy
 * N children are standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * <p>
 * What is the minimum number of candies you must give?
 */
public class DistributeCandy {

    public int candy(int[] A) {

        int c[] = new int[A.length];

        Arrays.fill(c, 0);

        int ans = A.length;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                c[i] = c[i - 1] + 1;
            }
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                if (c[i] <= c[i + 1]) {
                    c[i] = c[i + 1] + 1;
                }
            }
        }

                for (int i = 0; i < A.length; i++) {
                    if (c[i] >= 0) {
                        ans = ans + c[i];
                    }
                }

                return ans;
            }

            public static void main (String[]args){

                int A[] = {1, 5, 2, 1};

                DistributeCandy dc = new DistributeCandy();

                int ans = dc.candy(A);
                System.out.println(ans);
            }
}