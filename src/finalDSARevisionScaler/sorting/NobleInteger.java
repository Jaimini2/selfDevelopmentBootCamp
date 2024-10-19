package src.finalDSARevisionScaler.sorting;

import java.util.Arrays;

/**
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 *
 */
public class NobleInteger {

    public int solve(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;int ans = 0;
        if(arr[n-1] == 0){
            ans++;
           // return 1;
        }
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i] != arr[i+1]){
                count = i+1;
            }

            if(count == arr[i]){
                ans++;
             //   return 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        NobleInteger ni = new NobleInteger();
        int[] A = {1, 2, 3, 3};

        System.out.println(ni.solve(A));

    }
}
