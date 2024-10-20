package ConceptRevision.MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    private List<Integer> list = new ArrayList<Integer>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;
    public void producer() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("Waiting for Removing items ");
                    value = 0;
                    lock.wait();
                }
                else{
                    System.out.println("Adding value : "+value);
                    list.add(value);
                    value++;
                    //we can call the notify  - because the other thread will be notified
//                    only when it is in waiting state
                   lock.notify();
                }
                Thread.sleep(500);
            }

        }
    }

    public void consumer()throws InterruptedException{
        synchronized(lock){
            while(true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("Waiting for adding items ... ");
                    lock.wait();
                }
                else{
                    System.out.println("Removing  value : "+list.remove(list.size() - 1));
                    lock.notify();
                    //does other operations inside the while loop before calling the notify()
                }
                Thread.sleep(500);
            }

        }
    }

    public static void main(String[] args) {
        Processor processor = new Processor();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run(){
                    try{
                        processor.producer();
                    }catch(InterruptedException e) {
                       e.printStackTrace();
                    }

                }
            });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    processor.consumer();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();

    }
}


