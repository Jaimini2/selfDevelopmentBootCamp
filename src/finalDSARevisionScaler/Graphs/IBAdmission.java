package src.finalDSARevisionScaler.Graphs;

public class IBAdmission {
        int[] parent;
        int[] rank;
        int[] batchStrength;
    public int countBatches(int A, int[] B, int[][] C, int D) {
         parent = new int[A + 1];
         rank = new int[A + 1];
         batchStrength = new int[A + 1];

        // Initialize DSU
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            rank[i] = 0;
            batchStrength[i] = B[i - 1];
        }

        // Union all relationships
        for (int[] relation : C) {
            union(relation[0], relation[1]);
        }

        // Count batches with strength >= D
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (parent[i] == i && batchStrength[i] >= D) {
                count++;
            }
        }

        return count;
    }

    // Union function
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

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

    // Find function
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        IBAdmission ibAdmission = new IBAdmission();
        int A = 7;
        int[] B = {1, 6, 7, 2, 9, 4, 5};
        int[][] C = { {1, 2}, {2, 3}, {5, 6}, {5, 7} };
        int D = 12;

        int result = ibAdmission.countBatches(A, B, C, D);
        System.out.println("Number of batches selected: " + result);
    }
}