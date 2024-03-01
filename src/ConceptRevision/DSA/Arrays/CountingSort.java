package src.ConceptRevision.DSA.Arrays;

/**
 * Radix Sort
 * Make assumptions about the data
 * Doesn't use comparisons
 * Counts the number of occurrances of each value
 * only works with non-negative discrete values
 * (can't work with floats and strings)
 * values must be within a specific range
 * The values should have the common width and doesn't allow decimal numbers
 * Have to use stable sort algorithm at each stage
 */
public class CountingSort {

    public static void countingSort(int[] intArray,int min,int max){
        int[]countArray = new int[(max-min) + 1];
        for(int i = 0; i <intArray.length;i++){
            countArray[intArray[i] -min]++;
        }

        int j =0;

        /*for(int i =min; i <= max;i++){
            while (countArray[i - min] > 0){
                intArray[j++] = i;
                countArray[i-min]--;
            }
        }*/

        for(int i  = min; i<=max;i++){
            while(countArray[i - min] > 0) {
                intArray[j++] = i;
                countArray[i - min]--;
            }
        }


    }
    public static void main(String[] args) {
        int[] intArray = {2,5,9,8,2,8,7,10,4,3};

        countingSort(intArray,1,10);

        MergeSort.displaySortedArray(intArray);


    }
}
