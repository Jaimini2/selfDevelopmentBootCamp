package src.finalDSARevisionScaler.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Q44)Find the maximum value of every sub array of size k
 * Use deque for this purpose
 */
public class MaxofSubArrayofSizeK {

    public int[] solve(int[] A, int B) {

        Deque<Integer> deque = new LinkedList<>();
        int ans[] = new int[A.length-B+1];

        for (int i =0; i < B;i++){
            while (!deque.isEmpty() && A[i] >= deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(A[i]);
        }
        ans[0] = deque.peekFirst();

        int l = 1;
        int r = B;

        while (r < A.length){
            if (!deque.isEmpty() && A[l-1] ==  deque.peekFirst()){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && A[r] > deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(A[r]);
            ans[l] = deque.peekFirst();
            l++;
            r++;
        }

        return ans;
    }


    public static void main(String[] args) {
    int A[] = {268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592, 571, 559, 374, 910, 610, 561, 489, 647, 246,
            355, 313, 158, 922, 557, 36, 430, 983, 913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129,
            952, 159, 250, 546, 508, 540, 948, 429, 174};
    int B = 6;

    MaxofSubArrayofSizeK mx = new MaxofSubArrayofSizeK();

    int ans [] = mx.solve(A,B);

        for (int i : ans) {
            System.out.print(i + " ,");
        }

    }
}
