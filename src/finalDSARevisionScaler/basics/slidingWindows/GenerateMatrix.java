package src.finalDSARevisionScaler.basics.slidingWindows;

/**
 * Spiral Order Matrix II
 *
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int A) {
        int num = 1;
        int topRow = 0;
        int rightCol = A-1;
        int bottomRow = A-1;
        int leftCol = 0;
        int[][]ans = new int[A][A];

        while(num <= A*A){
            for(int i =topRow; i <= rightCol;i++){
                ans[topRow][i] = num++;
            }
            topRow++;

            for(int i = topRow; i<= bottomRow;i++){
                ans[i][rightCol] = num++;
            }
            rightCol--;

            for(int i = rightCol;i >= leftCol;i--){
                ans[bottomRow][i] = num++;
            }
            bottomRow--;
            for(int i = bottomRow; i>= topRow;i--){
                ans[i][leftCol] = num++;
            }
            leftCol++;
        }
        return ans;


    }
    public static void main(String[] args) {
        GenerateMatrix a = new GenerateMatrix();
        int b = 5;

       int[][] ans =  a.generateMatrix(b);

       for (int[] d : ans){
           for(int c : d){
               System.out.print( c + " ");
           }
           System.out.println();
       }




    }
}
