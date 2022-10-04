package ConceptRevision.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    /**
     * Using ReentrantLocks
     * It has the same behaviour as the synchronized approach
     * Ofcourse it has some additional approach
     * new ReentrantLock(boolean fairness)
     *  If the fairness parameter is set to be TRUE then the longest waiting thread will get the Lock
     *
     *  If the fairness parameter is false then there is no access order
     *
     *  IMPORTANT : a good approach is to use try-catch-finally block
     *  when doing the critical sections and call unlock in the finally block
     *
     */

    private static int counter = 0;

    private static Lock lock = new ReentrantLock();
    private static void increment(){
        lock.lock();
        try{
            for (int i = 0 ; i < 10000;i++){
                counter++;
            }
        }finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter is "+counter);
    }
}
