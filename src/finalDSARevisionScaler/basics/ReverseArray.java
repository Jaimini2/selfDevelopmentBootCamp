package src.finalDSARevisionScaler.basics;

public class ReverseArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i < A.length -1- i) {
                swap(A, i, A.length-1 - i);
            } else {
                break;
            }

        }

        return A;

    }

    public void swap(int[] A, int b, int c) {
        int temp = A[b];
        A[b] = A[c];
        A[c] = temp;
    }

    public static void main(String[] args) {
        ReverseArray rr = new ReverseArray();
        int[] a = {1, 2, 3,2,1};


        int[] ans = rr.solve(a);


        for (int i: ans) {
            System.out.print(i + " ");
        }
    }
}


