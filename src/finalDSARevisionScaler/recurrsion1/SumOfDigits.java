package src.finalDSARevisionScaler.recurrsion1;

/**
 * Q6)Sum of digits using Recurrsion
 */
public class SumOfDigits {
    int ans = 0;
    public void sumOfDigits(int A){
        if(A < 1){
            return;
        }

        int rem = A%10;
        int num = A/10;
        ans = ans + rem ;
        sumOfDigits(num);

    }

    public static void main(String[] args) {
        SumOfDigits sd = new SumOfDigits();
        sd.sumOfDigits(4634);
        System.out.println(sd.ans);

    }
}
