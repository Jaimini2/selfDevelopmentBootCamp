package Scaler.Heaps;

import ConceptRevision.MultiThreading.ConcurrentCollections.PriorityQueueEg;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public int nChoc(int A, int[] B){

        PriorityQueue pq = new PriorityQueue<Integer>((a, b) ->{
            return a - b;
        });

        //performing insert in pq
        for (int i = 0 ; i < B.length;i++){
            pq.add(B[i]);
        }

        //getting max chocolates
        long ans = 0;
        while (A > 0  && !pq.isEmpty()){
            long removedNumber = (long) pq.poll();
            ans = ans + removedNumber;
            long numToBeInserted = removedNumber/2;
            pq.add(numToBeInserted);
            A--;
        }

        return (int)ans % (1000 * 1000 * 1000 + 7);

    }
}
