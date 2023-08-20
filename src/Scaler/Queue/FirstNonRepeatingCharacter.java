package Scaler.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    Queue<Character> queue = new LinkedList<Character>();
   // Queue<Character>queue = new LinkedList<Character>();
    public String solve(String A) {
        HashMap<Character,Integer> hm = new HashMap();
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < A.length();i++){
            if(hm.containsKey(A.charAt(i))){
                int val= hm.get(A.charAt(i));
                hm.put(A.charAt(i),val + 1);
                if(queue.isEmpty()){
                    str.append('#');
                }else{
                    while (hm.get(queue.peek()) > 1){
                        queue.remove();
                    }
//                    if(hm.get(queue.peek()) > 1){
//                        queue.remove();
//                    }
//                    if(queue.peek() == A.charAt(i) && hm.get(A.charAt(i)) > 1) {
//                        queue.remove();
//                    }
                    str.append(queue.peek());
                }

            }else{
                hm.put(A.charAt(i),1);
                queue.add(A.charAt(i));
                str.append(queue.peek());
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter fnrc = new FirstNonRepeatingCharacter();
       String ans =  fnrc.solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl");
        System.out.println(ans);
    }
}
