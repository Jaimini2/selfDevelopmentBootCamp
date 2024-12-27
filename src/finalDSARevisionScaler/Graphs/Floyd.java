package src.finalDSARevisionScaler.Graphs;

public class Floyd {

    public int[][] solve(int[][] A) {
        int N = A.length;
        int[][] ans = new int[N][N];

        // Initialize the answer matrix with the input matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == -1) {
                    ans[i][j] = Integer.MAX_VALUE;
                } else {
                    ans[i][j] = A[i][j];
                }
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ans[i][k] != Integer.MAX_VALUE && ans[k][j] != Integer.MAX_VALUE) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
                    }
                }
            }
        }

        // Replace Integer.MAX_VALUE with -1 to denote no path
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ans[i][j] == Integer.MAX_VALUE) {
                    ans[i][j] = -1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 50, 39},
                {-1, 0, 1},
                {-1, 10, 0}
        };

        FloydWarshallAlgorithm flw = new FloydWarshallAlgorithm();
        int[][] ans = flw.solve(A);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ,");
            }
            System.out.println();
        }
    }
}
