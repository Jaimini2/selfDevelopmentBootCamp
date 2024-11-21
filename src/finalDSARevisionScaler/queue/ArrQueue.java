package src.finalDSARevisionScaler.queue;

import src.ConceptRevision.DSA.Queues.ArrayQueue;

/**
 * Q42) Queue Implementation
 */
public class ArrQueue {
    int front;
    int rear;
    int size;

    int[] queue;

    ArrQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(int data) {
        if (size < queue.length) {
            queue[rear++] = data;
            size++;
        }else if(size == queue.length){
            System.out.println("Queue is full");
        }
    }

    public int dequeue(){
        if(size == 0){
            return -1;
        }else{
            size--;
            System.out.println("queue front  is : " +queue[front]);
            return queue[(++front)%queue.length];
        }
    }

    public void printQueue(){
        if(rear > front){
            for (int i =front ; i < rear;i++){
                System.out.print(queue[i] + " ,");
            }
        }
        else{
            for (int i = rear ; i < queue.length;i++){
                System.out.print(queue[i] + " ,");
            }

            for (int i =0 ; i < rear;i++){
                System.out.println(queue[i] + " ,");
            }
        }

    }

    public static void main(String[] args) {
        ArrQueue aq = new ArrQueue(3);

        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);
        aq.dequeue();
        aq.dequeue();
        aq.dequeue();
        System.out.println(aq.dequeue());

        aq.printQueue();
    }

}
