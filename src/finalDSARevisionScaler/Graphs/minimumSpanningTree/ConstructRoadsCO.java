package src.finalDSARevisionScaler.Graphs.minimumSpanningTree;

import java.util.*;

/**
 * Using BFS , it worked in the Assignment question but it did not worked using DFS
 */
public class ConstructRoadsCO {
    public int solve(int A, int[][] B) {
        int mod = 1000000007;

        // Create adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Fill up adjList
        for (int i = 0; i < B.length; i++) {
            adjList[B[i][0]].add(B[i][1]);
            adjList[B[i][1]].add(B[i][0]); // Add both directions for undirected graph
        }

        // Create a color array to depict two different sets
        int[] color = new int[A + 1];
        Arrays.fill(color, -1);
        int red = 0;
        int blue = 0;

        // BFS to color the graph and count nodes in each set
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        color[1] = 0; // Start coloring the first node with color 0 (red)

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (color[node] == 0) red++;
            else blue++;

            for (int neighbor : adjList[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                }
            }
        }

        // Calculate the maximum number of additional roads
        long totalPossibleEdges = (long) red * (long) blue;
        long existingEdges = A - 1; // Since it's a tree
        long maxAdditionalRoads = (totalPossibleEdges - existingEdges) % mod;

        return (int) maxAdditionalRoads;
    }

    public static void main(String[] args) {
        int A = 15;
        int[][] B = {
                {7, 5},
                {15, 14},
                {11, 2},
                {8, 7},
                {10, 3},
                {5, 3},
                {4, 2},
                {6, 4},
                {13, 2},
                {3, 2},
                {14, 11},
                {12, 9},
                {2, 1},
                {9, 2}
        };

        ConstructRoadsCO cr = new ConstructRoadsCO();
        int ans = cr.solve(A, B);
        System.out.println(ans); // Expected output should be 49
    }
}


