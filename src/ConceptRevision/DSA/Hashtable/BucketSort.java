package ConceptRevision.DSA.Hashtable;

import java.util.*;

public class BucketSort {

    public static void bucketSort(int[] intArray){
        List<Integer> []buckets = new List[11];

        //forgot to right this initiationx
        for (int i =0;i< buckets.length;i++){
            buckets[i] = new Vector<>();
        }

        for (int i =0; i < intArray.length;i++){
            buckets[hash(intArray[i])].add(intArray[i]);
        }

        for (int i=0; i < buckets.length;i++){
            //didn't do it properly , mistake done here as well
            //mistake was i tried to do sort on a single bucket instead of buckets[i]
            Collections.sort(buckets[i]);
        }

        int j =0;
        for (int i =0; i < intArray.length;i++){
            for (int value:buckets[i]){
                intArray[j++] = value;
            }
        }


    }

    //had to check for hash function over here once
    public static int hash(int value){
        return value/(int)10;
    }

    public static void main(String[] args) {
        int[] input = {35,76,12,43,13,90,22,31,2,7,1};

            bucketSort(input);

       for (int value : input){
           System.out.println(value);
       }

    }
}
