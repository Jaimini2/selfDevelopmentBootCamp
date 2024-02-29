package src.Scaler.MultiThreadingConcepts.MultiThreadMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello world");
        List<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(1);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        arr.add(9);
        arr.add(7);
        arr.add(5);

        ExecutorService ex = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arr,ex);

        Future<List<Integer>> futureSortedArray = ex.submit(sorter);
        List<Integer> finalAns = futureSortedArray.get();

        for (int i : finalAns){
            System.out.println(i);
        }

    }

}