package  src.ConceptRevision.DSA.Arrays;

/**
 * In - place algorithm - logically partitioning the array and dont have to create another array
 * O(n^2)time complexity - quadratic
 * Algorithm degrades quickly
 * If extra memory you are using doesn't increase with the
 * as the no of items in an array increases then its still an In-place algorithm
 */
public class BubbleSort {

   public static void swap(int[] array,int i, int j){
        if(i == j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};

        for(int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for(int i = 0; i < lastUnsortedIndex;i++){
                if(array[i] > array[i+1]){
                    swap(array,i,i+1);
                }
            }
        }

        for (int i = 0; i < array.length;i++){
            System.out.println(array[i]);
        }

    }
}
