package src.finalDSARevisionScaler.basics.InterviewProblems;


/**
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
 * For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
 */
public class SumOfEvenIndices {
    public int[] solve(int[] A, int[][] B) {
        //create pf sum of even indices
        int pfArr[] = new int[A.length];
        int ans [] = new int[B.length];
        for(int i =0; i < A.length;i++){
            if(i == 0){
                pfArr[i] = A[i];
            }
            else if(i % 2 == 0){
                pfArr[i] = pfArr[i-1] + A[i];
            }
            else{
                pfArr[i] = pfArr[i-1];
            }
        }
        //find ans for the queries
        for(int i = 0; i < B.length;i++){
            int j = B[i][0];
            int k = B[i][1];
            if(j == 0){
                if(A.length == 1){
                    ans[i] = pfArr[j];
                }
                else {
                    ans[i] = pfArr[k];
                }
            }else{
                ans[i] = pfArr[k] - pfArr[j-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        SumOfEvenIndices sm = new SumOfEvenIndices();
        int A[] = {1, 2, 3, 4, 5};
        int[][] B = {{0, 2}, {1, 4}};

       int[] ans = sm.solve(A,B);

       for (int i : ans){
           System.out.print(i + " ,");
       }
    }
}
