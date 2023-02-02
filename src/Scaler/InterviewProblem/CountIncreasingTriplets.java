package Scaler.InterviewProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class CountIncreasingTriplets {

    //You are given an array A of N elements.
    // Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        for(int j =1 ; j < A.size()-1;j++){
            int smallElements = 0;
            int largeElements = 0;
            int i = j-1;
            while(i >=0){
                if(A.get(i) < A.get(j)){
                    smallElements++;
                }
                i--;
            }
            int k = j+1;
            while(k <A.size()){
                if(A.get(k) > A.get(j)){
                    largeElements++;
                }
                k++;
            }
            ans+=smallElements * largeElements;
        }

        return ans;
    }


    public static int solve2(int[] A) {
        int ans = 0;
        for(int j =1 ; j < A.length-1;j++){
            int smallElements = 0;
            int largeElements = 0;
            int i = j-1;
            while(i >=0){
                if(A[i] < A[j]){
                    smallElements++;
                }
                i--;
            }
            int k = j+1;
            while(k <A.length){
                if(A[k] > A[j]){
                    largeElements++;
                }
                k++;
            }
            ans+=smallElements * largeElements;
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
        int[] b= {1, 2, 4, 3};
       // System.out.println(solve(A));
        System.out.println("-------------------Solving by Array ----------------");

        System.out.println(solve2(b));
    }
}
