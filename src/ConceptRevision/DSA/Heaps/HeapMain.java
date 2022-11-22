package ConceptRevision.DSA.Heaps;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);



        heap.printHeap();

        heap.delete(1);


      //  heap.delete(6);

        System.out.println("Heap after deleting the values ................");

        heap.printHeap();

        System.out.println();
        System.out.println("Peek of Heap is " +heap.peek());
        heap.delete(1);

    }
}
