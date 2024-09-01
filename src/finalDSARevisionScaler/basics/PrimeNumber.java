package src.finalDSARevisionScaler.basics;

public class PrimeNumber {
    public int solve(int A) {

        int ans = 0;
        if (A == 1) {
            return 1;
        }
        for (int i = 2; i <= A; i++) {

            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    boolean isPrime(int input) {
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumber pm = new PrimeNumber();
        System.out.println(pm.solve(10));
    }
}

