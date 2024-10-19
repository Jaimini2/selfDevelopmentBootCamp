package src.finalDSARevisionScaler.basics.subArrays;

/**
 * Two Dimensional Array
 *
 */
public class TwoDArray {

    public int[] solve(int[][] A) {
        int ans[] = new int[A[0].length];
        for(int i = 0; i < A[0].length;i++){
            int sum = 0;
            for(int j =0 ; j < A.length;j++){
                sum = sum + A[j][i];
            }
            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3,4},
                     {5,6,7,8},
                     {9,2,3,4}};

        TwoDArray t2 = new TwoDArray();

        int [] ans = t2.solve(A);

        for(int i : ans){
            System.out.print(i + " ,");
        }
    }
}
