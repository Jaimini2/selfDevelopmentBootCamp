package ConceptRevision.DSA.Arrays;

/**
 *
 */
public class ClassA {

    public static boolean checkPattern(int[] intArray){
        //checking for the largest Number
        int largestIndex = 0;
       for (int i = 1;i < intArray.length-1;i++) {
           //2.[-8, 9, 5, 2, 0, -7]
           if (intArray[i] > intArray[largestIndex]) {
               largestIndex = i ;
           }
       }
       while(largestIndex+1 < intArray.length && intArray[largestIndex]>intArray[largestIndex + 1]){
                largestIndex+=1;
       }
       if(largestIndex == intArray.length-1){
           return true;
       }
        return false;
    }

    public static void main(String[] args) {
        int [] inta = {-8,-2, 1, 4, 6, 9, 5, 2, 0, -7};

           boolean flag =  checkPattern(inta);
        System.out.println(flag?"This is a pattern" : "This is not a pattern");
    }
}
