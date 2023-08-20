package Scaler.Queue;

import ConceptRevision.DSA.Stack.MaxAndMin;

public class ReverseElementsOfQueue {
    int[] queue ;
    int front = -1;
    int rear = -1;
    int size = 0;
    public int[] solve(int[] A, int B) {
        queue = new int[A.length];
        for(int i = B-1; i >= 0;i--){
            enqueue(A[i]);
        }

        int i = 0;
        while(!isEmpty()){
            A[i] =  dequeue();
            i++;
        }

        return A;
    }

    void enqueue(int data){
        if(size == queue.length){
            return;
        }
        rear =(rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }

    int dequeue(){
        if(size == 0){
            return -1;
        }
       // int dataToBeRemoved = queue[front];
        front = (front+1) % queue.length;
        size--;
        return queue[front];
    }

    int front(){
        if(size == 0){
            return -1;
        }
        return queue[(front + 1)%queue.length];
    }

    boolean isEmpty(){
        return front() == -1;
    }

    public  void displaySortedArray(int[] intArray){
        for (int i =0 ; i < intArray.length;i++){
            System.out.print(intArray[i] + " ,");

        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] A = {1, 2, 3, 4, 5};
        int B = 3;

        ReverseElementsOfQueue rq = new ReverseElementsOfQueue();
     int[] C =   rq.solve(A,B);
        rq.displaySortedArray(C);

    }

}
