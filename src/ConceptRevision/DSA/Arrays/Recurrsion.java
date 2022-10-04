package ConceptRevision.DSA.Arrays;

/**
 * Recurrsion to calculate a factorial of a number
 *
 */
public class Recurrsion {
    public static int iterativeFactorial(int num){
        if(num == 0)
            return 1;
        int fact = 1;
        for(int i = num ; i > 0;i--){
            fact = i*fact;
        }
        return fact;

    }

    public static int recurrsiveFactorial(int num){
        if(num == 0)return 1;
        return num * recurrsiveFactorial(num - 1);
    }
    public static void main(String[] args) {

        System.out.println(iterativeFactorial(4));

        System.out.println("Recurrsive factorial is "+ recurrsiveFactorial(5));

        System.out.println("Recurrsive factorial is "+ recurrsiveFactorial(6));

    }
}
