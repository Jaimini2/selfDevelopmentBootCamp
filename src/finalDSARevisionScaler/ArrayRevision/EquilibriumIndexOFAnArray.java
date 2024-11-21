package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q15)Equilibrium Index of an Array
 * You are given an array A of integers of size N.
 * Your task is to find the equilibrium index of the given array
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 * Note:
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 */
public class EquilibriumIndexOFAnArray {

    public int solve(int[] A) {
        int[] pfArr = new int[A.length];
        int n = A.length;
        pfArr[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfArr[i] = pfArr[i - 1] + A[i];
        }

        for (int i = 0; i < pfArr.length; i++) {
            if (i == 0) {
                if (0 == pfArr[n - 1] - pfArr[1]) {
                    return i;
                }
            } else if (pfArr[i - 1] == pfArr[n - i] - pfArr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int solve2(int[] A) {
        int[] pfArr = new int[A.length];
        int n = A.length;

        int sum1 = 0; // sum of elements at lower indexes
        int sum2 = 0; // sum of elements at higher indexesq
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
           sum1 +=A[i];
        }

        for(int i =0 ; i < A.length;i++){
            sum1-=A[i];
            if(sum1 == sum2){
                ans  = i;
                break;
            }

            sum2+=A[i];
        }

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }


    public static void main(String[] args) {

        EquilibriumIndexOFAnArray mx = new EquilibriumIndexOFAnArray();

        int []A = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(mx.solve(A));

    }
}
