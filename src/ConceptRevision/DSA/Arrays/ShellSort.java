package ConceptRevision.DSA.Arrays;

/**
 * It is a variation of Insertion sort
 * Insertion sort chooses which element to insert
 * using a gap of 1
 * Shell sort starts out using a larger gap value
 * As the algorithm runa,the gap is reduced
 * Goal is to reduce the amount of shifting required
 * In-place algorithm
 * Worst case O(n^2)
 * Unstable algorithm
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

       /* for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j>=gap && intArray[j-gap]>newElement){
                    intArray[j] = intArray[j - gap];
                    j-=gap;
                }
                intArray[j] = newElement;

            }
        }*/

       for(int gap = intArray.length/2;gap > 0;gap = gap/2){
           for(int i = gap;i < intArray.length;i++){
               int newElement = intArray[i];
               int j = i;
               while (j > 0 && intArray[j-gap] > newElement){
                   intArray[j] = intArray[j - gap];
                   j-=gap;
               }
               intArray[j] = newElement;
           }
       }

       for (int i = 0; i < intArray.length;i++){
           System.out.println(intArray[i]);
       }
    }
}
