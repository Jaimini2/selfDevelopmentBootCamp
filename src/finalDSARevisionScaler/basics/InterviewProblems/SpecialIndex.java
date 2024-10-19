package src.finalDSARevisionScaler.basics.InterviewProblems;

/**
 * Given an array, arr[] of size N,
 * the task is to find the count of array indices such that removing an element from
 * these indices makes the sum of even-indexed and odd-indexed array elements equal.
 */
public class SpecialIndex {

    public int solve(int[] A) {

        int oddSum = 0;
        int evenSum = 0;
        int n = A.length;

        for(int i = 0; i < A.length;i++){
            if(i%2 != 0){
                oddSum+=A[i];
            }else {
                evenSum+=A[i];
            }
        }

        int currOdd = 0;
        int currEven = A[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;

        for(int i = 1; i < n-1;i++){
            if(i % 2 == 1){
                currOdd = currOdd + A[i];

                newEvenSum = currEven + oddSum - currOdd;

                newOddSum = currOdd + evenSum - currEven - A[i];

            }
            else {
                currEven = currEven + A[i];

                newOddSum = currOdd + evenSum - currEven;

                newEvenSum = currEven + oddSum  - currOdd - A[i];
            }

            if(newEvenSum == newOddSum){
                res++;
            }
        }

        if(oddSum == evenSum -A[0]){
            res++;
        }

        if(n%2 == 1){
            if(oddSum == evenSum - A[n-1]){
                res++;
            }
        }
        else{
            if(evenSum == oddSum - A[n-1]){
                res++;
            }
        }


        return res;
    }

        public static void main(String[] args) {
        int A[] = { 2, 1, 6, 4};

        SpecialIndex sp = new SpecialIndex();
            System.out.println(sp.solve(A));


    }
}
