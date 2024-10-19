package src.finalDSARevisionScaler.hashing;

import java.util.HashMap;

public class LongestSubArraysumWithZero {
        public int solve(int[] A) {
            long prefixSum  = 0;
            long ans = 0;
            long mod = 1000000009;
            HashMap<Long,Integer> hm = new HashMap<>();
            for (int i =0; i < A.length;i++){
                prefixSum = prefixSum + A[i];

                if(prefixSum == 0){
                    ans = Math.max(ans, i+1);
                }
                else if(hm.containsKey(prefixSum)){
                    ans = Math.max(ans,i - hm.get(prefixSum));
                }else{
                    hm.put(prefixSum,i);
                }
            }


            return (int) ((int)ans%mod);
        }

    public static void main(String[] args) {
        LongestSubArraysumWithZero lsm = new LongestSubArraysumWithZero();

        int A[] = {1, -2, 1, 2};

        System.out.println(lsm.solve(A));
    }
}
