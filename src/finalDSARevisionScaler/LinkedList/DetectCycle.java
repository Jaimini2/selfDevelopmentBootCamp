package src.finalDSARevisionScaler.LinkedList;

/**
 * Q45 Remove loop from linked List
 */
public class DetectCycle {

    public LinkedNode solve(LinkedNode A){

        LinkedNode slow = A;
        LinkedNode fast = A;

        while (slow != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        slow = A;
        LinkedNode prev = null;

        while (slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;

        return A;

    }
}
