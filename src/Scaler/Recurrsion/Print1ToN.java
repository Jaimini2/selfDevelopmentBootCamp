package Scaler.Recurrsion;

public class Print1ToN {
    public static void solve(int A) {
        printFunc(A);

    }

     static void printFunc(int A) {

        if(A==0){
            return;
        }
         printFunc(A-1);
         //System.out.println(A);
         System.out.print( A + " ");
    }

    public static void main(String[] args) {
       solve(9);
    }
}
