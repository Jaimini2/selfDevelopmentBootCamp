package src.finalDSARevisionScaler.basics.subArrays;

/**
 * Contribution Technique
 * <p>
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 */
public class MaximumSubArrayEasy {
    public int maxSubarray(int A, int B, int[] C) {

        int result = 0;

        for (int i = 0; i < A; i++) {
            int sum = 0;
          for(int j = i ; j < A;j++){
              sum = sum + C[j];
              if(sum <= B){
                  result = Math.max(sum,result);
              }
          }
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 12;
        int C[] = {2, 1, 3, 4, 5};

        MaximumSubArrayEasy mx = new MaximumSubArrayEasy();

        System.out.println(mx.maxSubarray(A,B,C));


    }
}
