package src.finalDSARevisionScaler.basics;

/**
 * Carry Forward technique
 *
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *
 * and at least one occurrence of the minimum value of the array.
 */
public class ClosestMinMax {

    public  int solve(int[] A) {

        int min = A[0];
        int max = A[0];
        int minIndex = -1;
        int maxIndex = -1;
        int shorttestLength = 1;


        for(int i =0; i < A.length; i++){
            min = Math.min(min,A[i]);
            max  = Math.max(max,A[i]);
        }

        for(int i = 0; i < A.length;i++){
            if(A[i] == min){
                if(maxIndex != -1){
                    shorttestLength = Math.min(shorttestLength,i - maxIndex + 1);
                }
                minIndex = i;
            }
             if(A[i] == max){
                maxIndex = i;
                if(minIndex != -1) {
                    shorttestLength = Math.min(shorttestLength, i - minIndex + 1);
                }
            }
        }

        return shorttestLength;
    }

    public static void main(String[] args) {
        ClosestMinMax cm = new ClosestMinMax();

        int A[] = {4,4,4,4,4};

        System.out.println(cm.solve(A));
    }

}
