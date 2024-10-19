package src.finalDSARevisionScaler.basics.InterviewProblems;

/**
 * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
 */
public class CountIncreasingTriplets {

    public int solve(int[] A) {

        int ans = 0;
        for(int j =1; j < A.length;j++){

            int i = j-1;
            int smallElements = 0;
            int largeElements = 0;

            while(i>=0){
                if(A[i] < A[j]){
                    smallElements++;
                }
                i--;
            }

            int k = j+1;
            while(k < A.length){
                if(A[j] < A[k]){
                    largeElements++;

                }
                k++;
            }

            ans = ans + smallElements * largeElements;
        }

        return ans;

    }

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 3};

        CountIncreasingTriplets c = new CountIncreasingTriplets();

        System.out.println(c.solve(a));

    }
}
