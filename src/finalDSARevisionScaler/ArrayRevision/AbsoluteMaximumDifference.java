package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q20)You are given an array of N integers, A1, A2, .... AN.
 *
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as
 * |A[i] - A[j]| + |i - j|,
 * where |x| denotes absolute value of x.
 */
public class AbsoluteMaximumDifference {

    public int maxArr(int [] A){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int ans = 0;
        for(int i =0 ; i < A.length;i++){

            int x = A[i]-i;
            max1 = Math.max(max1,x);
            min1 = Math.min(min1,x);

            int y = A[i]+i;
            max2 = Math.max(max2,y);
            min2 = Math.min(min2,y);
        }

      return   ans = Math.max(max1-min1,max2-min2);
    }
    public static void main(String[] args) {
        AbsoluteMaximumDifference amd = new AbsoluteMaximumDifference();

        int ans = amd.maxArr(new int[]{1, 3, -1});
        System.out.println(ans);
    }
}
