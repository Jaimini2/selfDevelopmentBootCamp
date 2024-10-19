package src.finalDSARevisionScaler.stringmanipulation;

/**
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * <p>
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * <p>
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 */
public class LongestPalindromicSubString {

    public String solveWithBasicApproach(String A) {
        int n = A.length();

        String s1 = "";
        int ans = s1.length();

        for (int i = 0; i < A.length(); i++) {
            if (n % 2 != 0) {
                for (int j = i; j < A.length(); j++) {
                    int st = i;
                    int en = j;
                    while (st <= en) {
                        if (A.charAt(st) != A.charAt(en)) {
                            break;
                        }
                        st++;
                        en--;
                    }

                    if (st - 1 == en + 1) {
                        ans = Math.max(ans, j - i + 1);
                        if (ans > s1.length()) {
                            s1 = A.substring(i, i + ans);
                        }

                    }
                }
            }else{
                for (int j = i+1; j < A.length(); j++) {
                    int st = i;
                    int en = j;
                    while (st < en) {
                        if (A.charAt(st) != A.charAt(en)) {
                            break;
                        }
                        st++;
                        en--;
                    }

                    if (st - 1 == en) {
                        ans = Math.max(ans, j - i + 1);
                        if (ans > s1.length()) {
                            s1 = A.substring(i, i + ans);
                        }

                    }
                }
            }

        }

        return s1;
    }

    public String solve(String A) {

        int n = A.length();

        String ans = "";
        int len = ans.length();

        //for odd length
        for (int i = 0; i < n - 1; i++) {
            String in = expand(i, i, A);

            if (in.length() > len) {
                ans = in;
                len = in.length();
            }
        }

        //for even length
        for (int i = 0; i < n - 1; i++) {
            String in = expand(i, i + 1, A);
            if (in.length() > len) {
                ans = in;
                len = in.length();
            }
        }
        return ans;

    }

    String expand(int p1,int p2,String s){
        int n = s.length();
        while (p1 >=0 && p2 < n && s.charAt(p1) == s.charAt(p2)){
            p1--;
            p2++;
        }

       String s1 = "";

        s1 = s.substring(p1+1,p2);

        return s1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubString lgs = new LongestPalindromicSubString();

        String in = "rsabbba";

        System.out.println(lgs.solve(in));
    }
}
