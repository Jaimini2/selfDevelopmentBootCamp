package src.Scaler.MultiThreadingConcepts.MultiThreadMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class Sorter implements Callable<List<Integer>>{

    private List<Integer> arrayToSort ;
    private ExecutorService ex;


    Sorter(List<Integer> arr, ExecutorService ex){
        this.arrayToSort = arr;
        this.ex = ex;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int size = arrayToSort.size();

        int mid = size/2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

       for(int i = 0 ; i < mid;i++){
           leftArray.add(arrayToSort.get(i));
       }

       for(int i = mid ; i < arrayToSort.size();i++){
           rightArray.add(arrayToSort.get(i));
        }

        Sorter leftArraySorter = new Sorter(leftArray,ex);
        Sorter rightArraySorter = new Sorter(rightArray,ex);

        Future<List<Integer>> leftSortedArrayFuture = ex.submit(leftArraySorter);
        Future<List<Integer>> rightSortedArrayFuture = ex.submit(rightArraySorter);

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        //to merge wait for both of them

        int i =0 ;
        int j =0;

        List<Integer> sortedArray = new ArrayList<>();

        while (i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) <= rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i+=1;
            }else {
                sortedArray.add(rightSortedArray.get(j));
                j+=1;
            }
        }

        while (i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i+=1;
        }

        while (j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j+=1;
        }

        return sortedArray;
    }
}