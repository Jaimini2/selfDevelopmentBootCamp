package src.finalDSARevisionScaler.basics.BitManipulation;

/**
 * Q29) Strange Equality
 * <p>
 * Given an integer A.
 * Two numbers, X and Y, are defined as follows:
 * <p>
 * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
 * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
 * Find and return the XOR of X and Y.
 * <p>
 * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
 * <p>
 * NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
 */
public class StrangeEquality {

    public int solve(int A) {
        long x = A - 1;
        long y = A + 1;
        long xorX = 0;
        long xorY = 0;

        while (x > 0) {
            if ((x ^ A) == x + A) {
                xorX = x;
                break;
            }
            x--;
        }

        for (long i = y; i < Integer.MAX_VALUE; i++) {
            if ((i ^ A) == i + A) {
                xorY = i;
                break;
            }
        }


        return (int) (xorX ^ xorY);
    }

    public int solveEfficiently(int A) {
        int bit = 0, x = 0;
        // x is equal to the summation of unset bits in A
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }

        //y equals the power of 2 just greater than A
        int y = (1 << bit);

        return x ^ y;
    }

    public static void main(String[] args) {
        StrangeEquality se = new StrangeEquality();

        int ans = se.solveEfficiently(14);
        System.out.println(ans);

        //5
        //0101
        //0010

    }
}
