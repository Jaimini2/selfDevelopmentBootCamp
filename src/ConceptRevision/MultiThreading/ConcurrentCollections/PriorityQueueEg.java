package ConceptRevision.MultiThreading.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 * it uses the same ordering rules as the java.util.PriorityQueue class
 * and we have to implement the comparable interface
 * <p>
 * it determines what will be the order in the queue
 * The priority will be same if compare()==0 case
 * - no null items are allowed !!!
 */

class FirstPlayer implements Runnable {

    private BlockingQueue<Person> queue;

    FirstPlayer(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(new Person(29,"Jaimini"));
            queue.put(new Person(30,"Narayan"));
            queue.put(new Person(44,"Jimmi Bhai"));
            queue.put(new Person(56,"Mummy"));
            Thread.sleep(2000);
            queue.put(new Person(61,"Papa"));
            Thread.sleep(2000);
            queue.put(new Person(27,"Amoli"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class SecondPlayer implements Runnable{

    private BlockingQueue<Person> queue;

    SecondPlayer(BlockingQueue<Person>queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            Thread.sleep(2000);
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class PriorityQueueEg {

    public static void main(String[] args) {
        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();

        FirstPlayer fp = new FirstPlayer(queue);
        SecondPlayer sp = new SecondPlayer(queue);

        new Thread(fp).start();
        new Thread(sp).start();
    }

}
