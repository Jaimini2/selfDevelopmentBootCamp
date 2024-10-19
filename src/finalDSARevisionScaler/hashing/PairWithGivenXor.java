package src.finalDSARevisionScaler.hashing;

import src.Scaler.Generics.Pair;

import java.util.HashSet;

/**
 * Q3)Given an integer array A containing N distinct integers.
 * Find the number of unique pairs of integers in the array whose XOR is equal to B.
 * NOTE:
 * Pair (a, b) and (b, a) is considered to be the same and should be counted once.
 */
public class PairWithGivenXor {

    public int solve(int[] A, int B) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(A[0]);
        for(int i =1 ; i < A.length;i++){
            int xorD = A[i] ^ B;
            if(hs.contains(xorD)){
                count++;
            }
            hs.add(A[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        PairWithGivenXor px =  new PairWithGivenXor();


    }
}
