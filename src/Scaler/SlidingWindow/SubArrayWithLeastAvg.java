package Scaler.SlidingWindow;

public class SubArrayWithLeastAvg {
    public static int solve(int[] A, int B) {
        int endIndex = B-1;
        int startIndex = 0;
        int prefixSum = 0;
        float prefixAvg = 0;
        int indexWithLeastAvg = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = startIndex ; i <=endIndex;i++){
            prefixSum+=A[i];
        }
        while(endIndex <= A.length-1){
            if(endIndex >=B){
                prefixSum = prefixSum + A[endIndex] - A[startIndex - 1];
            }
           // prefixAvg = prefixSum /B;

            if(prefixSum < ans){
                ans =  prefixSum;
                indexWithLeastAvg = startIndex;
            }
            startIndex++;
            endIndex++;

        }

    return indexWithLeastAvg;
    }

    public static void main(String[] args) {
    int A[] = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
    int B = 9;

        System.out.println(solve(A,B));
    }
}
