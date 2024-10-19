package src.finalDSARevisionScaler.recurrsion1;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
 * and each occurrence of 1 with 10.
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 */
public class KthSymbol {

    public int solve(int A, int B) {

        if(A == 1){
            return 0;
        }

        int parent = solve(A-1,B/2);
        boolean isOdd = B%2==1;

        if(parent == 1){
            if(isOdd == true){
                return 0;
            }else {
                return 1;
            }
        }
        else{
            if(isOdd==true)
                return 1;
            else
                return 0;
        }

    }

    public static void main(String[] args) {

    }
}
