package ConceptRevision.BasicPrograms.Facotrial;

/*Facotiral program without using Recurrsion
* Factorial is the product of all positive Descending integers*/
public class Factorial1 {


    public static void main(String[] args) {

        int num = 9;
        int temp = num;

        int fact = 1;

        while(num > 0){
            fact = num * fact;
            num--;
        }
        System.out.println("Factorial of a " +temp+ " is "+fact);


    }
}
