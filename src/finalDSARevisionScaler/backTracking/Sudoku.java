package src.finalDSARevisionScaler.backTracking;

/**
 * Q68) Sudoku
 */

public class Sudoku {
    char[][]ans;
    public char[][] solveSudoku(char[][] A) {

       ans = A;
        int cell = 1;
        sudoku(ans,cell);
        return ans;
    }

    public boolean sudoku(char[][]A,int cell){

        int row = (cell-1)/9;
        int col = (cell-1) % 9;
        if(cell == 81){
            if(A[row][col] != '.'){
                return true;
            }else{
                for (int k = 0 ; k < A.length;k++){
                    if (checkSafe(A,row,col,k)){
                        A[row][col] = (char)(k + '0');
                    }
                }
            }
            return true;
        }


        if(A[row][col] != '.'){
            return sudoku(A,cell+1);
        }

        for(int k = 1; k <= 9; k++){
            if(checkSafe(A,row,col,k)){
                A[row][col] = (char) (k+'0') ;
                if(sudoku(A,cell+1) == true){
                    return true;
                }
                A[row][col] = '.';
            }
        }

        return false;

    }

    private boolean checkSafe(char[][] a, int row, int col, int k) {
        //checking if the element is present in any column of that particular row
        for(int i = 0; i < a.length;i++){
            if(a[row][i] == (char)(k + '0')){
                return false;
            }
        }

        //checking if the element is present int any row of that particular column
        for (int i =0;i < a.length;i++){
            if (a[i][col] ==(char)(k + '0')){
                return false;
            }
        }

        //checking if the element is present in the 3*3 grid of that present index

        int startRow = row-row%3;
        int startCol = col - col%3;

        for (int i = startRow; i < startRow+3;i++){
            for (int j = startCol ; j < startCol+3;j++){
                if(a[i][j] == (char)(k + '0')){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Sudoku s = new Sudoku();

        char[][] A = {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };


        char[][]ans =  s.solveSudoku(board);

       for (char[] i : ans){
           for (char j : i){
               System.out.print(" "+ j + ",");
           }
           System.out.println();
       }

    }
}
