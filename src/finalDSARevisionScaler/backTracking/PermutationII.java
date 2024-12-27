package src.finalDSARevisionScaler.backTracking;

/**
 * Q63) All Unique Permutations
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 * NOTE: No 2 entries in the permutation sequence should be the same.
 * solve() function is used to solve it by printing the output
 * solve2() function is used to solve it by storing the ans in 2D array and then displaying that 2D array
 */
public class PermutationII {

    public void solve(char[] A){
        int [] freq = new int[26];
        for (int i = 0; i< A.length;i++){
            freq[A[i]-'a']++;
        }
        int idx = 0;
        String ans = null;
        permut(A,idx,freq,ans);


    }

    private void permut(char[] a, int idx, int[] freq,String ans) {
        if (idx == a.length){
           for (int i = 0 ; i < a.length;i++){
               System.out.print(a[i] + " ,");
           }
            System.out.println();
           return;
        }

       for (int i =0; i < freq.length;i++){
           if (freq[i] > 0){
               freq[i]-=1;

              a[idx] = (char) (i + 'a');
               permut(a,idx + 1,freq,ans);
               freq[i]+=1;
           }
       }
    }

    public static void main(String[] args) {
        char[] A = {'a','b','c','a'};

        PermutationII perm = new PermutationII();
        perm.solve(A);

    }
}
