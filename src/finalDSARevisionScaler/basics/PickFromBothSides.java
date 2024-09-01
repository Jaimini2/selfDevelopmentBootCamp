package src.finalDSARevisionScaler.basics;

/**
 * It is a carry forward problem
 *
 * You are given an integer array A of size N.
 *
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
 *
 * Find and return the maximum possible sum of the B elements that were removed after the B operations.
 *
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 *
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 */
public class PickFromBothSides {
    public int solve(int[] A, int B) {
        int n = A.length;
        int result = 0;

        for (int i = 0; i < B; i++) {
            result += A[i];
        }

        int sum = result;
        for (int i = 0; i < B; i++) {
            sum -= A[B - 1 - i];
            sum += A[n - 1 - i];

            result = Math.max(result, sum);
        }
        return result;

    }

    public static void main(String[] args) {

        PickFromBothSides pb = new PickFromBothSides();

        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;

        System.out.println(pb.solve(A,B));
    }
}
