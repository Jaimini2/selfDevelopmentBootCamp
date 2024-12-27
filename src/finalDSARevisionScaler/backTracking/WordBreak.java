package src.finalDSARevisionScaler.backTracking;

import java.util.*;

/*public class WordBreak {

    public int solve(String A, String [] B){

        Set<String> hs = new HashSet<>();
        for (int i =0; i < B.length;i++){
            hs.add(B[i]);
        }

        if(iswordBreak(A,hs)){
            return 1;
        }else {
            return 0;
        }

    }

    public boolean iswordBreak(String A, Set<String> B) {

        if(A.length() == 0){
            return true;
        }
        for(int i =0 ; i < A.length();i++){
            String str;
            if(i == A.length()-1){
                 str = A;
                 i++;
            }else{
                 str = A.substring(0,i);
            }


            if(isPresent(str,B)){
                if(iswordBreak(A.substring(i),B) == true){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isPresent(String str, Set<String> b) {
        if (b.contains(str)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        WordBreak wrb = new WordBreak();
        String A = "myinterviewtrainer";
        String [] B = {"trainer", "my", "interview"};

        int ans = wrb.solve(A,B);
        System.out.println(ans);

    }
}*/
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

   /* public int breakWord(String A, String[] B) {
        Set<String> wordDict = new HashSet<>();
        for (String word : B) {
            wordDict.add(word);
        }
        return canBreak(A, wordDict) ? 1 : 0;
    }

    private boolean canBreak(String A, Set<String> wordDict) {
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true;  // Empty string can be segmented

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[A.length()];
    }*/

    public int wordBreak(String A, String[] B) {
        Set<String> wordDict = new HashSet<>();
        for (String word : B) {
            wordDict.add(word);
        }
        Map<String, Boolean> memo = new HashMap<>();
        return canBreak(A, wordDict, memo) ? 1 : 0;
    }

    private boolean canBreak(String A, Set<String> wordDict, Map<String, Boolean> memo) {
        if (A.length() == 0) {
            return true;
        }
        if (memo.containsKey(A)) {
            return memo.get(A);
        }
        for (int i = 1; i <= A.length(); i++) {
            String prefix = A.substring(0, i);
            if (wordDict.contains(prefix) && canBreak(A.substring(i), wordDict, memo)) {
                memo.put(A, true);
                return true;
            }
        }
        memo.put(A, false);
        return false;
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String A = "applepenapple";
        String[] B = {"apple", "pen"};

        int result = solution.wordBreak(A, B);
        System.out.println(result);  // Output: 1
    }
}

