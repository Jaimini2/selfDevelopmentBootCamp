package ConceptRevision.DSA.Arrays;

/**
 * Radix Sort
 *  * Make assumptions about the data
 *  * Doesn't use comparisons
 *  * Counts the number of occurrances of each value
 *  * only works with non-negative discrete values
 *  * (can't work with floats and strings)
 *  * values must be within a specific range
 *  * The values should have the common width and doesn't allow decimal numbers
 *  * Have to use stable sort algorithm at each stage
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] intArray = {4725,4856,5678,8792,1267,3294};

        radixSort(intArray,10,4);
        MergeSort.displaySortedArray(intArray);
    }

    public static void radixSort(int[] input,int radix,int width){
        for (int i =0; i < width;i++){
            radixSingleSort(input,i,radix);
        }

    }
    public static void radixSingleSort(int[]input,int position,int radix){
        int numItems=input.length;

        int[] countArray= new int[radix];

        for (int value: input){
            countArray[getDigit(position,value,radix)]++;
        }
        //Adjust the count array
        for (int j = 1; j < radix;j++){

            countArray[j] +=countArray[j - 1];

        }

        int[]temp = new int[numItems];
        for (int tempIndex = numItems - 1;tempIndex >= 0;tempIndex--){
            temp[--countArray[getDigit(position,input[tempIndex],radix)]]=input[tempIndex];
        }

        for (int tempindex = 0; tempindex <numItems;tempindex++){
            input[tempindex] = temp[tempindex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int)Math.pow(radix,position)%radix;
    }
}
