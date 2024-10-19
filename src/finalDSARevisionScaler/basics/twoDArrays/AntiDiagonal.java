package src.finalDSARevisionScaler.basics.twoDArrays;

/**
 * Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
 *
 * Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
 * The vacant spaces in the grid should be assigned to 0.
 *
 * 2*4-1 * N
 */
public class AntiDiagonal {

    public int[][] diagonal(int[][] A) {

        int [][] ans = new int[(2 * A.length)-1][A.length];
        int n = A.length;
        int m = A[0].length;
        int z = 0;
        for(int i =0 ; i < n;i++){
                int [] a= new int[A[0].length];
                int j =0;
               printDiagonal(0,i,a,A);

            ans[z++] = a;
        }

        for(int i = 1; i < n;i++){
            int x = i;
            int y = n-1;
            int[] a = new int[A.length];

            printDiagonal(i,m-1,a,A);

            ans[z++] = a;
        }



        return ans;
    }

    void  printDiagonal(int i,int j,int[] in,int mat[][]){
        int n = mat.length;
        int counter = 0;
        while(i < n && j >= 0){
            in[counter++] = mat[i][j];
            i++;
            j--;
        }

        while(counter < in.length){
            in[counter++] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] A = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};

        AntiDiagonal t2 = new AntiDiagonal();

        int [][] ans = t2.diagonal(A);

        for(int i[] : ans){
            for(int  j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}

