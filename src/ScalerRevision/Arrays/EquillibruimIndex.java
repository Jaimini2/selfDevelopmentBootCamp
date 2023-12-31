package ScalerRevision.Arrays;

/**
 * Create prefix array for this in order to achieve better time complexity
 */
public class EquillibruimIndex {
    public int solve(int[] A) {
        int[] pfArr = new int[A.length];

        pfArr[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfArr[i] = pfArr[i - 1] + A[i];
        }

        for (int i = 1; i < pfArr.length; i++) {
            if (i == 0) {
                if (0 == pfArr[pfArr.length - 1] - pfArr[0]) {
                    return 0;
                }
            } else if (pfArr[i - 1] == pfArr[A.length - 1] - pfArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {-7, 1, 5, 2, -4, 3, 0};

        EquillibruimIndex eq = new EquillibruimIndex();

        System.out.println(eq.solve(A));

    }
}
