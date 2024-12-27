package src.finalDSARevisionScaler.Graphs;

import src.finalDSARevisionScaler.Graphs.minimumSpanningTree.PairII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q90)Another BFS , introduce Dummy node
 * Given a weighted undirected graph having A nodes, a source node C and destination node D.
 * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
 * You are expected to do it in Time Complexity of O(A + M).
 * Note:
 * There are no self-loops in the graph.
 * No multiple edges between two pair of vertices.
 * The graph may or may not be connected.
 * Nodes are Numbered from 0 to A-1.
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 */
public class AnotherBFS {

    public int solve(int A, int[][] B, int C, int D) {

        //create adjacency list first
        ArrayList<ArrayList<PairII>> ajlist = new ArrayList<>();
        for (int i =0; i <= A;i++){
            ArrayList<PairII> al = new ArrayList<>();
            ajlist.add(al);
        }

        for (int i =0 ;i < B.length;i++){
            if(B[i][2] > 1){
                //code to insert dummy node if the wieght is more than 1
                insertDummyNode(ajlist,B,i);
            }else{
                ajlist.get(B[i][0]).add(new PairII(B[i][1],B[i][2]));
                ajlist.get(B[i][1]).add(new PairII(B[i][0],B[i][2]));
            }

        }
        //perform BFS to find the shortest distance from C to D
        //Use queue to traverse through all the elements and use Visited array to keep track of the visited array
        boolean visited[] = new boolean[ajlist.size()+1];

        //use distance array to keep the track of the shortest distance from C to D and update if you find the shortest distance from C to D

        int dist[] = new int[ajlist.size()+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<PairII> queue = new LinkedList<>();

        dist[C] = 0;

        queue.add(new PairII(C,dist[C]));

        while (!queue.isEmpty()){
            PairII current = queue.poll();
            if (visited[current.node]){
                continue;
            }
            visited[current.node] = true;

            ArrayList<PairII> prList2= ajlist.get(current.node);
            for (PairII pair : prList2){
                int nextNode = pair.node;
                int edgeWeight = pair.weight;

                if (dist[current.node] + edgeWeight < dist[nextNode]){
                    dist[nextNode] = dist[current.node] + edgeWeight;
                    queue.add(new PairII(nextNode,dist[nextNode]));
                }
            }
        }

        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }

    private void insertDummyNode(ArrayList<ArrayList<PairII>> ajlist, int[][]b,int indx) {
        ArrayList<PairII> pr = new ArrayList<>();

         int srcNode = b[indx][0];
        int destNode = b[indx][1];
        int newDestNode = ajlist.size();

        ajlist.get(srcNode).add(new PairII(newDestNode, 1));

        ajlist.add(pr);
        ajlist.get(newDestNode).add(new PairII(destNode, 1));
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

        int ans = abfs.solve(A,B,C,D);
        System.out.println("Shortest Distance to reach from C to D is " + ans);


    }


}
