package src.finalDSARevisionScaler.hashing;

import java.util.HashMap;

/**
 * Q5) You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * NOTE: if B > N, return an empty array.
 */
public class DistinctNumbersInWindows {
    public int[] dNums(int[] A, int B) {

        if(B > A.length){
            return new int[]{};
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans[] = new int[A.length-B+1];
        for(int i = 0 ; i < B;i++){
            if(hm.containsKey(A[i])){
                int val = hm.get(A[i]);
                hm.put(A[i],val + 1);
            }else{
                hm.put(A[i],1);
            }
        }
        ans[0] = hm.size();
        int j = 1;
        int e = B;

        while (e < A.length) {
            if (hm.containsKey(A[e])) {
                int val = hm.get(A[e]);
                hm.put(A[e], val + 1);
            } else {
                hm.put(A[e], 1);
            }
            //considering outgoing element
            int val = hm.get(A[j - 1]);
            if (val > 1) {
                hm.put(A[j - 1], val - 1);
            } else {
                hm.remove(A[j - 1]);
            }

            ans[j] = hm.size();
            j++;
            e++;
        }

        return ans;
    }

    public static void main(String[] args) {
        DistinctNumbersInWindows dm = new DistinctNumbersInWindows();
        int A[] = {1, 2, 1, 3, 4, 3};
        int B = 3;

        int ans[] = dm.dNums(A,B);

        for (int i : ans){
            System.out.println(i + " ");
        }

    }
}
