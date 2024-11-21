package src.finalDSARevisionScaler.LinkedList;

/**
 * Q9) Basic LinkedList Implementation
 */
public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.insert(40);
        l1.insert(50);
        l1.insert(60);

        l1.traverseAndDisplay();

        l1.insert(70);
        l1.displayLines();

        l1.traverseAndDisplay();

        l1.insertAtPosition(5,45);
        l1.displayLines();
        l1.traverseAndDisplay();

        System.out.println(l1.deleteAtPosition(1).data);
        System.out.println(l1.deleteAtPosition(3).data);
        l1.insertAtPosition(3,42);
        l1.insertAtPosition(8,80);
        l1.insertAtPosition(20,90);
        l1.displayLines();
        l1.traverseAndDisplay();
        System.out.println(l1.deleteAtPosition(9).data);
        l1.displayLines();
        l1.traverseAndDisplay();
        l1.displayLines();
        l1.printReverse(l1.head);
    }
}
