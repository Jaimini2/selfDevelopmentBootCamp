package src.finalDSARevisionScaler.Graphs.minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Q89) Prim's Algorithm
 * Commutable Islands
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 * We need to find bridges with minimal cost such that all islands are connected.
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 */
public class CommutableIslands {

    public int solve(int A, int[][] B) {
        //create adjacency list for storing the nodes and their edges
        ArrayList<PairII> adjList[] = new ArrayList[B.length+1];

        //Initialise Adjacency list
        for (int i =0 ; i <=A;i++){
            ArrayList<PairII> al = new ArrayList<>();
            adjList[i] = al;
        }

        //fill up adjacency list from 2D input array
        for (int i = 0; i < B.length;i++){
            adjList[B[i][0]].add(new PairII(B[i][1],B[i][2]));
            adjList[B[i][1]].add(new PairII(B[i][0],B[i][2]));
        }

        //Use minHeap to extract the pair with the smallest edge
        PriorityQueue<PairII> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });

        //create a visited array as well
        boolean[] visited = new boolean[A + 1];
        int totalCost = 0;

        //add the data in the Priority queue based on the minimum edge
        //lets start with node 1 and the  initial cost will be 0 since we are starting from here
        pq.add(new PairII(1,0));
       // visited[adjList[1].get(0).node] = true;

        while (!pq.isEmpty()){
            PairII pr = pq.poll();
            int node = pr.node;
            int cost = pr.weight;

            if (visited[node]){
                continue;
            }
            visited[node] = true;
            totalCost+=cost;

            for (PairII prr : adjList[node]){
                if (!visited[prr.node]){
                    pq.add(prr);
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int A = 4;

        int[][] B = {
                {1, 2, 1},  // Edge from node 1 to node 2 with weight 1
                {2, 3, 4},  // Edge from node 2 to node 3 with weight 4
                {1, 4, 3},  // Edge from node 1 to node 4 with weight 3
                {4, 3, 2},  // Edge from node 4 to node 3 with weight 2
                {1, 3, 10}  // Edge from node 1 to node 3 with weight 10
        };

        CommutableIslands cmi = new CommutableIslands();
        int ans = cmi.solve(A,B);
        System.out.println("Minimum cost for connecting all islands are "+ans);
    }
}
