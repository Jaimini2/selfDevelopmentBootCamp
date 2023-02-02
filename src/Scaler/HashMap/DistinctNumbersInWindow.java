package Scaler.HashMap;

import java.util.HashMap;

public class DistinctNumbersInWindow {

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer, Integer> hm = new HashMap();
        int[] outputArray = new int[A.length - B + 1];
        for (int i = 0; i < B; i++) {
            if (hm.containsKey(A[i])) {
                int val = hm.get(A[i]);
                hm.put(A[i], val + 1);
            } else {
                hm.put(A[i], 1);
            }
        }
        outputArray[0] = hm.size();
        int j = 1;
        int e = B;
        while (e < A.length) {
            // cosnidering incoming element
            if (hm.containsKey(A[e])) {
                int val = hm.get(A[e]);
                hm.put(A[e], val + 1);
            } else {
                hm.put(A[e], 1);
            }

            int val = hm.get(A[j - 1]);
            hm.put(A[j - 1], val - 1);
            //consider outgoing element
            if (hm.get(A[j - 1]) == 0) {
                hm.remove(A[j - 1]);
            }
            outputArray[j] = hm.size();
            j++;
            e++;
        }

        return outputArray;
    }

    public static void displaySortedArray(int[] intArray){
        for (int i =0 ; i < intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 1, 3, 4, 3 };
        int B = 3;

        int c[] = dNums(A,B);

        displaySortedArray(c);
    }


}
