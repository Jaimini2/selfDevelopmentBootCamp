package src.finalDSARevisionScaler.basics.twoDArrays;

/**
 * Q55) Sprial Matrix InterviewBit question
 */
public class SpiralMatrix {

    public int[] spiralOrder( int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int ans[] = new int[n * m];


        if(A.length == 1){
            return A[0];
        }
        int topRow = 0,bottomRow = n-1, leftCol = 0, rightCol = m-1;
        int idx = 0;
        for(int i =0; i < n  ; i++){

            for(int j = leftCol; j <= rightCol && idx < n*m;j++){
                ans[idx++] = A[topRow][j];
            }
            topRow++;

            for(int k = topRow;k <= bottomRow && idx < n*m;k++){
                ans[idx++] = A[k][rightCol];
            }
            rightCol--;

            for(int l = rightCol; l >= leftCol && idx < n*m;l--){
                ans[idx++] = A[bottomRow][l];
            }
            bottomRow--;

            for(int p = bottomRow; p>= topRow && idx < n*m;p--){
                ans[idx] = A[p][leftCol];
                idx++;
            }
            leftCol++;

        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] A = {{227, 141, 263, 177},
                {4185, 273, 45, 364},
                {110, 122, 362, 267},
                {337, 361, 143, 108},
                {223, 177, 167, 201},
                {57, 159, 69, 289},
                {184, 12, 295, 302},
                {355, 343, 48, 311},
                {120, 258, 189, 260},
                {52, 323, 187, 98},
                {322, 236, 56, 155}};

        int[][] B = {{133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
                {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
                {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}};

        SpiralMatrix sm = new SpiralMatrix();

        int ans[]= sm.spiralOrder(B);

        for (int i : ans) {
            System.out.print(i + " ,");
        }
    }
}
