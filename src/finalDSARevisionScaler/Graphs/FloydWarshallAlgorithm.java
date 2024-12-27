package src.finalDSARevisionScaler.Graphs;

import java.util.Arrays;

/**
 * Q95) Floyd Warshall Algorithm
 * Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
/*public class FloydWarshallAlgorithm {

    public int[][] solve(int[][] A) {

        int ans[][] = new int[A.length][A[0].length];

        // Initialize the answer matrix with the input matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == -1) {
                    ans[i][j] = Integer.MAX_VALUE;
                } else {
                    ans[i][j] = A[i][j];
                }
            }
        }

        for(int k =0;k < A.length;k++){
            for (int i =0; i < A.length;i++){
                for (int j =0 ; j < A[i].length;j++){
                    if(ans[i][j] > A[i][k] + A[k][j]){
                        ans[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }


        for (int i =0 ; i < ans.length;i++){
            for (int j =0; j < ans[i].length;j++){
                if (ans[i][j] == Integer.MAX_VALUE){
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
        int [][] ans = flw.solve(A);

        for (int i =0 ; i < ans.length;i++){
            for (int j =0; j < ans[i].length;j++){
                System.out.print(ans[i][j] + " ,");
            }
            System.out.println();
        }


    }
}*/
public class FloydWarshallAlgorithm {

    public int[][] solve(int[][] A) {
        int N = A.length;
        int[][] dist = new int[N][N];

        // Initialize the distance matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == -1 && i != j) {
                    dist[i][j] = Integer.MAX_VALUE; // Representing infinity
                } else {
                    dist[i][j] = A[i][j];
                }
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Replace Integer.MAX_VALUE with -1 to denote no path
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 5, -1, 10},
                {-1, 0, 3, -1},
                {-1, -1, 0, 1},
                {-1, -1, -1, 0}
        };

        FloydWarshallAlgorithm fwa = new FloydWarshallAlgorithm();
        int[][] result = fwa.solve(A);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}


