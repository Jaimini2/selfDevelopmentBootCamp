package src.finalDSARevisionScaler.hashing;

import src.Scaler.HashMap.SubArrayWithGivenSum;

import java.util.HashSet;

/**
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 */
public class SubArraySumWithZero {

    public int solve(int A[]){

        long pfSum = 0;
        if(A.length < 1){
            return 0;
        }

        HashSet<Long> hs = new HashSet<>();
        for(int i = 0; i < A.length;i++){
           pfSum = pfSum + A[i];
            if(pfSum == 0){
                return 1;
            }else if(hs.contains(pfSum)){
                return 1;
            }else {
                hs.add(pfSum);
            }

        }

        return 0;
    }

    public static void main(String[] args) {

        SubArraySumWithZero smz = new SubArraySumWithZero();

        int A[] = {4, -1, 1};

        System.out.println(smz.solve(A));

    }
}
