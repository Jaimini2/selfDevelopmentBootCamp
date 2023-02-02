package Scaler.Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ElementsRemoval {
        public static int solve(int[] A) {

            Comparator<Integer> ci = (a1, a2) ->{
              return a1 > a2 ? -1 : a1 < a2 ?1 : 0;
            };


            Arrays.sort(A);
            int minCost = 0;
//            for(int i = 0 ; i < A.length;i++){
//                minCost += (i + 1) * A[i];
//            }
            for(int i = A.length-1 ; i >= 0;i--){
                minCost += (A.length - i) * A[i];
            }

            return minCost;
        }

    public static void main(String[] args) {
            int A[] = { 10, 3, 7 };
        System.out.println(solve(A));
    }

}
