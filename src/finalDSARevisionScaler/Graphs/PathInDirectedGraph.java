package src.finalDSARevisionScaler.Graphs;

import java.util.*;

/**
 * Q82)Path in Directed Graph
 * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
 * B[i][0] to node B[i][1].
 * Find whether a path exists from node 1 to node A.
 * Return 1 if path exists else return 0.
 * NOTE:
 *
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 */
public class PathInDirectedGraph {

    public int solve(int A,int[][]B){
        List<Integer> [] list= new ArrayList[A+1];

        //create Adjaceny list
        // here we created a Array of List<Integer> of size A + 1 since the indexing will start from 1

        for (int i =0 ; i < B.length;i++){
            if(list[B[i][0]] == null){
                List<Integer> al= new ArrayList<>();
                list[B[i][0]] = al;
            }
           list[B[i][0]].add(B[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[A+1];

        //Start with the node 1 and add it in queue
      queue.add(1);
      vis[1] = true;
      while (!queue.isEmpty()){
         int val = queue.poll();
         //if the node removed from queue is the last node , then return 1 ,
          // it means we have traversed the path and reached to end node successsfully
         if(val == A){
             return 1;
         }

         //look for all the nodes and traverse its edges
         for (int i = 0; i < list[val].size();i++){
             int in =  list[val].get(i);

             if( !vis[in]) {
                 vis[in] = true;
                 queue.add(in);
             }
         }

      }
        return 0;

    }


    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };


        PathInDirectedGraph pdg = new PathInDirectedGraph();
      int ans =   pdg.solve(A,B);
        System.out.println(ans);

    }
}
