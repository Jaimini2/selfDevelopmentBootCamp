package  src.ConceptRevision.DSA.SearchAlgo;

public class BinarySearch {

    public static int iterativeBinarySearch(int[] input, int num) {
        int start = 0;
        int end = input.length;


        for (start = 0; start < end; ) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == num) {
                return num;
            } else if (input[midpoint] < num) {
                start = midpoint + 1;
            } else if (input[midpoint] > num) {
                end = midpoint;
            }
        }
        System.out.println("Number not found ");
        return -1;
    }

    public static int recurrisveBinarySearch(int[] input,int num){
        return recurrisveBinarySearch(input,0,input.length,num);
    }

    private static int recurrisveBinarySearch(int[] input, int start, int end, int num) {
        if(start>=end)
            return -1;
        int midpoint = (start + end)/2;
        System.out.println("midpoint = "+midpoint);

        if(input[midpoint] == num){
            return midpoint;
        }else if(input[midpoint] < num){
            return recurrisveBinarySearch(input,midpoint+1,end,num);
        }else {
            return recurrisveBinarySearch(input,start,midpoint,num);
        }
    }

    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

//        System.out.println(iterativeBinarySearch(intArray, 2));
//        System.out.println(iterativeBinarySearch(intArray, 20));
//        System.out.println(iterativeBinarySearch(intArray, 35));
//        System.out.println(iterativeBinarySearch(intArray, -22));



        System.out.println(recurrisveBinarySearch(intArray, 2));
        System.out.println(recurrisveBinarySearch(intArray, 20));
        System.out.println(recurrisveBinarySearch(intArray, 35));
        System.out.println(recurrisveBinarySearch(intArray, -22));

    }
}
