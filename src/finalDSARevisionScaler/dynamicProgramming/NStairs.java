package src.finalDSARevisionScaler.dynamicProgramming;

/**
 * Q52)N stairs , dp - One Dimensional
 */
public class NStairs {

    public int climbStairs(int A){
        int[] dp = new int[A+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i =2; i < dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[A];
    }

    public static void main(String[] args) {
        NStairs ns = new NStairs();
        int ans = ns.climbStairs(5);
        System.out.println(ans);
    }
}
