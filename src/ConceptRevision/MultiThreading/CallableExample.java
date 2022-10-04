package ConceptRevision.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample implements Callable<String> {

    private int id;

    CallableExample(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "id "+ id;
    }
}

class CallableMain {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List <Future<String>> list = new ArrayList<>();
        for (int i =0 ; i < 5;i++){
             Future<String> futureobj = service.submit(new CallableExample(i));
             list.add(futureobj);
        }

        for (Future<String> obj : list){
            try {
                System.out.println(obj.get());
            } catch (InterruptedException  | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}