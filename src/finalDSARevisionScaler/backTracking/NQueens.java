package src.finalDSARevisionScaler.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Q67) N Queens BAck tracking problem
 *The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.
 */
public class NQueens {

    public String[][] solveNQueens(int A) {
        boolean column[] = new boolean[A];
        boolean diagonal1[] = new boolean[(2*A)-1];
        boolean diagonal2[] = new boolean[(2*A)-1];

        int queens = A;


        String[][] ans = new String[A][A];
       List<List<String>> finalAns = new ArrayList<>();

        for (String[] i : ans){
            Arrays.fill(i," . ");
        }
        int row = 0;
        nQueens(ans,row,queens,column,diagonal1,diagonal2,finalAns);

        String[][]solutions = new String[finalAns.size()][];

        for (int i =0 ; i < finalAns.size();i++){
            List<String> solution = finalAns.get(i);
            Collections.reverse(solution);
            solutions[i] = solution.toArray(new String[0]);
        }

        Arrays.sort(solutions,(a,b)->{
            for (int i =0; i < a.length;i++){
                int cmp = b[i].compareTo(a[i]);
                if(cmp != 0){
                    return cmp;
                }
            }
            return 0;
        });

        return solutions;
    }

    public void nQueens(String[][]ans, int row, int queens, boolean[] column, boolean[] diagonal1, boolean[] diagonal2, List<List<String>> finalAns){

        if(row == queens){
            finalAns.add(constructBoard(ans));
            return;
        }
        for(int col = 0; col < queens;col++){
            if(column[col] == false
                    && diagonal1[row - col + queens-1] == false
                    && diagonal2[row + col] == false){
                ans[row][col] = "Q";
                column[col] = true;
                diagonal1[row - col + queens-1] = true;
                diagonal2[row + col] = true;
                nQueens(ans,row+1,queens,column,diagonal1,diagonal2, finalAns);
                ans[row][col] = " . ";
                column[col] = false;
                diagonal1[row - col + queens-1] = false;
                diagonal2[row + col] = false;
            }
        }
    }

    private List<String> constructBoard(String[][] ans) {
        List<String> row = new ArrayList<>();

        for (String[] rows : ans){
            String str = "";
          for (String i : rows){
              str = str+i;
          }
          row.add(str);
        }
        return row;
    }


    public static void main(String[] args) {

        NQueens n = new NQueens();

        String[][] ans = n.solveNQueens(10);

        for (String[] i : ans){
            System.out.print("[");
            for (String j : i){
                System.out.println(" "+j+" ");
            }
            System.out.println("]");
        }

    }
}

/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NQueens {

    public static String[][] solveNQueens(int A) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[A][A];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, result);

        // Convert the result to String[][] in reverse lexicographical order
        String[][] solutions = new String[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            List<String> solution = result.get(i);
            Collections.reverse(solution);
            solutions[i] = solution.toArray(new String[0]);
        }

        Arrays.sort(solutions, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = b[i].compareTo(a[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        return solutions;
    }

    private static void solve(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();

        for (char[] row : board) {
            path.add(new String(row));
        }

        return path;
    }

    public static void main(String[] args) {
        int A = 4;  // Example input
        String[][] solutions = solveNQueens(A);

        // Print the solutions
        for (String[] solution : solutions) {
            System.out.println(Arrays.toString(solution));
        }
    }
}*/
