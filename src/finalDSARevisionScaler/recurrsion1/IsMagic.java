package src.finalDSARevisionScaler.recurrsion1;

/**
 * Q7) Given a number A, check if it is a magic number or not.
 * A number is said to be a magic number if the sum of its digits is calculated till a single digit
 * recursively by adding the sum of the digits after every addition.
 * If the single digit comes out to be 1, then the number is a magic number.
 */
public class IsMagic {
    public int solve(int A){

        int sumOfDigits = getSum(A,0);
      return sumOfDigits == 1 ? 1 : 0;
    }

    private int getSum(int A, int rem) {
       if(A == 0){
            if(rem >=  10){
                return getSum(rem,0);
            }
            return rem;
        }

        rem = rem + A%10;
        return getSum(A/10,rem);
    }

    public static void main(String[] args) {
        IsMagic im = new IsMagic();

        int ans = im.solve(83557);
        System.out.println(ans);


    }
}
