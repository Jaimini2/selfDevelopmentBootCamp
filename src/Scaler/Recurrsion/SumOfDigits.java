package Scaler.Recurrsion;

public class SumOfDigits {
    public static int solve(int A) {
        if(A < 10 ){
            return A;
        }

        int num = A/10;
        int rem = A%10;
        return solve(num) + rem;
    }
    public static void main(String[] args) {
            int a = 563;

            int b = solve(a);
        System.out.println(b);
    }
}
