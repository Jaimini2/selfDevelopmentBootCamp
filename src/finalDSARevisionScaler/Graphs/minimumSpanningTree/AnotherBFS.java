package src.finalDSARevisionScaler.Graphs.minimumSpanningTree;

import java.util.*;

/*class PairII {
    int node, weight;
    PairII(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}*/

public class AnotherBFS {

    public int solve(int A, int[][] B, int C, int D) {
        // Create adjacency list
        List<List<PairII>> adjList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adjList.add(new ArrayList<>());
        }

        // Transform the graph by introducing dummy nodes
        int dummyNode = A; // Start dummy nodes after A nodes
        for (int[] edge : B) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w > 1) {
                int prevNode = u;
                for (int i = 1; i < w; i++) {
                    if (dummyNode >= adjList.size()) {
                        adjList.add(new ArrayList<>()); // Add new dummy node
                    }
                    int nextNode = dummyNode++;
                    adjList.get(prevNode).add(new PairII(nextNode, 1));
                    adjList.get(nextNode).add(new PairII(prevNode, 1)); // Ensure undirected graph
                    prevNode = nextNode;
                }
                adjList.get(prevNode).add(new PairII(v, 1));
                adjList.get(v).add(new PairII(prevNode, 1)); // Ensure undirected graph
            } else {
                adjList.get(u).add(new PairII(v, w));
                adjList.get(v).add(new PairII(u, w)); // Ensure undirected graph
            }
        }

        // Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[dummyNode + 1];
        int[] dist = new int[dummyNode + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(C);
        dist[C] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == D) return dist[D]; // Early exit if destination reached

            if (visited[node]) continue;
            visited[node] = true;

            for (PairII neighbor : adjList.get(node)) {
                int nextNode = neighbor.node;
                if (!visited[nextNode] && dist[node] + 1 < dist[nextNode]) {
                    dist[nextNode] = dist[node] + 1;
                    queue.add(nextNode);
                }
            }
        }

        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }

    public static void main(String[] args) {
        int A = 10;
        int[][] B = {
                {5, 6, 2},
                {0, 2, 1},
                {4, 6, 1},
                {3, 7, 1},
                {7, 9, 2},
                {2, 6, 2},
                {7, 8, 2},
                {3, 6, 2},
                {4, 7, 1},
                {3, 8, 1}
        };
        int C = 9;
        int D = 7;

        AnotherBFS abfs = new AnotherBFS();
        int ans = abfs.solve(A, B, C, D);
        System.out.println("Shortest Distance to reach from C to D is " + ans);
    }
}
