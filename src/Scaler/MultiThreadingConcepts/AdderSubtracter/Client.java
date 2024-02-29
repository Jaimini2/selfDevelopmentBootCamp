package src.Scaler.MultiThreadingConcepts.AdderSubtracter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value(1);

        Lock rlock = new ReentrantLock();

        Adder ad = new Adder(v,rlock);

        Subtractor sb = new Subtractor(v,rlock);

        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Void> futureAns = ex.submit(ad);
        Future<Void> futureSub = ex.submit(sb);

        futureAns.get();
        futureSub.get();

        System.out.println(v.val);
    }
}
