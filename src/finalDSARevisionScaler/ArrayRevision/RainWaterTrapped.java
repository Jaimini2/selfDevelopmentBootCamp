package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q25) Rain Water Trapped
 * Imagine a histogram where the bars' heights are given by the array A.
 * Each bar is of uniform width, which is 1 unit. When it rains,
 * water will accumulate in the valleys between the bars.
 * Your task is to calculate the total amount of water that can be trapped in these valleys.
 */
public class RainWaterTrapped {

    public int trap(final int[] A){
        int[] leftmax = new int[A.length];
        int[] rightmax = new int[A.length];

        leftmax[0] = A[0];
        rightmax[A.length-1] = A[A.length-1];

        for (int i =1 ; i < A.length;i++){
            leftmax[i] = Math.max(A[i],leftmax[i-1]);
        }

        for (int i = A.length-2;i >=0;i--){
            rightmax[i] = Math.max(rightmax[i+1],A[i]);
        }

        long totalWater =0;

        for (int i =0; i < A.length;i++){
            totalWater += Math.min(leftmax[i],rightmax[i]) - A[i];
        }

        return (int)totalWater;
    }

    public int trapped(final int[] A) {
        int []leftMax = new int[A.length];
        int []rightMax = new int[A.length];

        leftMax[0] = A[0];
        rightMax[A.length-1] = A[A.length-1];

        for(int i = 1; i < A.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],A[i]);
        }

        for(int i = A.length-2; i >=0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1],A[i]);
        }

        long totalWater = 0;
        for(int i = 0; i < A.length;i++){
            totalWater+= Math.min(leftMax[i],rightMax[i]) - A[i];
        }

        return (int)totalWater;
    }

    public static void main(String[] args) {

        RainWaterTrapped rw = new RainWaterTrapped();
        int[] A = {0, 1, 0, 2};
       int ans =  rw.trap(A);
        System.out.println(ans);


    }
}
