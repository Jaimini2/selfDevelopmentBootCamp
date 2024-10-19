package src.finalDSARevisionScaler.stringmanipulation;

/**
 * Given a string A, you are asked to reverse the string and return the reversed string.
 */
public class SimpleReverse {

    public String solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int startIndex = 0;
        int endIndex = A.length()-1;
        while (startIndex < endIndex){
          reverse(startIndex,endIndex,sb);
            startIndex++;
            endIndex--;

        }
        return sb.toString();
    }

    void reverse(int start,int end,StringBuilder ans){
        char st , en;
        st = ans.charAt(start);
        en = ans.charAt(end);
       st = (char) (st ^ en);
       en = (char) (st ^ en);
       st = (char) (st ^ en);
     ans.setCharAt(start,st);
     ans.setCharAt(end,en);
    }



    public static void main(String[] args) {

        SimpleReverse sr = new SimpleReverse();

       String ans =  sr.solve("scaler");

        System.out.println(ans);
    }
}
