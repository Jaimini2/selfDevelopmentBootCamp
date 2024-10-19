package src.finalDSARevisionScaler.basics.slidingWindows;

import src.Scaler.HashMap.SubArrayWithGivenSum;

/**
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 */
public class SubArrayWithGivenSumAndLength {

    public int solve(int[] A, int B, int C) {
      /*  int window[] = new int[B];
        int ans = 0;
        for(int i =0 ; i < B;i++){
            if(ans < C) {
                ans = ans + A[i];
                window[i] = A[i];
            }
        }

       int startIndex =0;
        int endIndex = B;

        while (endIndex < A.length && ans != C){

            ans = ans - A[startIndex++];
            window[startIndex] = A[startIndex];
            ans = ans + A[endIndex++];
            window[endIndex] = A[endIndex];

        }

        return  ans == C ? 1 : 0;
    }*/

        int prefixSum =0;
        for(int  i =0,endIndex = B-1 ; i <= A.length-B;i++){
            prefixSum = prefixSum+A[i];
            if(i >=B){
                prefixSum = prefixSum - A[i-B];
                endIndex++;
            }

            if(i == endIndex && prefixSum == C){
                return 1;
            }


        }
        return 0;

    }

    public static void main(String[] args) {
        SubArrayWithGivenSumAndLength sb = new SubArrayWithGivenSumAndLength();

        int A [] = {6,3,3,6,7,8,7,3,7};
        int b = 2;
        int c = 10;

        System.out.println(sb.solve(A,b,c));
    }
}
