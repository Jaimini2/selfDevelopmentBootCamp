package src.finalDSARevisionScaler.ArrayRevision.binarySearchRevision;

/**
 * Q34)  Painter's Partition Problem
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 * Return the ans % 10000003.
 */
public class PaintersPartitionProblem {

    public int paint(int A, int B, int[] C) {
        //first find the sum of all tasks to be done to consider the maximum time required for all the task if it is allocated to only 1 painter
        //second consider what is the max time required among all the tasks if as many workers are available
        //it will give us the range of the answer space in which the answer will lie

        int maxI= 0;
        int total_task = 0;
        long ans = 0;
        int mod = 10000003;
        for(int i = 0; i < C.length;i++){
            maxI = Math.max(maxI,C[i]);
            total_task += C[i];
        }

        while (maxI <= total_task){
            int mid = (total_task + maxI)/2;
            if(checkTask(C,mid,A)){
                ans = mid;
                total_task = mid - 1;

            }else{
                maxI = mid + 1;
            }
        }
        return (int) ((ans % mod * B % mod)%mod);
    }

    private boolean checkTask(int[] a, int mid, int b) {
        int cnt = 1;
        int total_work = 0;
        for (int i =0; i < a.length;i++){
            if(total_work + a[i] <= mid){
                total_work += a[i];
            }else {
                cnt++;
                total_work = a[i];
            }

            if(cnt > b)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {

        PaintersPartitionProblem pm = new PaintersPartitionProblem();
       int A = 10;
       int B = 1;
        int[] C = {1, 8, 11, 3};
       int ans =  pm.paint(A,B,C);
        System.out.println(ans);
    }
}
