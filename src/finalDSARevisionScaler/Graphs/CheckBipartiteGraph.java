package src.finalDSARevisionScaler.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q93)Check Bipartite Graph
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1]
 * Find whether the given graph is bipartite or not.
 * A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
 * Note:
 * There are no self-loops in the graph.
 * No multiple edges between two pair of vertices.
 * The graph may or may not be connected.
 * Nodes are Numbered from 0 to A-1.
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 */
public class CheckBipartiteGraph {

    public int solve(int A, int[][] B) {

        //creating an adjacency list and initialise it

        ArrayList<Integer>[] ajlist = new ArrayList[A];

        for (int i = 0; i < ajlist.length; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            ajlist[i] = al;
        }

        //fill up data in the adjacency list
        for (int i = 0; i < B.length; i++) {
            ajlist[B[i][0]].add(B[i][1]);
            ajlist[B[i][1]].add(B[i][0]);
        }

        //create a color array depicting the color of its index nodes
        int color[] = new int[A];
        Arrays.fill(color, -1);
       // int src = 0;

        // Check all components of the graph
        for (int src = 0; src < A; src++) {
            if (color[src] == -1) {
                // Perform BFS for each unvisited component

                if (!isBipartite(src, ajlist, color)) {
                    return 0;
                }
            }
        }
        return 1;
        //create a queue and insert data
      //  int ans = isBipartite(src, ajlist, color) ? 1 : 0;

       // return ans;
    }

    public boolean isBipartite(int src, ArrayList<Integer>[] ajlist, int[] color) {

        //create a queue and start inserting and removing data from it
        //and also update the color array as well
        Queue<Integer> queue = new LinkedList();

        queue.add(src);
        color[src] = 0;

        while (!queue.isEmpty()) {

            int val = queue.poll();

            ArrayList<Integer> aList = ajlist[val];
            for (int i = 0; i < aList.size(); i++) {
                int newVal = aList.get(i);
                if (color[newVal] == -1) {
                    color[newVal] = 1 - color[val];
                    queue.add(newVal);
                } else if (color[newVal] == color[val]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int A = 69;

        int[][] B = {
                {40, 64},
                {29, 60},
                {26, 43},
                {29, 32},
                {32, 47},
                {42, 61},
                {48, 61},
                {26, 52},
                {24, 34},
                {35, 55},
                {14, 60},
                {53, 62},
                {61, 63},
                {13, 53},
                {16, 62},
                {62, 64},
                {56, 68},
                {2, 23},
                {7, 55},
                {3, 60},
                {32, 51},
                {2, 18},
                {1, 43},
                {5, 37},
                {4, 51},
                {27, 55},
                {15, 30},
                {13, 65},
                {7, 13},
                {28, 48},
                {36, 50},
                {3, 7},
                {30, 46},
                {1, 35},
                {47, 68},
                {37, 62},
                {37, 58},
                {8, 22},
                {19, 45},
                {6, 64},
                {9, 55},
                {32, 46},
                {48, 56},
                {26, 59},
                {8, 46},
                {44, 66},
                {50, 60},
                {40, 46},
                {30, 68},
                {26, 44},
                {5, 32},
                {9, 34},
                {36, 45},
                {47, 48}
        };


        CheckBipartiteGraph cbg = new CheckBipartiteGraph();
        int ans = cbg.solve(A, B);
        System.out.println(ans);

    }
}
