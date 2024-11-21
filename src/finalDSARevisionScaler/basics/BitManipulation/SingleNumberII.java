package src.finalDSARevisionScaler.basics.BitManipulation;

/**
 * Q27)SingleNumber II
 * Given an array of integers, every element appears thrice except for one, which occurs once.
 * Find that element that does not appear thrice.
 * NOTE: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumberII {

    public int solve(int[] A){
        int ans = 0;

        for (int i =0 ; i < 32;i++){
            int count = 0;

            for (int j = 0; j < A.length;j++){
                if((A[j] & (1<<i)) != 0){
                    count++;
                }
            }
            if (count % 3 != 0){
                ans = ans + (1<<i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNumberII s2 = new SingleNumberII();
        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        int ans = s2.solve(A);
        System.out.println(ans);
    }
}
