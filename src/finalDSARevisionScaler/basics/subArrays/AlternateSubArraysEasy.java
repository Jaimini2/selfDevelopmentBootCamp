package src.finalDSARevisionScaler.basics.subArrays;

import java.util.ArrayList;

/**
 * Subarray problem (ALternating subarray problem)
 *
 * You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
 * You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
 * A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
 */
public class AlternateSubArraysEasy {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int len = 2 * B + 1;
        int[] ans = new int[A.length];

        int counter = 0;
        for(int i =0 ; i <= n-len;i++){
            int start = i;
            int end = len + i;
            boolean isAlternate = true;
            for(int j = start+1; j < end;j++){
                if(A[j] == A[j-1]){
                    isAlternate = false;
                    break;
                }

            }

            if(isAlternate){
                ans[counter++] = start+B;

            }
        }
        return ans;
    }

     /*   int N = A.length;
        int len = 2 * B + 1;
        ArrayList<Integer> ans = new ArrayList<>();*/


        //edge case
      /*  if(B == 0){
            for (int i=0;i<N; i++) {
                ans.add(i);
            }

            int[] ansArr = new int[ans.size()];
            for(int i =0 ; i < ans.size();i++){
                ansArr[i] = ans.get(i);
            }

            return ansArr;

        }*/

/*        for(int i =0 ; i <= N-len;i++){
            int start = i;
            int end = len + i;
            boolean isAlternate = true;
            for(int j = start+1; j <end;j++){
                if(A[j] == A[j-1]){
                    isAlternate = false;
                    break;
                }
            }
            if(isAlternate){
                ans.add(start+B);
            }
        }

        int[] ansArr = new int[ans.size()];

        for(int i =0 ; i < ans.size();i++){
            ansArr[i] = ans.get(i);
        }

        return ansArr;
    }*/
    public static void main(String[] args) {
        AlternateSubArraysEasy as = new AlternateSubArraysEasy();
        int a[] = {1,0,1,0,0,0,0,1,1,1,0,1,0,1};

        int b = 3;

        int ans [] = as.solve(a,b);

        for(int i : ans){
            System.out.print(i + " ");
        }

    }
}
