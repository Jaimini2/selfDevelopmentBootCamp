package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q18)Continuous Sum Query
 * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
 * When the devotees come to the temple, they donate some amount of coins to these beggars.
 * Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
 * Given the amount P donated by each devotee to the beggars ranging from L to R index,
 * where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
 */
public class ContinuousSumQuery {

    public int[] solve(int A, int[][]B){
        int[] arr = new int[A];

        for(int i =1;i<=B.length;i++){
            int l = B[i-1][0];
            int r = B[i-1][1];

            arr[l-1] += B[i-1][2];

            if(r < A){
                arr[r] = arr[r]-B[i-1][2];
            }
        }

        for(int i = 1; i < arr.length;i++){
            arr[i] = arr[i-1]+arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int A =  5;
        int B[][] = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        ContinuousSumQuery cs = new ContinuousSumQuery();

        int[] ans = cs.solve(A,B);

        for (int i: ans
             ) {
            System.out.print(i + " ");
        }
    }
}
