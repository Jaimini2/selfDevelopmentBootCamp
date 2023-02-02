package Scaler.SlidingWindow;

public class GenerateMatrix {

    static void printMatrix(int[][] B){
        for(int i =0; i < B.length;i++){
            for(int j =0; j < B[i].length;j++){
                System.out.print(B[i][j] + " , ");
            }
            System.out.println();
        }
    }
    public static int[][] solve(int A) {
        int[][]B = new int[A][A];
        int num = 1;
        int topRow = 0,leftCol=0;
        int bottomRow = A-1,rightCol = A-1;
        while(num <= A *A){
            for(int i = topRow;i <=rightCol;i++){
                B[topRow][i]=num++;
            }
            topRow++;
            for(int j = topRow;j<=bottomRow;j++){
                B[j][rightCol] = num++;
            }
            rightCol--;
            for(int k = rightCol; k >= leftCol;k--){
                B[bottomRow][k]=num++;
            }
            bottomRow--;
            for(int m = bottomRow; m >= topRow;m--){
                B[m][leftCol] = num++;
            }
            leftCol++;
        }

        return B;

    }

    public static void main(String[] args) {
        int A = 5;
       int c[][] = solve(A);
      // System.out.println(solve(A));
       printMatrix(c);

    }
}
