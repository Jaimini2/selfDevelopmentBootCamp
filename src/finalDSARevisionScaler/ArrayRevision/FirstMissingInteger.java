package src.finalDSARevisionScaler.ArrayRevision;

import java.util.Arrays;
import java.util.Collections;

/**
 * Q19) Given an unsorted integer array, A of size N. Find the first missing positive integer.
 * Note: Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {

    public int firstMissingPositive(int[] A) {
        for (int i =0 ; i < A.length;i++){
            if(A[i] > 0 && A[i] <= A.length){
                int j = A[i]-1;
                if(A[i] != A[j]){
                    swap(A,i,j);
                    i--;
                }

            }
        }

        for(int i =0 ; i < A.length;i++){
            if(i+1 != A[i]){
                return i+1;
            }
        }
        return A.length+1;
    }

    public void swap(int[] A, int b, int c) {
        int temp = A[b];
        A[b] = A[c];
        A[c] = temp;
    }

    public static void main(String[] args) {
        FirstMissingInteger fm = new FirstMissingInteger();

        int A[] = {3, 4, -1, 1};
        System.out.println(fm.firstMissingPositive(A));
    }
}
