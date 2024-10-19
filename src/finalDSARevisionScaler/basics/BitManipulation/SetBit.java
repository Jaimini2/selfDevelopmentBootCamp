package src.finalDSARevisionScaler.basics.BitManipulation;

public class SetBit {

    public int solve(int A, int B) {
        System.out.println((1 << A) | (1<<B));
        return (1 << A) | (1 << B);
    }

    /**
     * unset X bits from right
     * @param args
     */
    public long unset(long A, int B){
        A = A>>B;
        System.out.println(A<<B);

        return A;
    }

    public static void main(String[] args) {
        SetBit sb = new SetBit();
      //  sb.solve(3,5);

        sb.unset(93,4);
    }
}


