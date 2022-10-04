package InterviewPreparation;

import java.io.*;
import java.util.*;


public class HackerEarth1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] arr_A = br.readLine().split(" ");
        for (int i_A = 0; i_A < N; i_A++) {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int out_ = Solve(N, A);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static int Solve(int N, int[] A) {
        // Write your code here
        Arrays.sort(A);
        int[] sortedArray = A;
        int difference = sortedArray[0];
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == 0) {
                return sortedArray[i];
            } else if (checkIfNegativeNumber(sortedArray[i])) {
                if (difference < 0 - sortedArray[i]) {
                    difference = 0 - sortedArray[i];
                }
            } else {
                if (difference > sortedArray[i] - 0) {
                    difference = sortedArray[i] - 0;
                }
            }

        }
        return difference;

    }

    public static boolean checkIfNegativeNumber(int n) {
        return n < 0;
    }
}
