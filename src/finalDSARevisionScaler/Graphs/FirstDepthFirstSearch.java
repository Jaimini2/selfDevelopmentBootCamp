package src.finalDSARevisionScaler.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q84)First DFS
 *You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
 * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
 * B C : query to find whether B is reachable from C.
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
 * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
 */
public class FirstDepthFirstSearch {

    public int solve(int[] A,int B,int C){

        ArrayList<Integer>[] adjlist = new ArrayList[A.length+1];

        for (int i = 0 ; i <=A.length;i++){
            adjlist[i] = new ArrayList<>();
        }

        int n = A.length;

        for (int i =1; i <n;i++){
            //Since There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
            adjlist[A[i]].add(i+1);
        }

        boolean[] visited = new boolean[n+1];
        dfs(adjlist,visited,C);


        return visited[B] ? 1 : 0;
    }

    private void dfs(ArrayList<Integer>[] adjlist, boolean[] visited, int c) {
        visited[c] = true;

        ArrayList<Integer> al = adjlist[c];
        for (int node : al){
            if(!visited[node]){
                visited[node] = true;
                dfs(adjlist,visited,node);
            }
        }
    }

    public static void main(String[] args) {
        int [] A = {1, 1, 2,3,3};
        int B = 3;
        int C = 1;

        FirstDepthFirstSearch fds = new FirstDepthFirstSearch();

        int ans = fds.solve(A,B,C);
        System.out.println(ans);
    }
}
