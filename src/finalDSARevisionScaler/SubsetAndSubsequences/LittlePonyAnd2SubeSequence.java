package src.finalDSARevisionScaler.SubsetAndSubsequences;

import src.finalDSARevisionScaler.LinkedList.LinkedNode;

/**
 * Q11)
 * Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2.
 * Can you help him?
 * A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a.
 * For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
 */
public class LittlePonyAnd2SubeSequence {
    public String solve(String A){
        char minChar = 'z';
        int index = 0;
        for (int i =0 ; i < A.length();i++){
            if(A.charAt(i) < minChar){
                minChar = A.charAt(i);
                index = i;
            }
        }

        char minChar2 = 'z';
        for(int i = index+1 ; i < A.length();i++){
            if(A.charAt(i) < minChar2){
                minChar2 = A.charAt(i);
            }
        }

        String ans = String.valueOf(minChar) + String.valueOf(minChar2);
        return ans;
    }

    public static void main(String[] args) {
        String A = "abcdsfhjagj";

        LittlePonyAnd2SubeSequence lp = new LittlePonyAnd2SubeSequence();

        String ans = lp.solve(A);
        System.out.println(ans);
    }
}
