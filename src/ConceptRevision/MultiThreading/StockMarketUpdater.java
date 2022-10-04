package ConceptRevision.MultiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {

    @Override
    public void run(){
        System.out.println("Updating stock market related data from Web ........");
    }
}

 class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

        exec.scheduleAtFixedRate(new StockMarketUpdater(),1000,2000, TimeUnit.MILLISECONDS);
    }
}
