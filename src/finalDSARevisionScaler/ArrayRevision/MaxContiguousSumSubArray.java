package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q14)Kadane's Algorithm
 * Max Sum Contiguous Subarray
 */
public class MaxContiguousSumSubArray {

    public int maxSubArray(int[] A) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i =0 ; i < A.length;i++){
            sum = sum + A[i];
            ans = Math.max(sum,ans);
            if(sum < 0){
                sum = 0;
            }



        }

        return ans;
    }
    public static void main(String[] args) {

        MaxContiguousSumSubArray mx = new MaxContiguousSumSubArray();

        System.out.println(mx.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }
}
