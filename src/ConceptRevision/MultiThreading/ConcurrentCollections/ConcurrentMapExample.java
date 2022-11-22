package ConceptRevision.MultiThreading.ConcurrentCollections;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable{

    private ConcurrentMap<String,Integer>map;

    public MapFirstWorker(ConcurrentMap<String,Integer>map){
        this.map = map;
    }

    @Override
    public void run() {
        try{
            map.put("B",12);
            Thread.sleep(2000);
            map.put("Z",25);
            map.put("x",15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MapSecondWorker implements Runnable{

    private ConcurrentMap<String,Integer>map;

    public MapSecondWorker(ConcurrentMap<String,Integer>map){
        this.map = map;
    }

    @Override
    public void run() {
        try{
            System.out.println(map.get("B"));
            Thread.sleep(5000);
            System.out.println(map.get("Z"));
            System.out.println(map.get("x"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
public class ConcurrentMapExample {
    public static void main(String[] args) {

        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>();
        MapFirstWorker firstWorker = new MapFirstWorker(map);
        MapSecondWorker secondWorker = new MapSecondWorker(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();

    }
}
