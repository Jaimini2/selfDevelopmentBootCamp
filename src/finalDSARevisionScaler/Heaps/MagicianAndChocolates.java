package src.finalDSARevisionScaler.Heaps;

import java.util.PriorityQueue;

/**
 * Q59)Magician and Chocolates
 * Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
 * In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
 * Find the maximum number of chocolates that the kid can eat in A units of time.
 *
 * NOTE:
 *
 * floor() function returns the largest integer less than or equal to a given number.
 * Return your answer modulo 109+7
 */
public class MagicianAndChocolates {

    public int nChoc(int B[],int A){

        long ans = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });

        for (int i =0 ; i < B.length;i++){
            pq.add(B[i]);
        }

        for (int i =0; i < A;i++){
            int element = pq.poll();

            ans = (ans%mod  + element%mod)% mod;
            int newElement = (int)Math.floor(element/2);
            pq.add(newElement);
        }

        return (int)ans%mod;
    }

    public static void main(String[] args) {
    MagicianAndChocolates mc = new MagicianAndChocolates();
    int  A[] = {2, 4, 6, 8, 10};
    int B = 5;
    int ans = mc.nChoc(A,B);
        System.out.println(ans);

    }
}
