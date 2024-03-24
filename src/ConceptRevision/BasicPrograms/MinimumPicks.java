package  src.ConceptRevision.BasicPrograms;

public class MinimumPicks {

    public static int solve(int[] A) {

        int maxEven = 0;
        int minOdd = 0;

        for(int i =0 ; i < A.length; i++){
            if(isEven(A[i])){
                if(A[i] > maxEven){
                    maxEven = A[i];
                }

            }else{
                if(A[i] < minOdd && A[i] != 0){
                    minOdd = A[i];
                }
            }

        }
       return maxEven- minOdd;
    }

    private static boolean isEven(int i) {
        return i%2 == 0;
    }

    public static void main(String[] args) {
        int a []= {-74,9,51,51,75,0,35,89,96,77};
        System.out.println(solve(a));
    }
}
