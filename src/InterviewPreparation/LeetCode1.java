package InterviewPreparation;

import java.util.*;

/**
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
 * You may return the answer in any order.
 *
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 */
class LeetCode1 {
    public static List<String> commonChars(String[] words) {
        List<Character>commonChars = new ArrayList();
        List<Character>duplicateChars = new ArrayList();

        for(int i=0;i<words[0].length();i++){
            char c = words[0].charAt(i);
            commonChars.add(c);
        }



        for(int i = 1; i < words.length;i++){
            for(int j = 0 ; j < words[i].length();j++){
                if(commonChars.contains(words[i].charAt(j))){
                    duplicateChars.add(words[i].charAt(j));
                }
            }
            //commonChars = duplicateChars;
            commonChars.clear();
             for(Character chara:duplicateChars){
                     commonChars.add(chara);
                 }


           duplicateChars.clear();
        }
        List<String>dupString = new ArrayList(commonChars);

        return dupString;
    }

    public static void main(String[] args) {
     String[]   words = {"bella","label","roller"};
        List <String> ans = commonChars(words);
        System.out.println(ans);

        String[] words2 = {"cool","lock","cook"};
        System.out.println(commonChars(words2));

    }
}
