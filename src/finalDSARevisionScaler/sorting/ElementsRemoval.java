package src.finalDSARevisionScaler.sorting;

import java.util.Arrays;

/**
 * Given an integer array A of size N. You can remove any element from the array in one operation.
 * The cost of this operation is the sum of all elements in the array present before this operation.
 *
 * Find the minimum cost to remove all elements from the array.
 */
public class ElementsRemoval {

    public int solve(int [] A){
        int totalMinCost = 0;

        Arrays.sort(A);
        int n = A.length;
        for(int i =0 ; i < A.length;i++){
            totalMinCost = totalMinCost + (A.length-i)*A[i];
        }


      /*  for(int i =n-1 ; i >= 0;i--){
            totalMinCost = totalMinCost + i+1* A[n-1-i];
        }*/
        return totalMinCost;
    }

    public static void main(String[] args) {
        int A[] = {2,1};

        ElementsRemoval rm = new ElementsRemoval();

        System.out.println(rm.solve(A));
    }

}
