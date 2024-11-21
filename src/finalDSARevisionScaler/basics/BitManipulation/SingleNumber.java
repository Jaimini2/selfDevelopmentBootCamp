package src.finalDSARevisionScaler.basics.BitManipulation;

/**
 * Q26)Given an array of integers A, every element appears twice except for one.
 * Find that integer that occurs once.
 * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public int solve(int[]A){
        int n = A.length;
        int ans = 0;
        for (int i =0 ; i < n;i++){
            ans = ans ^ A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
     SingleNumber sn = new SingleNumber();
        int[] A = {1, 2, 2, 3, 1};
     int ans =sn.solve(A);
        System.out.println(ans);

    }
}
