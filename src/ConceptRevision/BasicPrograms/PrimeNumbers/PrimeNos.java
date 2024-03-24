package  src.ConceptRevision.BasicPrograms.PrimeNumbers;

public class PrimeNos {

    static void isPrimeNumber(int num){
        boolean flag = true;
        if(num == 1 || num == 0){
            System.out.println(num + " is not a prime number ");
        }
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                System.out.println(num + " It is not a prime number");
                flag = false;
                break;
            }else{
                i++;
            }
        }if(flag){
            System.out.println(num + " It is a prime number");
        }

    }

    public static void main(String[] args) {
        System.out.println("Printing Prime Numbers >>>>>");
        int num = 79;
        isPrimeNumber(num);

    }
}
