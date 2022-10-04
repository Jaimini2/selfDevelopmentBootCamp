package ConceptRevision.MultiThreading;

public class DaemonThread  implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10000);
                System.out.println("Daemon thread is Running .......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WorkerThread implements Runnable{

    @Override
    public void run() {
        for (int i =0; i < 5 ; i ++){
            try {
                Thread.sleep(10000);
                System.out.println("This is a worked thread ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class MainThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonThread());
        Thread t2 = new Thread(new WorkerThread());

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}
