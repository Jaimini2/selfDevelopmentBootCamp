package src.finalDSARevisionScaler.Heaps;

public class Heap {

    int size;
    int heap[];

    Heap(int capacity){
        heap = new int[capacity];
    }

    public int getParent(int idx){
        return (idx -1)/2;
    }

    public void insertInHeap(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is Full");
        }else{
            heap[size] = value;
            heapifyAbove(size);
            size++;
        }
    }

    public int deleteInHeap(int idx){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        int elementtoBeDeleted = heap[idx];
        int parent = getParent(idx);
        heap[idx] = heap[size-1];
        if (heap[idx] == 0 || heap[idx] > heap[parent]){
            //it is maintaining the order above so heapify below  since is it minHeap
            heapifyBelow(idx,size-1);
        }else{
            //if heap[idx] < heap[parent] , then it means the order above the index  is not correct ,
            //so do heapifyAbove
            heapifyAbove(idx);
        }

        return elementtoBeDeleted;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index,boolean left){
        return 2*index + (left ? 1 : 2);

    }

    private void heapifyAbove(int index) {
        int newElement = heap[index];
        while (index > 0 && newElement < heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newElement;

    }

    private void heapifyBelow(int parent, int idx) {

        int childToSwap;
        while (parent <= idx) {

            int leftChild = getChild(parent, true);
            int rightChild = getChild(parent, false);

            if (leftChild <= idx) {
                if (rightChild > idx) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] < heap[rightChild] ? leftChild : rightChild;
                }


                if (heap[parent] > heap[childToSwap]) {
                    int value = heap[parent];
                    heap[parent] = heap[childToSwap];
                    heap[childToSwap] = value;
                } else {
                    break;
                }
                parent = childToSwap;
            } else {
                break;
            }
        }
    }


    public boolean isFull(){
       return  heap.length == size;
    }

    public void displayHeap(){
        for (int i =0; i < heap.length;i++){
            System.out.print(heap[i] + " ,");
        }
    }
}
