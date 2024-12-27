package src.finalDSARevisionScaler.Graphs;

import java.util.*;

/**
 * Q85) Topological sorting of a Graph
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 * NOTE:
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 */
public class TopologicalSort {


    public int[] solve(int A, int[][] B) {

        //create an Adjacency List
        ArrayList<Integer> adjlist[] = new ArrayList[B.length + 1];

        for (int i = 0; i <= B.length; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            adjlist[i] = al;
        }

        //create and fill up  indegree array
        int[] indegree = new int[A + 1];

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            adjlist[u].add(B[i][1]);
            indegree[v]++;
        }

        //ttraverse through the Adjacency list and check the element with indegree as zero,
        //then put that in queue and all decrement the indegree of all its edges by 1 since it is going in and out of the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[A];
        int x = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int val = queue.remove();
            ans[x] = val;
            x++;
            count++;

            ArrayList<Integer> al = adjlist[val];

            //my implementation

            //  indegree[adjlist[val].get(0)]--;

           /* if (indegree[adjlist[val].get(0)] == 0){
                queue.add(adjlist[val].get(0));
            }*/

            for (int i = 0; i < al.size(); i++) {
                indegree[adjlist[val].get(i)]--;

                if (indegree[adjlist[val].get(i)] == 0) {
                    queue.add(adjlist[val].get(i));
                }
            }

            // referrenced taken from scaler question
           /* for (int i : al) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }*/
        }
        if (count == A) {
            return ans;
        } else {
            return new int[0];
        }


    }

    public static void main(String[] args) {
        int A = 6;

        int[][] B = {
                {6, 3},
                {6, 1},
                {5, 1},
                {5, 2},
                {3, 4},
                {4, 2}
        };

        TopologicalSort tp = new TopologicalSort();
        int[] ans = tp.solve(A, B);

        for (int i : ans) {
            System.out.print(" " + i + " ,");
        }
    }
}
