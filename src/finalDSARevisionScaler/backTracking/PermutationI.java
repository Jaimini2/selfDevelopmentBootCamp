package src.finalDSARevisionScaler.backTracking;

/**
 * Q62)Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 * NOTE:
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 */
public class PermutationI {

    int[][]finalAns = new int[6][3];
    int count = 0;
    private int[][] permute(int[] A) {
        int idx = 0;

        boolean[] visited = {false,false,false};
        int[] input = new int[A.length];
        perm(A,idx,visited,input);

        return finalAns;

    }

        public void perm(int [] A,int idx,boolean[] vis,int[]ans ){
        if (idx == ans.length){
            for (int i =0 ; i < ans.length;i++){
                finalAns[count][i] = ans[i];
            }
            count++;
           return;
        }

        for (int i =0; i < A.length;i++){
            if (vis[i] == false){
                vis[i] = true;
                ans[idx] = A[i];
                perm(A,idx + 1,vis,ans);
                vis[i] = false;
            }
        }

    }


    public static void main(String[] args) {

        int A[] = {1,2,3};

        PermutationI perm = new PermutationI();


        int[][] ans = perm.permute(A);

        for (int[] n : ans){
            for (int i : n){
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }


}
