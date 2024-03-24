package  src.ConceptRevision.BasicPrograms;

public class PairCount {
    public static int solve(int[] A, int B) {
        int countOfPairs = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int diff = B - A[i];
            if (diff < B) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == diff) {
                        countOfPairs++;
                    }
                }
            }
        }

        return countOfPairs;
    }

    public static void main(String[] args) {
        int a[] = {1,1,1};
        int b = 2;

        System.out.println(solve(a,b));

    }
}
