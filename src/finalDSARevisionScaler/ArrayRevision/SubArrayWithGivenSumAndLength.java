package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q17) Subarray with given sum and length
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 */
public class SubArrayWithGivenSumAndLength {

    public int solve(int[] A, int B, int C){
        int sum = 0;

        if(A.length < B){
            return 0;
        }
        for(int i =0 ; i < B;i++){
            sum+=A[i];
        }

        if(sum == C){
            return 1;
        }

        /**
         * here we have condition as  i<= A.length-1-B+1 because humko end ka element bhi lena h
         * so for e.g. : A.length = 8 , so A.length-1 = 7 , and B = 3
         * In this case if we look for the sliding window we should have the last 3 elements as 5,6,7
         * Now , 7-3 = 4 , No we need to start from 5 , so that is why we need to do +1
         *
          */

        for(int i = B; i <= A.length-1-B+1;i++){
            sum = sum -  A[i-B] + A[i];
            if(sum == C){
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int A[] = {4, 3, 2, 6, 1};
        int B = 3;
        int C = 11;
    }

}
