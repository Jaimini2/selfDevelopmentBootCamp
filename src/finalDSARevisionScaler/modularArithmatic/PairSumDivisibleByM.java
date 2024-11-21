package src.finalDSARevisionScaler.modularArithmatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Q31)Pair Sum divisible by M
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 * Since the answer may be large, return the answer modulo (109 + 7).
 * Note: Ensure to handle integer overflow when performing the calculations.
 */
public class PairSumDivisibleByM {

    public int solve(int A[],int m){
        //int ans = 0;
        int [] freq = new int[m];

        for (int i =0 ; i < A.length;i++){
            freq[A[i]%m]++;
        }

        long ans  = freq[0] * (freq[0]-1)/2;
        long mod = (long)(1e9 + 7);

        for (int i =1 , j = m-1; i <= j;i++){
            if(i == j){
                ans = ans + freq[i] * (freq[i-1])/2 % mod;
            }else{
                ans = (ans + freq[i]* freq[j]) % mod;
            }
        }

        return (int)ans;
    }

    public int solve2(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long count = 0;
        for(int i=0;i<A.size();i++)
        {
            int rem = A.get(i) % B;
            if(rem ==0  && map.containsKey(0))
                count = (count + map.get(0))%1000000007;
            if(map.containsKey(B-rem))
                count = (count + map.get(B-rem))%1000000007;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return (int)count;
    }

    public static void main(String[] args) {

        PairSumDivisibleByM pm = new PairSumDivisibleByM();
        int A[] = {1, 2, 3, 4, 5};
        int m = 2;

     //   ArrayList a1 =(ArrayList) Arrays.asList(A);

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(3);a1.add(4);a1.add(5);

        //int ans = pm.solve(A,m);
       int ans =  pm.solve2(a1,m);
        System.out.println(ans);

    }
}
