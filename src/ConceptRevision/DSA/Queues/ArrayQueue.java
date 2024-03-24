package  src.ConceptRevision.DSA.Queues;

import src.ConceptRevision.DSA.Stack.ArrayStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] empQueue;
    private int front;
    private int back;

    ArrayQueue(int capacity){
        empQueue = new Employee[capacity];
    }

    public void add(Employee emp){
        if(size() == empQueue.length-1){
            int numItems = size();
            Employee[] newArray = new Employee[2 * empQueue.length];
            System.arraycopy(empQueue,front,newArray,0,empQueue.length-front);
            System.arraycopy(empQueue,0,newArray,empQueue.length-front,back);
            empQueue = newArray;

            front = 0;
            back = numItems;
        }


        if(back < empQueue.length-1){
            empQueue[back] = emp;
            back++;
        }else{
            back = 0;
        }
    }

    public Employee remove(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Employee emp = empQueue[front];
        empQueue[front] = null;
        front++;

        if(size() == 0){
            front = 0;
            back = 0;
        }
        else if(front == empQueue.length){
            front = 0;
        }
        return  emp;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        if(front <= back){
            return back - front;
        }else{
            return back - front + empQueue.length;
        }

    }

    public Employee peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return empQueue[front];
    }

    public void printQueue(){
        if(back > front){
            for(int i = front; i < back;i++){
                System.out.println(empQueue[i]);
            }
        }else{
            for (int i = front ; i < empQueue.length;i++){
                System.out.println(empQueue[i]);
            }
            for (int i = 0;i < back;i++){
                System.out.println(empQueue[i]);
            }
        }

    }
}
