package ConceptRevision.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {
    private Lock locks = new ReentrantLock();
    private Condition condition = locks.newCondition();

    public void produce()throws InterruptedException{
        locks.lock();
        System.out.println("Producer method ......");
        //wait
        condition.await();
        System.out.println("Again the producer method ............");
        locks.unlock();
    }

    public void consume()throws InterruptedException{
        //we want to make sure we start with the producer()
        Thread.sleep(2000);
        locks.lock();
        System.out.println("Consumer method ....");
        Thread.sleep(3000);
        //notify()
        condition.signal();
        locks.unlock();
    }
}

class MainApp{
    public static void main(String[] args) {

        ProducerConsumerWithLocks pcl = new ProducerConsumerWithLocks();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcl.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcl.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}
