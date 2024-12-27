package src.finalDSARevisionScaler.dynamicProgramming;

/**
 * Q72)Dungeon Princess
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.
 */
public class DungeonPrincess {


    public int solve(int[][]A){

        int[][]dp = new int[A.length][A[0].length];

        int ans = minHealthRequired(A,dp);


        return ans;
    }

    private int minHealthRequired(int[][] A, int[][] dp) {
        int n = A.length;
        int m = A[0].length;
        for (int i = n-1; i >=0;i--){
            for (int j = m-1; j>= 0; j--){
                if(i == n-1 && j == m-1){
                    dp[i][j] = 1 - A[i][j] > 0 ? (1-A[i][j]) : 1;
                }
                else if(i == n-1){
                    dp[i][j] = dp[i][j+1] - A[i][j] > 0 ? (dp[i][j+1] - A[i][j]) : 1;
                }
                else if(j == m-1){
                    dp[i][j] = dp[i+1][j] - A[i][j] > 0 ? (dp[i+1][j] - A[i][j]) : 1;
                }else{
                    int minHealth1 = dp[i+1][j] - A[i][j] > 0 ? (dp[i+1][j] - A[i][j]) : 1;
                    int minHealth2 = dp[i][j+1] - A[i][j] > 0 ? (dp[i][j+1] - A[i][j]) : 1;
                    dp[i][j] = Math.min(minHealth1,minHealth2);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
    DungeonPrincess dp = new DungeonPrincess();

        int[][] A = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };


       int ans =  dp.solve(A);
        System.out.println(ans);

    }
}
