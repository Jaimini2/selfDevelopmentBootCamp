package src.finalDSARevisionScaler.Graphs;

/**
 * Q87) DSU - Batches
 * A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
 * Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
 * All students who know each other are placed in one batch.
 * Strength of a batch is equal to sum of the strength of all the students in it.
 * Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
 * Find the number of batches selected.
 * NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 */
public class Batches {

    public int solve(int A, int[] B, int[][] C, int D) {

        int[] parent = new int[A+1];
        int[] rank = new int[A+1];
        int [] batchStrength = new int[A+1];

        //initialize DSU
        for(int i =1;i <= A;i++){
            parent[i] = i;
            rank[i] = 0;
            batchStrength[i] = B[i-1];
        }

        //union all relateions
        for (int i =0; i < C.length;i++){
            union(C[i][0],C[i][1],parent,rank,batchStrength);
        }

        //count batches with strength >= D
        int count = 0;
        for (int i =1; i <= A;i++){
            if (parent[i] == i && batchStrength[i]>= D){
             count++;
            }
        }

        return count;
    }


    //find function to find the parent
    int find(int x,int parent[]){
        if(x == parent[x]){
            return x;
        }else{
            parent[x] = find(parent[x],parent);
            return parent[x];
        }
    }

    //union function for union

    private void union(int x, int y,int[] parent,int[]rank,int[]batchStrength){
        int rootX = find(x,parent);
        int rootY= find(y,parent);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                batchStrength[rootX] += batchStrength[rootY];
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                batchStrength[rootY] += batchStrength[rootX];
            } else {
                parent[rootY] = rootX;
                batchStrength[rootX] += batchStrength[rootY];
                rank[rootX]++;
            }
        }

    }
    public static void main(String[] args) {

        int A = 7;
        int[] B = {1, 6, 7, 2, 9, 4, 5};
        int[][] C = { {1, 2}, {2, 3}, {5, 6}, {5, 7} };
        int D = 12;

        Batches b = new Batches();
        int ans = b.solve(A,B,C,D);
        System.out.println("Number of batches selected: " + ans);

    }
}
