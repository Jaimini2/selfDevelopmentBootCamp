package src.finalDSARevisionScaler.Graphs;

/**
 * Q92) Coloring a Cycle Graph
 * Given the number of vertices A in a Cyclic Graph.
 * Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
 * A cyclic graph with A vertices is a graph with A edges, such that it forms a loop. See example test case explanation for more details.
 */
public class ColoringACycleGraph {
    public int solve(int A) {
        int mod = 1000000009;

        int minColor = 0;

        if(A%2 == 0){
            minColor = 2;
        }else{
            minColor = 2 + (A%2);
        }

        return minColor;
    }

    public static void main(String[] args) {

    }
}
