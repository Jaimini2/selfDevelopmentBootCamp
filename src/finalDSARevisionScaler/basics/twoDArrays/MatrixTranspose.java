package src.finalDSARevisionScaler.basics.twoDArrays;

/**
 * Matrix Transpose
 */
public class MatrixTranspose {

    public int[][] solve(int[][] A) {

        int [][]ans = new int[A.length][A.length];

        for(int i =0;i< A.length;i++){
            for(int j = 0;j<A.length;j++){
                ans[i][j] = A[j][i];
            }
        }

      /*  int [][]ans = new int[A[0].length][A.length];
        int rowsToPrint = A[0].length;
        int colsToPrint = A.length;
        for(int i =0 ; i < rowsToPrint;i++){
            for(int j =0 ; j < colsToPrint;j++){
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }*/


        return ans;
    }

    public static void main(String[] args) {

        int[][] A = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        MatrixTranspose t2 = new MatrixTranspose();

        int [][] ans = t2.solve(A);

        for(int i[] : ans){
            for(int  j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
