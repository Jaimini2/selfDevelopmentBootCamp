package src.ConceptRevision.BasicPrograms.StringPrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Java program to fins a duplicate characters in a String
 */
public class DuplicateChars {

    static void findDuplicates(String str){
        char []charArray = str.toCharArray();
        Map charMap = new HashMap<Character,Integer>();
        for (Character ch : charArray) {
            if(charMap.containsKey(ch)){
                charMap.put(ch, (Integer) charMap.get(ch) + 1);
            }else{
                charMap.put(ch,1);
            }
        }

        Set<Character> charKeys = charMap.keySet();
        Iterator <Character> it = charKeys.iterator();
        while (it.hasNext()){
            Character ch = it.next();
            if((Integer)charMap.get(ch) > 1){
                System.out.println("Character : "+ch + " has been repeated "+ (Integer)charMap.get(ch)+ " Times");
            }
        }
    }

    public static void main(String[] args) {
        findDuplicates("This is a Crazy world");
    }
}
