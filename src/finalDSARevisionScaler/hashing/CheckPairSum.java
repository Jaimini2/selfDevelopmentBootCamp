package src.finalDSARevisionScaler.hashing;

/**
 * Q1 ) Given an Array of integers B, and a target sum A.
 * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 */

import java.util.HashSet;

public class CheckPairSum {

    public int solve(int A, int[] B) {
        HashSet<Integer> hs = new HashSet<>();
        int target = 0;
        for(int i =0 ; i < B.length;i++){
            target = A - B[i];
            if(hs.contains(target)){
                return 1;
            }else{
                hs.add(B[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        CheckPairSum cp = new CheckPairSum();

        int A = 8;
        int B[] = {3, 5, 1, 2, 1, 2};

        System.out.println(cp.solve(A,B));

    }
}
