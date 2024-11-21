package src.finalDSARevisionScaler.basics;

/**
 * Q54) Pretty print a Rectangle
 */
public class PrettyPrint {

    private int[][] solve(int A) {
        int n = A*2-1;
        int  [][] ans = new int[n][n];

        int topRow = 0,bottomRow = n-1,leftCol = 0,rightCol = n-1;
        for (int i =topRow; i <= bottomRow;i++){
            //fill up tow row
            for (int j = leftCol; j <= rightCol;j++){
                ans[i][j]=A-i;
            }
            topRow++;
            for(int k = topRow;k<=bottomRow;k++){
                ans[k][rightCol] = A-i;
            }
            rightCol--;

            for (int l = rightCol;l>=leftCol;l--){
                ans[bottomRow][l] = A-i;
            }
            bottomRow--;
            for (int m = bottomRow;m >= topRow;m--){
                ans[m][leftCol] = A-i;
            }
            leftCol++;
        }
        return ans;
    }

    public static void main(String[] args) {
        PrettyPrint pr = new PrettyPrint();
        int A = 4;
        int[][]ans = pr.solve(A);

        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }




}

