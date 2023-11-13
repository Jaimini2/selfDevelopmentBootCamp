package Scaler.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class CountPairSum {

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> hm = new HashMap();

        int count = 0;
        int mod = 1000000000 + 7;
        for (int i = 0; i < A.length; i++) {
            int target = B - A[i];
            if (hm.containsKey(target)) {
                int val = hm.get(target);
                count = count + val;
                hm.put(A[i], hm.getOrDefault(i, 0) + 1);

            } else {
                hm.put(A[i], hm.getOrDefault(A[i],0) + 1);
            }
        }

        return count % mod;
    }

    public static void main(String[] args) {
        CountPairSum cpsm = new CountPairSum();

        int A[] = {1,1,16,16,7,7,16,4,19};
        int B = 5;
       int ans =  cpsm.solve(A,5);

        System.out.println(ans + " is the answer of Count Pair sum");
    }
}
