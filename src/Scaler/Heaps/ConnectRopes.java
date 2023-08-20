package Scaler.Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }
        while (pq.size() >= 2) {
            int rope1 = 0;
            int rope2 = 0;
            int sum = 0;
            rope1 = pq.poll();
            rope2 = pq.poll();
            sum = rope1 + rope2;
            pq.add(sum);
            ans = ans + sum;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        ConnectRopes cr = new ConnectRopes();

        int A[] = {16,7,3,5,9,8,6,15};

        int ans =  cr.solve(A);
        System.out.println(ans);
    }

}
