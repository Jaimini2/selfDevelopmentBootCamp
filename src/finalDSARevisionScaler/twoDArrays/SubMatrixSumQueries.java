package src.finalDSARevisionScaler.twoDArrays;

/**
 * Q21). Sub-matrix Sum Queries
 * Given a matrix of integers A of size N x M and multiple queries Q,
 * for each query, find and return the submatrix sum.
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 */

/**
 * NOTE:*
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * The sum may be large, so return the answer mod 109 + 7.
 * Also, select the data type carefully, if you want to store the addition of some elements.
 * Indexing given in B, C, D, and E arrays is 1-based.
 * Top Left 0-based index = (B[i] - 1, C[i] - 1)
 * Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
 */
public class SubMatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int[] arrSum = new int[B.length];
        //Compute Prefixsum of A
        int[][] pA = computePrefixSum(A);
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < B.length; i++) {
            int x1 = B[i] - 1;
            int y1 = C[i] - 1;
            int x2 = D[i] - 1;
            int y2 = E[i] - 1;
            sum = pA[x2][y2];
            //Add the left top corner
            if (x1 > 0 && y1 > 0) {
                sum = (sum + pA[x1 - 1][y1 - 1]) % mod;
            }
            //Delete top
            if (x1 > 0) {
                sum = (sum - pA[x1 - 1][y2]) % mod;
            }
            //Delete left
            if (y1 > 0) {
                sum = (sum - pA[x2][y1 - 1]) % mod;
            }
            if (sum < 0) {
                sum += mod;
            }

          /*  if(x1 > 0 && y1 > 0){
                sum = sum + (A[x1-1][y1-1])%mod;
            }

            //delete the top
            if(x1 > 0){
                sum = sum - A[x1-1][y2] % mod;
            }

            //delete the left
            if(y1 > 0){
                sum = sum - A[x2][y1-1] % mod;
            }

            if (sum < 0){
                sum = sum % mod;
            }*/

            arrSum[i] = sum;
        }
        return arrSum;
    }

    private int[][] computePrefixSum(int[][] A) {
        //Using mod as sum might be greater than Integer.MAX value.
        int mod = 1000000007;
        //int[][] pA = new int[A.length][A[0].length];
        // build a prefix matrix so that we can calculate for multiple queries
        // first calcualte row wise sum
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j != 0) {
                    A[i][j] = (A[i][j] + A[i][j - 1]) % mod;
                }
            }
        }
        // col wise sum
        for (int j = 0; j < A[0].length; j++) {
            for (int i = 0; i < A.length; i++) {
                if (i != 0) {
                    A[i][j] = (A[i][j] + A[i - 1][j]) % mod;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int B[] = {1, 2};
        int C[] = {1, 2};
        int D[] = {2, 3};
        int E[] = {2, 3};

        SubMatrixSumQueries sm = new SubMatrixSumQueries();
     //   int ans[] = sm.solve(A,B,C,D,E);

     /*   for (int i : ans){
            System.out.println(i + " ");
        }*/

        int[][]pf = sm.computePrefixSum(A);

        for (int [] i : pf){
            System.out.print("[");
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println("]");
        }
    }
}
