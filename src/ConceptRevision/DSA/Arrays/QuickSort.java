package ConceptRevision.DSA.Arrays;

/**
 * Divide and Conquer Algorithm
 * Recurrsive algorithm
 *
 */
public class QuickSort {
    public static void quickSort(int[] intArray,int start,int end){
        if(end - start < 2)
                return;
        int pivot = pivotIndex(intArray,start,end);
        quickSort(intArray,start,pivot);
        quickSort(intArray,pivot + 1,end);
    }

    private static int pivotIndex(int[] intArray, int start, int end) {
        int i = start;
        int j = end;
        int pivot = intArray[start];

        while (i < j) {
            //Note : empty loop to move J from right to left
            while (i < j && intArray[--j] >= pivot) ;
            if (i < j) {
                intArray[i] = intArray[j];
            }

            while (i < j && intArray[++i] <= pivot) ;
            if (i < j) {
                intArray[j] = intArray[i];
            }
        }
        intArray[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

            quickSort(intArray,0,intArray.length);

            MergeSort.displaySortedArray(intArray);
    }
}
