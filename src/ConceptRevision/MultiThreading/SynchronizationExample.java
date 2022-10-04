package ConceptRevision.MultiThreading;

public class SynchronizationExample {
    static int counter = 0;
    static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    //we are making sure that this method is only executed by a single thread at a given time
    //usually it is not a good practice to use synchronized keyword , better to use a synchronized
    //blocks
    static  void  increment(){
        //class level locking
        //rule of thumb : We synchronized blocks that are 100% necessary
        synchronized (lock1){
            counter++;
        }
    }

    public static synchronized void increment2(){
        synchronized (lock2){
            counter2++;
        }
    }

    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment2();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        //t2.join();

    }


    public static void main(String[] args) throws InterruptedException {
        process();
        System.out.println("Counter value is "+counter);
        System.out.println("Counter 2  value is "+counter2);
    }
}
