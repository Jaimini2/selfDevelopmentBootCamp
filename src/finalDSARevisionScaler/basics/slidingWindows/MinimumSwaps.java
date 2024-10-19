package src.finalDSARevisionScaler.basics.slidingWindows;

/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 */

public class MinimumSwaps {

    public int solve(int[] A, int B) {
        int size = 0;
        for(int i =0;i < A.length;i++){
            if(A[i] <= B){
                size++;
            }
        }
        int cnt = 0;
        for(int i =0 ; i < size;i++){
            if(A[i]>B){
                cnt++;
            }
        }



        int startIndex = 1;
        int endIndex = cnt-1;
        int ans = A.length;
        while(endIndex < A.length){
            if(A[startIndex-1] > B){
                cnt--;
            }
            if(A[endIndex] > B){
                cnt++;
            }
            startIndex++;
            endIndex++;
            ans = Math.min(cnt,ans);
        }


        return ans;
    }

    public static void main(String[] args) {

        int A[] = {1, 12, 10, 3, 14, 10, 5};
        int b = 8;

        MinimumSwaps ms = new MinimumSwaps();

        System.out.println(ms.solve(A,b));

    }
}
