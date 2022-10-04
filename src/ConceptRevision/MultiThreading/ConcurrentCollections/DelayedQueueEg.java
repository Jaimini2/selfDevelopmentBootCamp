package ConceptRevision.MultiThreading.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueEg {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();

        try {
            //these can be inserted by different threads as well
            queue.put(new DelayedWorker("This is the first message ",1020));
            queue.put(new DelayedWorker("This is the second message ",5000));
            queue.put(new DelayedWorker("This is the third message ",3400));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!queue.isEmpty()){
            try {
                System.out.println(queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class DelayedWorker implements Delayed{

   private  long duration;
   private String message;

   public DelayedWorker(String msg,long dur){
       message = msg;
       duration = System.currentTimeMillis() + dur;
   }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "DelayedWorker{" +
                "duration=" + duration +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
       //this is the method that can compare objects
        if(duration < ((DelayedWorker)other).getDuration())
        return -1;
        if(duration > ((DelayedWorker)other).getDuration())
            return 1;
        return 0;
    }
}