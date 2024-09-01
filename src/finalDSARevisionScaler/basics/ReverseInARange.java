package src.finalDSARevisionScaler.basics;

public class ReverseInARange {
    public int[] solve(int[] A, int B, int C) {

        for(int i = B; i <= C;i++){
            swap(A,i,C);
            C--;
        }


        return A;

    }

    public void swap(int[] a,int i, int j){
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void main(String[] args) {
        ReverseInARange rr = new ReverseInARange();
    int[] a = {1, 2, 3, 4,5,6,7,8,9,23,42,56,32};
    int b = 2;
    int c = 11;

       int[] ans = rr.solve(a,b,c);

        for (int i: ans) {
            System.out.print(i + " ");
        }
    }

}
