package Scaler.SlidingWindow;

public class SubArayWithGivenSum {
    public static int solve(int[] A, int B, int C) {
        for(int  i =0, endIndex = B-1 ; i <=A.length-B;i++){
            int prefixSum =0;
            for(int j =i ; j <= endIndex;j++){
                prefixSum +=A[j];
            }
            if(prefixSum == C){
                return 1;
            }
            endIndex++;
        }
        return 0;

    }

    public static void main(String[] args) {
        int []A = { 6, 3, 3, 6, 7, 8, 7, 3, 7 };
        int B = 2;
        int C = 10;


        System.out.println(solve(A,B,C));
    }

}
