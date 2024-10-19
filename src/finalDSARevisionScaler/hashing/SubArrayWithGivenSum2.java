package src.finalDSARevisionScaler.hashing;

import java.util.HashMap;

/**
 * Q2)Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *If the answer does not exist return an array with a single integer "-1".
 * First sub-array means the sub-array for which starting index is minimum.
 */
public class SubArrayWithGivenSum2 {

    public int[] solve(int[] A, int B) {
        int startIndex = 0;
        int []finalAns ;
        long sum = 0;
        HashMap <Integer,Integer>hm = new HashMap<Integer,Integer>();

        for(int i =0 ; i < A.length;i++){
            if(sum < B){
                hm.put(i,A[i]);
                sum = sum + A[i];
            }
            else if(sum > B){
                while(sum > B && i < A.length && !hm.isEmpty()){
                    if(hm.containsKey(startIndex)){
                        sum = sum -  hm.remove(startIndex);
                        startIndex++;
                    }
                }
                if(sum < B){
                    hm.put(i,A[i]);
                    sum = sum + A[i];
                }
            }else if(sum == B){
                break;
            }
        }

        if(sum > B){
            while (hm.size() > 0 && sum > B){
                if(hm.containsKey(startIndex)){
                    sum = sum - hm.remove(startIndex);
                }
                startIndex++;
            }
        }
        if(sum == B){
            finalAns = new int[hm.size()];
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                if (hm.containsKey(i)) {
                    finalAns[count] = hm.get(i);
                    count++;
                }
            }

            return finalAns;
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int  A[] = {1, 2, 3, 4, 5};
        int B = 5;

        SubArrayWithGivenSum2 sm = new SubArrayWithGivenSum2();

        int[] ans = sm.solve(A,B);

        for (int i : ans){
            System.out.print(i + " ");
        }
    }
}
