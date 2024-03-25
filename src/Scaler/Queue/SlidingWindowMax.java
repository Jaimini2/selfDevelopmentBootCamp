package src.Scaler.Queue;

import src.ConceptRevision.CollectionFramework.ArrayListImpl;

import java.util.*;

public class SlidingWindowMax {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n=A.size();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();


        for(int i=0;i<n;i++){
            while (!maxQueue.isEmpty() && A.get(i) >= A.get(maxQueue.peekLast())) {
                maxQueue.pollLast();
            }

            if (!maxQueue.isEmpty() && maxQueue.peekFirst()  <= i - B) {
                maxQueue.pollFirst();
            }
            maxQueue.offerLast(i);

            if(i>=B-1){
                result.add(A.get(maxQueue.peekFirst()));

            }
        }
        return result;

    }

    public static void main(String[] args) {
        SlidingWindowMax slm = new SlidingWindowMax();
        List<Integer> A = Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7);
        int B = 3;

        ArrayList<Integer> ans = slm.slidingMaximum(A,B);

        ArrayListImpl.displayTheGivenList(ans);

    }
}
