package  src.ConceptRevision.BasicPrograms.Facotrial;

/*Factorial using Recurrsion*/
public class Factorial2 {
    static int factorial(int num) {
        if (num == 0)
            return 1;
        else
            return num * factorial(num - 1);

    }

    public static void main(String[] args) {
       /* System.out.println("factorial of 4 is " +factorial(4));
        System.out.println("factorial of 6 is " +factorial(6));
        System.out.println("factorial of 7 is " +factorial(7));
        System.out.println("factorial of 5 is " +factorial(5));*/

        for (int i = 0; i <= 10;i++){
            System.out.println("factorial of "+i+ " is "+factorial(i));
        }
    }
}
