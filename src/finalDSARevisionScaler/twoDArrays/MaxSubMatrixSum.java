package src.finalDSARevisionScaler.twoDArrays;

/**
 * Q22)Maximum Submatrix Sum
 * Given a row-wise and column-wise sorted matrix A of size N * M.
 * Return the maximum non-empty submatrix sum of this matrix.
 */
public class MaxSubMatrixSum {

    public long solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long sum = 0;
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                sum = sum + A[i][j];
            }
            max1 = Math.max(max1, sum);
        }

        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                sum = sum + A[i][j];
            }

            max2 = Math.max(max2, sum);
        }

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        MaxSubMatrixSum ms = new MaxSubMatrixSum();

        int[][] A = {{-5, -4, -3},
                     {-1, 2, 3},
                     {2, 2, 4}};
        long ans = ms.solve(A);
        System.out.println(ans);
    }
}
