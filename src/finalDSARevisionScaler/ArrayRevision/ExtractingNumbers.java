package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q12)Given a string A.
 * The string contains AlphaNumeric characters.
 * Find the sum of all numbers present in it.
 * Note : All the numbers will fit in a 32-bit signed integer.
 */
public class ExtractingNumbers {
    public long solve(String A) {
        char[] ch = new char[A.length()];
        long ans = 0;

        for(int i=0; i < A.length();i++){
            long num = 0;
            if(isNumber(A.charAt(i))){
                StringBuilder str = new StringBuilder();
                int endIndex = A.length()-1;
                while(i <= endIndex){
                    if(isNumber(A.charAt(i))) {
                        str.append(A.charAt(i));
                    }else{
                        break;
                    }
                    i++;
                }

                num = Integer.parseInt(str.toString());


            }

            ans +=num;
        }
        return ans;
    }

    long generateAndStoreNumber(char c,int startIndex,int endIndex,String A){
        StringBuilder str = new StringBuilder();
        while(startIndex <= endIndex){
            if(isNumber(A.charAt(startIndex))){
                str.append(A.charAt(startIndex));
            }else{
                break;
            }
            startIndex++;
        }
        return Integer.parseInt(str.toString());
    }

    boolean isNumber(char c){
        return c >= 40 && c <= 57;
    }


    public static void main(String[] args) {
        String A = "f68yna53abryn66stbitjztbxlmhexbnimcbjxmbud69qs";
        String B = "a12b34c";

        ExtractingNumbers en = new ExtractingNumbers();
        System.out.println(en.solve(A));
    }
}
