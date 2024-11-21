package src.finalDSARevisionScaler.basics.BitManipulation;

/**
 * Q28) SUm of XOR of ALl Pairs
 */
public class SumOfXOROfAllPairs {

    public int solve(int[] A) {
        int n = A.length;

        long ans = 0;
        int mod = 100000007;

        for (int i = 0; i < 32; i++) {
            long x = 0;
            long y = 0;
            long pairs = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    x++;
                } else {
                    y++;
                }

                pairs = x * y;
                ans = ans + pairs * (1 << i);
                ans = ans % mod;
            }
        }
        return (int) ans % mod;
    }

    public static void main(String[] args) {

        SumOfXOROfAllPairs sm = new SumOfXOROfAllPairs();

        int[] A = {1, 2, 3};
        int ans = sm.solve(A);
        System.out.println(ans);
    }
}
