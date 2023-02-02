package Scaler.InterviewProblem;

public class JosephusProblem {
    public static int solve(int A) {
        int closestPowerOf2 = 0;
        int i = 0;
        while (A >= Math.pow(2, i)) {
            closestPowerOf2 =(int)Math.pow(2, i);
            i++;
        }
        int difference = A - closestPowerOf2;

        int remainingPerson = 2 * difference + 1;
        Integer.bitCount(1);
        return remainingPerson;

    }

    public static void main(String[] args) {
        System.out.println(solve(9));
    }

}
