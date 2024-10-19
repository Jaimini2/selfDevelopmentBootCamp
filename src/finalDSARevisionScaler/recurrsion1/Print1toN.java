package src.finalDSARevisionScaler.recurrsion1;

/**
 * Q4)recurrsion basics 1
 */
public class Print1toN {

    public void printN(int n){

        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n + " ");
        printN(n-1);

    }

    public static void main(String[] args) {

        Print1toN pr = new Print1toN();
        pr.printN(5);
    }
}
