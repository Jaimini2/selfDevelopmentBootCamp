package src.finalDSARevisionScaler.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 */
public class LargestNumber {
    public String largestNumber(final int[] A) {
        String Ar[] = new String[A.length];

        for(int i =0 ; i < A.length;i++){
            Ar[i]= Integer.toString(A[i]);
        }

        Arrays.sort(Ar, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a1 = o1 + o2;
                String a2 = o2 + o1;
               return a2.compareTo(a1);
            }
        });

        if(Ar[0].equals(0)){
            return "0";
        }

        String largestNo = "";

        for(int i =0; i < Ar.length;i++){
            largestNo += Ar[i];
        }

        return largestNo;
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int A [] = {3, 30, 34, 5, 9};

        System.out.println(ln.largestNumber(A));
    }
}
