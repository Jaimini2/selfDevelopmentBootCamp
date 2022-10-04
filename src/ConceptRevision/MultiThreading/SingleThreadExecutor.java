package ConceptRevision.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
private int id;

Task(int id){
    this.id = id;
}
    @Override
    public void run() {
        System.out.println("Task with Id : "+id+" is in work - Thread id : "+Thread.currentThread().getName());
        long duration = (long)(Math.random()* 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
public class SingleThreadExecutor {
    public static void main(String[] args) {
        //it is a single thread that will execute task sequentially
        //so one after another
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i =0 ; i < 100 ;i++){
            executorService.execute(new Task(i));
            //here we need to also shutdown the executor , we have not yet shutdown the executor
        }


    }
}
