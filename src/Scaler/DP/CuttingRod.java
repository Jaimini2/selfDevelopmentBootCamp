package Scaler.DP;

public class CuttingRod {
    public int solve(int[] A) {
        int n = A.length + 1;
        int dp[]= new  int[n];
        dp[0] = 0;
        for(int i = 1 ; i < n;i++){
            for(int j = 1; j <= i;j++){
                dp[i] = Math.max(dp[i],A[j-1] + dp[i - j]);
            }
        }
        return dp[A.length];
    }

    public static void main(String[] args) {
        CuttingRod cr = new CuttingRod();
        int A[] = {3, 4, 1, 6, 2};
        int ans = cr.solve(A);
        System.out.println(ans);
    }
}
