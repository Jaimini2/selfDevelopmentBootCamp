package src.finalDSARevisionScaler.Graphs;

import src.finalDSARevisionScaler.Graphs.minimumSpanningTree.PairII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Q91)Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 * You have to find an integer array D of size A such that:
 * D[i]: Shortest distance from the C node to node i.
 * If node i is not reachable from C then -1.
 * Note:
 * There are no self-loops in the graph.
 * There are no multiple edges between two pairs of vertices.
 * The graph may or may not be connected.
 * Nodes are numbered from 0 to A-1.
 * Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 */
/*public class DijkstraAlgorithm {

    public int[] solve(int A, int[][] B, int C) {
        //create a distance array of size A+1;

        int[] dist = new int[A];

        //initialise distance array
        Arrays.fill(dist,Integer.MAX_VALUE);

        //create adjacency list of ArrayList<Pair>

        ArrayList<PairII> [] adjlist = new ArrayList[B.length+1];

        //initialise it and store data inside it
        for (int i =0 ; i <A;i++){
            adjlist[i] = new ArrayList<>();
        }

        for (int i =0 ;i< B.length;i++){
            adjlist[B[i][0]].add(new PairII(B[i][1],B[i][2]));
            adjlist[B[i][1]].add(new PairII(B[i][0],B[i][2]));
        }

        //create a Pririty Queue and sort it on the basis of shortest edge

        PriorityQueue<PairII> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });

        dist[C] = 0;
        pq.add(new PairII(C,0));

        while (!pq.isEmpty()){
            PairII currentNode = pq.poll();

            int currNode = currentNode.node;

            // If the current distance is greater than the recorded distance, skip this node
            if(dist[currNode] < currentNode.weight){
                continue;
            }

            ArrayList<PairII> pairList =  adjlist[currentNode.node];
            for (int i =0;i < pairList.size();i++){
                int newNode = pairList.get(i).node;
                int edgeWeight  = pairList.get(i).weight;
                if(dist[currentNode.node] + edgeWeight < dist[newNode]){
                    dist[newNode] = dist[currentNode.node] + edgeWeight;
                    pq.add(new PairII(newNode,dist[newNode]));
                }
            }
        }


        return dist;
    }

    public static void main(String[] args) {

        int A = 6;

        int[][] B = {
                {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}
        };

        int C = 4;

        DijkstraAlgorithm djk = new DijkstraAlgorithm();
        int ans[] = djk.solve(A,B,C);

        for (int i : ans){
            System.out.println(i);
        }

    }
}*/

import java.util.*;

public class DijkstraAlgorithm {

    public int[] solve(int A, int[][] B, int C) {
        // Create a distance array of size A
        int[] dist = new int[A];

        // Initialize distance array
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Create adjacency list of ArrayList<Pair>
        ArrayList<PairII>[] adjlist = new ArrayList[A]; // Ensure size is A

        // Initialize it and store data inside it
        for (int i = 0; i < A; i++) { // Correct loop range to A
            adjlist[i] = new ArrayList<>(); // Initialize each adjacency list
        }

        // Populate the adjacency list with edges
        for (int i = 0; i < B.length; i++) {
            adjlist[B[i][0]].add(new PairII(B[i][1], B[i][2]));
            adjlist[B[i][1]].add(new PairII(B[i][0], B[i][2])); // Ensure undirected graph
        }

        // Create a Priority Queue and sort it on the basis of shortest edge
        PriorityQueue<PairII> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));


        dist[C] = 0;
        pq.add(new PairII(C, 0));

        while (!pq.isEmpty()) {
            PairII currentNode = pq.poll();
            int currNode = currentNode.node;

            // If the current distance is greater than the recorded distance, skip this node
            if (dist[currNode] < currentNode.weight) {
                continue;
            }

            ArrayList<PairII> pairList = adjlist[currentNode.node];
            for (PairII pair : pairList) {
                int newNode = pair.node;
                int edgeWeight = pair.weight;
                if (dist[currentNode.node] + edgeWeight < dist[newNode]) {
                    dist[newNode] = dist[currentNode.node] + edgeWeight;
                    pq.add(new PairII(newNode, dist[newNode]));
                }
            }
        }

       for (int i : dist){
           if(i == Integer.MAX_VALUE){
               i = -1;
           }
       }
        return dist;
    }

    public static void main(String[] args) {
        int A = 7;
        int[][] B = {
                {2, 4, 10},
                {3, 4, 1},
                {3, 6, 1},
                {1, 2, 4},
                {4, 5, 6}
        };
        int C = 2;

        DijkstraAlgorithm da = new DijkstraAlgorithm();
        int[] dist = da.solve(A, B, C);

        System.out.println("Shortest distances from node " + C + " to all other nodes:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }
}

