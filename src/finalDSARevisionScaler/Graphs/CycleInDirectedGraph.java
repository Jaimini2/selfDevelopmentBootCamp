package src.finalDSARevisionScaler.Graphs;

import java.util.ArrayList;

/**
 * Q83)Cycle in a Directed Graph
 * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 * NOTE:
 * The cycle must contain atleast two nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 */
public class CycleInDirectedGraph {

    public int solve(int[][]B,int A){

        ArrayList<ArrayList<Integer>> ajList = new ArrayList<>();

        for (int i =0 ; i <= A;i++){
            ArrayList<Integer> al = new ArrayList<>();
            ajList.add(al);
        }

        boolean visited[] = new boolean[A+1];
        for (int i =0 ; i <B.length ;i++){
            ajList.get(B[i][0]).add(B[i][1]);
        }
        boolean recStack [] = new boolean[A+1];

       for (int i = 1 ; i < B.length;i++){
           if(dfs(i,visited,recStack,ajList)){
               //cycle detected
               return 1;
           }
       }

       return 0;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> ajList) {
        if(recStack[node]){
            //cycle detected
            return true;
        }

        if (visited[node]){
            return false;
        }

        visited[node] = true;
        recStack[node] = true;


        for (int neighbour : ajList.get(node)){
           if (dfs(neighbour,visited,recStack,ajList)){
               return true;
           }
        }
        //remove from recStack since its path is completed
        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {

        int A = 5;
        int[][] B = {
                {1, 2},
                {1, 3},
                {2, 3},
                {1, 4},
                {4, 3},
                {4, 5},
                {3, 5}
        };



        CycleInDirectedGraph cg = new CycleInDirectedGraph();
        int ans = cg.solve(B,A);
        System.out.println(ans);

    }
}
