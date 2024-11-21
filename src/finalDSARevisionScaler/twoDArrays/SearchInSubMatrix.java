package src.finalDSARevisionScaler.twoDArrays;

/**
 * Q23)Search in a row wise and column wise sorted matrix
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in non-decreasing order.
 * Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 */
public class SearchInSubMatrix {

    public int solve(int[][] A, int B) {
        int row  = 0;
        int col = A[0].length-1;
        int n = A.length;
        int min = Integer.MAX_VALUE;

        while (row < n && col >= 0){
            if(A[row][col] == B){
                min = Math.min(min,row * 1009+(col+1));
                col--;
            }else if (A[row][col] > B){
                col--;
            }else if (A[row][col] < B){
                row++;
            }
        }

        if (min == Integer.MAX_VALUE)
        return -1;
        else
            return min;
    }

    public static void main(String[] args) {
        SearchInSubMatrix sm = new SearchInSubMatrix();

        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
       int B = 2;
        int ans = sm.solve(A,B);

        System.out.println(ans);
    }
}
