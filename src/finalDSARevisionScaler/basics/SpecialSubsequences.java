package src.finalDSARevisionScaler.basics;

/**
 * Using carry forward technique over here
 */

public class SpecialSubsequences {
    public int solve(String A) {
       int ans = 0;
        int count = 0;
        int mod = (int)Math.pow(10,9) + 7;
       for(int i =0 ;i < A.length();i++){
           if(A.charAt(i) == 'A'){
               count++;
           }
           else if(A.charAt(i) == 'G'){
               ans = ans + count;
               ans = ans%mod;
           }
       }
        return ans;

    }

    public static void main(String[] args) {
        SpecialSubsequences sc = new SpecialSubsequences();

        String A = "ABCGAG";
        int ans = sc.solve(A);
        System.out.println(ans);
    }
}
