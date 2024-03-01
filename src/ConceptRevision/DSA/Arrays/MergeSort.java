package src.ConceptRevision.DSA.Arrays;

/**
 * Divide and Conquer algorithm
 * Not an in-place algorithm
 * O(nlogn) - base2.We 're repeatedly dividing the array in half during the splitting phase
 * Stable algorithm
 *
 */
public class MergeSort {
    public static void displaySortedArray(int[] intArray){
        for (int i =0 ; i < intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input,int start,int end){
        if(end - start < 2){
            return;
        }

        int mid = (start + end)/2;
        mergeSort(input,start,mid);
        mergeSort(input,mid,end);
        mergeDescending(input,start,mid,end);

    }

    private static void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] <= input[mid]){
            return;
        }
        int i = start;
        int j = mid;
        int[] temp = new int[end - start];
        int tempIndex = 0;
        while(i<mid && j<end){
            temp[tempIndex++] = input[i] <=input[j] ?input[i++] : input[j++];
        }
        System.arraycopy(input,i,input,start+tempIndex,mid-i);

        System.arraycopy(temp,0,input,start,tempIndex);
    }

    public static void mergeDescending(int[] input, int start, int mid, int end){
        if(input[mid-1]>=input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int temp[] = new int[end - start];
        int tempIndex = 0;

        while (i < mid && j < end){
            temp[tempIndex++] = input[i] >= input[j]?input[i++]:input[j++];
        }

        System.arraycopy(input,i,input,start+tempIndex,mid-i);
        System.arraycopy(temp,0,input,start,tempIndex);

    }

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray,0, intArray.length);

        displaySortedArray(intArray);

    }
}
