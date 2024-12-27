package src.finalDSARevisionScaler.Heaps;

public class HeapMain {

    public static void main(String[] args) {
        HeapMain hm = new HeapMain();
        int n = 7;
        Heap h = new Heap(7);

        h.insertInHeap(43);
        h.insertInHeap(21);
        h.insertInHeap(3);
        h.insertInHeap(56);
        h.insertInHeap(1);

        h.displayHeap();


    }
}
