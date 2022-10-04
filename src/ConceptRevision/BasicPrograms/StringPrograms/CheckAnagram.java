package ConceptRevision.BasicPrograms.StringPrograms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class CheckAnagram {
    public static void isAnagram(String s1 , String s2){
        String a1 = s1.replaceAll(" ","");
        String a2 = s2.replaceAll(" ","");
        boolean status ;

        if(a1.length() != a2.length()){
          status = false;
        }else{
            char[] charArray1 = a1.toLowerCase().toCharArray();
            char[] charArray2 = a2.toLowerCase().toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            status = Arrays.equals(charArray1,charArray2);
        }
        if(status){
            System.out.println( s1 +" and "+s2 + " are Anagrams");
        }else{
            System.out.println(s1 + " and "+s2 + " are not Anagrams");
        }

    }

    public static void main(String[] args) {
        isAnagram("Keep","Peek");

        isAnagram("Mother in Law","Hitler Woman");

        isAnagram("Chetana","Jaimini");
    }
}
