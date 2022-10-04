package ConceptRevision.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable{

    private int id;

    Work(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("Task with work Id : "+id+ " is in work - thread id : " +Thread.currentThread().getId());
        long duration = (long)(Math.random()*5);
        try{
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 50;i++){
            exec.execute(new Work(i+1));
        }

        //we prevent the executor to execute any further tasks
        exec.shutdown();

        //terminate actual (running) tasks
        try{
            if(!exec.awaitTermination(3000,TimeUnit.MILLISECONDS)){
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            exec.shutdown();
        }
    }
}
