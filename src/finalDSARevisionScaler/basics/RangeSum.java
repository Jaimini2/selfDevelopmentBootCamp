package src.finalDSARevisionScaler.basics;

public class RangeSum {

    public long[] rangeSum(int[] A, int[][] B) {
        int[] queries = new int[2];

        long sumArray[] = new long[B.length];
        long prefixSum[] = new long[A.length];
        for(int i =0; i < A.length;i++){
            if(i == 0){
                prefixSum[i] = A[i];
            }else{
                prefixSum[i] = prefixSum[i-1]+ A[i];
            }
        }

        for (int i = 0; i < B.length; i++) {
            int sum = 0;
            queries = B[i];
            int startIndex = queries[0];
            int endIndex = queries[1];
            sumArray[i] = prefixSum[endIndex] -prefixSum[startIndex] + A[startIndex];
        }
        return sumArray;
    }


    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        int[][]B = {{0, 3}, {1, 2}};

        RangeSum rs = new RangeSum();

        long[] ans = rs.rangeSum(A,B);

        for (long i : ans){
            System.out.print(i + " ");
        }

    }
}
