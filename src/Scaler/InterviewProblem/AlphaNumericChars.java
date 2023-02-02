package Scaler.InterviewProblem;

public class AlphaNumericChars {
    public static long solve(String A){
        long num = 0;
        int i;
        for(i =0; i < A.length();i++) {
            if (isNumber(A.charAt(i))) {
                int j = i + 1;
                // num = num + generateAndStoreNum(A.charAt(i),i+1,A.length()-1,A);
                StringBuilder str = new StringBuilder();
                str.append(A.charAt(i));
                while (j < A.length() && isNumber(A.charAt(j))) {
                    str.append(A.charAt(j));
                    j++;
                    i = j;
                }
                num = num + Integer.parseInt(str.toString());

            }
        }
        return num;
    }

    private static long generateAndStoreNum(char charAt, int startIndex, int endIndex, String a) {
        StringBuilder str = new StringBuilder();
        str.append(charAt);
        while (startIndex <= endIndex){
            if(isNumber(a.charAt(startIndex))){
                str.append(a.charAt(startIndex));
            }else{
                return Integer.parseInt(str.toString());
            }
            startIndex++;
        }

        return Integer.parseInt(str.toString());
    }

    private static boolean isNumber(char c) {
        return c>=47 && c<= 57;
    }

    public static void main(String[] args) {
        String A = "a12b34c";
        System.out.println(solve(A));
    }
}
