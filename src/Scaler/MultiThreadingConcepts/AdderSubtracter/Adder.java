package src.Scaler.MultiThreadingConcepts.AdderSubtracter;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    Value v;
    Lock rLock;
   public Adder(Value v,Lock rLock){
        this.v = v;
       this.rLock = rLock;
    }

    @Override
    public Void call() throws Exception {
       for(int i =0 ; i <= 50000;i++) {
               v.incrementBy();
       }
       return null;
    }
}
