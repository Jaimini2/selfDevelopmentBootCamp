package src.finalDSARevisionScaler.stringmanipulation;

public class AddBinary {

    public String solve(String A, String B) {

        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;

        StringBuilder str = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = (i >= 0 ? (A.charAt(i) - '0') : 0) + (j >= 0 ? (B.charAt(j) - '0') : 0) + carry;
            int stay = sum % 2;
            carry = sum / 2;

            str.append(stay);
            i--;
            j--;
        }
        str.reverse();
        return str.toString();
    }

    public static void main(String[] args) {
            AddBinary ab = new AddBinary();
          String ans =   ab.solve("110","100");

        System.out.println(ans);
    }
}
