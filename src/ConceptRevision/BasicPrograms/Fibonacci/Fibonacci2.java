package ConceptRevision.BasicPrograms.Fibonacci;

//fibonacci with using recurrsion
public class Fibonacci2 {

    static int n1 =0 , n2 = 1, n3 = 0;

    static void printFibonacci(int count){
        if(count > 0) {
            System.out.println("count is " +count);
            n3 = n1 + n2;
            System.out.print(" " +n3 + " ");
            n1 = n2;
            n2 = n3;
            printFibonacci(count -1);
        }

    }
    public static void main(String[] args) {
        System.out.println("Printing fibonacci using recurrsion ..............");
       int count = 10;
        System.out.print(n1 + " " +n2);
        printFibonacci(count);
    }
}
