package src.finalDSARevisionScaler.Graphs.minimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q88) Kruskal's Algorithm
 *Flipkart has ‘A’ local distribution centers located across a large metropolitan city. Each distribution center needs to be interconnected through roads to
 *  facilitate efficient movement of goods. The cost of constructing a road between any two distribution centers is represented by the weight of the edge connecting them.
 * Given a graph with ‘A’ nodes representing the distribution centers and C weighted edges representing the possible roads between them, your task is to find the minimum total cost of constructing roads such that every distribution center can be reached from the first distribution center.
 * Cost Calculation:
 * The cost of constructing the roads is the sum of the weights of the edges selected for the construction.
 * NOTE: Return the answer modulo 10^9+7 as the answer can be large.
 */
public class ConstructionCost {

    public int solve(int A, int[][] B) {

        //create parent array and initilaise it
        int parent[] = new int[A+1];

        for (int i = 1 ; i <= A;i++){
            parent[i] = i;
        }

        Pair pair[] = new Pair[B.length];
        int count  =0;
        for (int[] i : B){
            Pair p = new Pair(i[0],i[1],i[2]);
            pair[count] = p;
            count++;
        }


        //optional Create adjacency list as well in case they require path as well
        Pair[] adjlist = new Pair[B.length+1];


       Arrays.sort(pair, (o1,o2)-> {
           return o1.edgeWeight - o2.edgeWeight;
       });

        int ans = 0;
        int mod = 1000000007;
        for (Pair i : pair){
            if (union(i.nodeU,i.nodeV,parent)){
                adjlist[i.nodeU] = new Pair(i.nodeU,i.nodeV,i.edgeWeight);
                ans = (ans % mod + i.edgeWeight % mod)%mod;
            }
        }

        return ans % mod;
    }

    public Pair[] solveandFindPath(int A, int[][] B) {

        //create parent array and initilaise it
        int parent[] = new int[A+1];

        for (int i = 1 ; i <= A;i++){
            parent[i] = i;
        }

        Pair pair[] = new Pair[B.length];
        int count  =0;
        for (int[] i : B){
            Pair p = new Pair(i[0],i[1],i[2]);
            pair[count] = p;
            count++;
        }


        //optional Create adjacency list as well in case they require path as well
        Pair[] adjlist = new Pair[B.length+1];


        Arrays.sort(pair, (o1,o2)-> {
            return o1.edgeWeight - o2.edgeWeight;
        });

        int ans = 0;
        for (Pair i : pair){
            if (union(i.nodeU,i.nodeV,parent)){
                adjlist[i.nodeU] = new Pair(i.nodeU,i.nodeV,i.edgeWeight);
                adjlist[i.nodeV] = new Pair(i.nodeV, i.nodeU,i.edgeWeight);
                ans +=i.edgeWeight;
            }
        }

        return adjlist;
    }
    private int find(int x,int[] parent){
        if(x == parent[x]){
            return x;
        }else{
            parent[x] = find(parent[x],parent);
            return parent[x];
        }
    }

    private boolean union(int nodeU,int nodeV,int[]parent){
        int rootX = find(nodeU,parent);
        int rootY = find(nodeV,parent);

        if (rootX == rootY){
            return false;
        }else if(rootX < rootY){
            parent[rootY] = rootX;
        }else{
            parent[rootX] = rootY;
        }

        return true;
    }



    public static void main(String[] args) {

        int A = 3;

        int[][] B = {
                {1, 2, 14}, // Edge from node 1 to node 2 with weight 14
                {2, 3, 7},  // Edge from node 2 to node 3 with weight 7
                {3, 1, 2}   // Edge from node 3 to node 1 with weight 2
        };

        ConstructionCost cc = new ConstructionCost();
        int ans = cc.solve(A,B);
        System.out.println("Construction cose is : " + ans);

        Pair[] adjlistAns = cc.solveandFindPath(A,B);

        for (int i =1; i < adjlistAns.length;i++){
            System.out.println("Traversed path  is " + adjlistAns[i].nodeU + " --->");
        }

    }
}
