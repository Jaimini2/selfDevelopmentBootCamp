package ConceptRevision.MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LiveLock example
 * This is an example to show how the liveLock works
 */
public class LiveLock {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void worker1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 1 acquiring the lock 1 ....");
            System.out.println("Worker 1 tires to get lock 2 ....");

            if (lock2.tryLock()) {
                System.out.println("Worker 1 acquires the Lock 2 ......");
                lock2.unlock();
            } else {
                System.out.println("Worker 1 cannot acquire lock 2 .....");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
            while (true){
                try{
                    lock2.tryLock(50,TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Worker 2 acquires the lock 2");
                System.out.println("Worker 2 tries to acquire the Lock 1");

                if(lock1.tryLock()){
                    System.out.println("Wokrer 2 acquires the lock 1");
                    lock1.unlock();
                }else {
                    System.out.println("Worker 2 can not acquire the lock 1 .....");
                    continue;
                }
                break;
            }
            lock2.unlock();
            lock1.unlock();
    }

    public static void main(String[] args) {
        LiveLock l1 = new LiveLock();

        new Thread(l1::worker1,"Worker1").start();
        new Thread(l1::worker2,"Worker2").start();
    }
}
