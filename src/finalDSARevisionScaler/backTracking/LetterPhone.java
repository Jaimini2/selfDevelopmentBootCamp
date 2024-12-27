package src.finalDSARevisionScaler.backTracking;

import java.util.ArrayList;

/**
 * Q66)Given a digit string A, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 * NOTE: Make sure the returned strings are lexicographically sorted.
 */
public class LetterPhone {

    final String[] letters = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public ArrayList<String > solve(String A){
        StringBuilder st = new StringBuilder();

       ArrayList<String> ans = new ArrayList<>();

       generateCombinations(0,st,ans,A);


        return ans;
    }

    private void generateCombinations(int idx, StringBuilder st, ArrayList<String> ans, String str) {
        if(idx == str.length()){
            ans.add(st.toString());
            return;
        }

        int num =   str.charAt(idx) - '0';
        for (int i = 0; i < letters[num].length();i++){
            //add the ith value in the string
            st.append(letters[num].charAt(i));
            generateCombinations(idx + 1,st,ans,str);
            st.deleteCharAt(st.length()-1);

        }

    }

    public static void main(String[] args) {

       LetterPhone lp = new LetterPhone();
       ArrayList<String> ans = lp.solve("23");

       for (String s: ans){
           System.out.print(s+ " ,");
       }


    }
}
