package ConceptRevision.DSA.Queues;


import java.util.LinkedList;
import java.util.Queue;

public class QueueChallenge {

    public static boolean checkForPalindrome(String a1){
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String st1 = a1.toLowerCase();

        for (int i = 0 ; i < st1.length();i++){
            char c = st1.charAt(i);
            if(c>='a' && c<= 'z'){
                stack.push(c);
                queue.addLast(c);
            }
        }

        while (!stack.isEmpty()){
            if(stack.pop() != queue.remove()){
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("was it a car or a cat I saw"));
        System.out.println(checkForPalindrome("I did, did I ?"));
        System.out.println(checkForPalindrome("Hello"));
        System.out.println(checkForPalindrome("Dontnod"));


    }
}
