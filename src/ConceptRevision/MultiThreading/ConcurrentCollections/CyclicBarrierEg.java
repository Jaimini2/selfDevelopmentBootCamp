package ConceptRevision.MultiThreading.ConcurrentCollections;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CBWorker implements Runnable{

    private int id;
    private Random random;
    private CyclicBarrier barrier;

    public CBWorker(int id,CyclicBarrier barrier){
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Thread with ID : " + this.id+" starts the work ....");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            /**
             * when all the threads call await() this is when
             * the barrier is broken
             */
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("After the await ...");
    }
}
public class CyclicBarrierEg {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(" All the tasks have been finished ....");
            }
        });

        for (int i =0 ;i<5;++i){
            service.execute(new CBWorker(i+1,barrier));

        }
        service.shutdown();

    }
}
