package src.finalDSARevisionScaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Q71)Unique Paths in a Grid
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 * Now consider if some obstacles are added to the grids.
 * Return the total number unique paths from (1, 1) to (n, m).
 *
 * Note:
 * 1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
 * 2. Given Source Point and Destination points are 1-based index.
 */
public class UniquePathsInaGrid {

    public int solve(int[][] A){

        int[][] dp = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int n = A.length;
        int m = A[0].length;
        int ans = uniqueWaysRecurr(A,dp,n-1,m-1);
        return ans;
    }

    private int uniqueWays(int[][] A, int[][] dp) {
        int  n= A.length;
        int m = A[0].length;

        /**
         * my approach
         */
       /* dp[0][0] = A[0][0] == 1 ? 0 : 1;
        for (int i =0 ; i < n;i++){
            for (int j =0 ; j < m;j++){
                if(i ==0 && j == 0 ){
                    if(A[i][j] != 1 || A[i][j] !=0 ){
                        dp[i][j] = 1;
                    }
                }
                else if(i == 0){
                    if(A[i][j] != 1 || A[i][j] !=0 ){
                        dp[i][j] = dp[i][j-1];
                    }
                }else if(j == 0){
                    if(A[i][j] != 1 || A[i][j] !=0 ){
                        dp[i][j] = dp[i-1][j];
                    }
                }else{
                    if (A[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[n-1][m-1];*/

          dp[0][0] = A[0][0] == 1 ? 0 : 1;
        // Fill the first row
        for (int i = 1; i < m; i++) {
            dp[0][i] = (A[0][i] == 1 || dp[0][i - 1] == 0) ? 0 : 1;
        } // Fill the first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = (A[i][0] == 1 || dp[i - 1][0] == 0) ? 0 : 1;
        }

        // Fill the rest of the grid
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];

    }

    /**
     * Solving by Memoization , Top Down Approach
     * @param A
     * @param dp
     * @param row
     * @param col
     * @return
     */
    public int uniqueWaysRecurr(int[][]A,int[][]dp,int row,int col){

        //handling base cases
        if(row < 0 || col < 0) {
            return 0;
        }
        if (A[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }

        // Check if the result is already computed
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] =  uniqueWaysRecurr(A,dp,row-1,col) + uniqueWaysRecurr(A,dp,row,col-1);

        return dp[row][col];
    }


    public static void main(String[] args) {

        int[][] A = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        UniquePathsInaGrid ug = new UniquePathsInaGrid();
        int ans = ug.solve(A);
        System.out.println(ans);

    }
}
