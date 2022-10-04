package ConceptRevision.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Deadlock example .....
 * In this example we eliminated the deadlock by removing the cyclic dependency of thw given two threads
 *
 */
public class DeadLock {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadLock d = new DeadLock();

        new Thread(d ::worker1,"worker1").start();
        new Thread(d::worker2,"worker2").start();
    }

    public void worker1(){
        lock1.lock();
        System.out.println("Worker 1 acquiring the lock1.......");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker 1 acquiring the lock2............");

        lock1.unlock();
        lock2.unlock();
    }
    public void worker2(){
        lock1.lock();
        System.out.println("Worker 2 acquiring the lock 1.......");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker 2 acquiring the lock 2............");

        lock1.unlock();
        lock2.unlock();
    }
}
