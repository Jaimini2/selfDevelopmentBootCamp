package src.finalDSARevisionScaler.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Q94)  Construct Roads -using Bipartite Graph
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country
 * formed remains bipartite country.
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country,
 * u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 * NOTE: All cities can be visited from any city.
 */
public class ConstructRoads {
    int connectedRoads = 0;

    public int solve(int A, int[][] B) {
        int mod = 1000000009;

        //create adjacency list
        ArrayList<Integer> ajlist[] = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            ajlist[i] = al;
        }

        //fill up ajlist
        for (int i = 0; i < B.length; i++) {
            ajlist[B[i][0]].add(B[i][1]);
            ajlist[B[i][1]].add(B[i][0]);
        }

        //create a color array to depict two different sets
        int color[] = new int[A + 1];
        Arrays.fill(color, -1);
        int ans = 0;
        int red = 0;
        int blue = 0;

        // Handle multiple components
        for (int i = 1; i <= A; i++) {
            if (color[i] == -1) {
                // Reset connected roads for new component
                if (!dfs(ajlist, color, i,0)) {
                    return 0;
                    // Not bipartite
                    }
            }
        }

        // check for the number of nodes in different sets
        //if 0 then those are counted in red , and if 1 then those are counted in blue
        //since total number of sets we can have is red * blue , what is remaining is the one's that are  totalNumberofpossiblites  - those that are already connected
        for (int i = 1; i < color.length; i++) {
            if (color[i] == 0) {
                red++;
            } else if (color[i] == 1) {
                blue++;
            }
        }

        long totalPossibleEdges = (((long)red  %mod)* ((long)blue % mod) % mod);
        long existingEdges = A - 1; // Since it's a tree
        long maxAdditionalRoads = (totalPossibleEdges - existingEdges) % mod;
        return (int)maxAdditionalRoads;
    }

    private boolean dfs(ArrayList<Integer>[] ajlist, int[] color, int src,int col) {
        color[src] = col;
        ArrayList<Integer> arrList = ajlist[src];

        for (int nextNode : arrList) {
            //count each edge as we traverse
            if (color[nextNode] == -1) {
                color[nextNode] = 1 - color[src];
                if (!dfs(ajlist, color, nextNode,1-col)) {
                    return false;
                }
            } else if (color[nextNode] == color[src]) {
                return false;
            }
        }
        return true;
    }

    public int solve1(int A, int[][] B) {

        //create adjacency list
        ArrayList<Integer> ajlist[] = new ArrayList[A+1];

        for (int i =0; i <= A;i++){
            ArrayList<Integer> al = new ArrayList<>();
            ajlist[i] = al;
        }

        //fill up ajlist
        for (int i =0; i < B.length;i++){
            ajlist[B[i][0]].add(B[i][1]);
        }

        //create a color array to depict two different sets
        int color[] = new int[A+1];
        Arrays.fill(color,-1);
        int ans = 0;
        int red = 0;
        int blue = 0;
        color[1] = 0;

        dfs2(ajlist,color,1);

        // check for the number of nodes in different sets
        //if 0 then those are counted in red , and if 1 then those are counted in blue
        //since total number of sets we can have is red * blue , what is remaining is the one's that are  totalNumberofpossiblites  - those that are already connected
        for (int i = 1; i < color.length;i++){
            if(color[i] == 0){
                red++;
            }else if(color[i] == 1){
                blue++;
            }
        }

        ans = (red * blue) - connectedRoads;
        return ans;
    }

    public int solve2(int A, int[][] B) { int mod = 1000000009;
        // Create adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            adjList[i] = new ArrayList<>();
        } // Fill up adjList
        for (int i = 0; i < B.length; i++) {
            adjList[B[i][0]].add(B[i][1]);
            adjList[B[i][1]].add(B[i][0]);
            // Add both directions for undirected graph
            }
        // Create a color array to depict two different sets
        int[] color = new int[A + 1];
        Arrays.fill(color, -1); int ans = 0; int red = 0; int blue = 0;
        // Handle multiple components
        for (int i = 1; i <= A; i++) {
            if (color[i] == -1) {
                if (!dfs2(adjList, color, i)) {
                    return 0;
                    // Not bipartite
                }
            }
        }
        // Check for the number of nodes in different sets
        // if 0 then those are counted in red, and if 1 then those are counted in blue
        // since total number of sets we can have is red * blue, what is remaining is the ones that are already connected
        for (int i = 1; i < color.length; i++) {
            if (color[i] == 0) {
                red++;
            } else if (color[i] == 1) {
                blue++;
            }
        }
        connectedRoads /= 2;
        // Each edge is counted twice
        ans = (red * blue) - connectedRoads;
        return ans;
    }

    private boolean dfs2(ArrayList<Integer>[] adjList, int[] color, int src) {
        ArrayList<Integer> neighbors = adjList[src];
        for (int nextNode : neighbors) {
            connectedRoads++;
            // Count each edge as we traverse
            if (color[nextNode] == -1) {
                color[nextNode] = 1 - color[src];
                if (!dfs2(adjList, color, nextNode)) {
                    return false;
                }
            } else if (color[nextNode] == color[src]) {
                return false;
                // Not bipartite
            }
        }
        return true;
    }

    private void dfs(ArrayList<Integer>[] ajlist, int[] color, int red, int blue, int src, int ans, int i) {
        ArrayList<Integer> arrList = ajlist[src];

        for (int nextNode : arrList){
            if (color[nextNode] == -1){
                color[nextNode] = 1 - color[src];
                if(color[nextNode] == 0){
                    red++;
                }else{
                    blue++;
                }
            }
        }

    }
    public static void main(String[] args) {

        int A = 5;
        int[][] B = {
                {1, 3},
                {1, 4},
                {3, 2},
                {3, 5}
        };


        ConstructRoads cr = new ConstructRoads();
        int ans = cr.solve(A, B);
        System.out.println(ans);

    }
}
