package ConceptRevision.MultiThreading;

public class VolatileExample implements Runnable{

    private volatile boolean  terminated;
    @Override
    public void run() {
        while (!terminated){
            System.out.println("Working class is Running ..........");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }
}

class Volatile{
    public static void main(String[] args) {
        VolatileExample vm = new VolatileExample();

        Thread t1 = new Thread(vm);

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vm.setTerminated(true);
        System.out.println("Algoritm is terminated .....");
    }
}
