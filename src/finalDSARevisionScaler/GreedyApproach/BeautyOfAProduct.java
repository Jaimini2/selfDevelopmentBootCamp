package src.finalDSARevisionScaler.GreedyApproach;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Q61) Beauty of a Product
 * There is a limited time sale going on.
 * A[i] is the sale end time for ith toy.
 * B[i] is the Beauty of a toy
 * Time starts from t = 0 & it takes 1 unit of time to buy each toy & toy can be bought only if T<A[i]
 * Buy toys such that sum of beauty is maximized.
 *
 *
 */
public class BeautyOfAProduct {

    class Pair{
        int x;
        int y;

        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solve(int[] A,int[] B){

        int maxBeauty = 0;
       Pair[] pairs = new Pair[A.length];

       for (int i =0 ; i < A.length;i++){
           pairs[i] = new Pair(A[i],B[i]);
       }

        Arrays.sort(pairs,(a,b)->{

            if(a.x == b.x){
                return a.y - b.y;
            }
           return a.x - b.x;
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.y-b.y;
        });

       for (int i =0 ; i < pairs.length;i++){
           if(i <= pairs[i].x){
               pq.add(pairs[i]);
           }else{
               if(!pq.isEmpty() && pq.peek().y < B[i]){
                   pq.poll();
                   pq.add(pairs[i]);
               }
           }
       }

       while (!pq.isEmpty()){
           maxBeauty +=pq.poll().y;
       }

       return maxBeauty;
    }


    public static void main(String[] args) {

        int A[] = {1, 3, 2, 3, 3};
        int B[] = {5, 6, 1, 3, 9};

        BeautyOfAProduct bp = new BeautyOfAProduct();
        int ans = bp.solve(A,B);
        System.out.println(ans);

    }
}
