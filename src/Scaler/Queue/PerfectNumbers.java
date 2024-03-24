package src.Scaler.Queue;

import java.util.ArrayList;

public class PerfectNumbers {
    ArrayList<Long> queue = new ArrayList();
    int front = -1;
    int rear = -1;
    public String solve(int A) {
        while(queue.size() < A){
            if(rear == -1){
               enqueue(1);
                enqueue(2);
            }
            else{
                String val1 = String.valueOf(front()) + "1";
                val1.trim();
               long num = Long.parseLong(val1);
               enqueue(num);

                if(queue.size() < A){
                    String val2 = String.valueOf(front()) + "2";
                    long i = Long.parseLong(val2);
                    enqueue(i);
                }

                front = (front + 1)%queue.size();

            }
        }

        StringBuilder val = new StringBuilder(String.valueOf(queue.get(A - 1)));
        StringBuilder revval= new StringBuilder(val) ;
        revval.reverse();
       return val.append(revval).toString();
    }

    void enqueue(long data){
        rear  = (rear + 1);
        queue.add(rear,data);
    }

    long dequeue(){
        if(queue.size() == 0){
            return -1;
        }
        front = (front + 1)%queue.size();
        return queue.remove(front);
    }

    long front(){
        if(queue.size()==0){
            return -1;
        }

        return queue.get(front+1);
    }

    public static void main(String[] args) {
        PerfectNumbers pn = new PerfectNumbers();
       String ans = pn.solve(100000);
        System.out.println(ans);
        StringBuilder strb = new StringBuilder();


    }

}

