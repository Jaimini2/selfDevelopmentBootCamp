package Scaler.SlidingWindow;

public class LongestConsecutiveOnes {
    public static int solve(String A){
        int n = A.length();
       int greatestConsecutive = 0;
       if(!containsZero(A)){
          return A.length();
       }
        for(int i =0 ; i < n;i++){
            if(A.charAt(i) == '0'){
                int ls = 0;
                int rs = 0;
                int j = i-1;
                while( j >= 0 && A.charAt(j) == '1'){
                    ls++;
                    j--;
                }
                int k = i+1;
                while(k < n && A.charAt(k)== '1'){
                    rs++;
                    k++;
                }
                if(ls != 0 && rs != 0){
                    boolean extra1 = contains1(0,j,A) || contains1(k,A.length()-1,A);
                    greatestConsecutive = extra1 ? Math.max(greatestConsecutive,ls+rs+1) :
                            Math.max(greatestConsecutive,ls+rs);
                }else{
                    if(rs == 0){
                        if(greatestConsecutive !=0){
                            greatestConsecutive = contains1(i,A.length()-1,A)
                                    ?Math.max(greatestConsecutive,ls+rs+1) : Math.max(greatestConsecutive,ls+rs);
                        }else {
                            greatestConsecutive = contains1(i,A.length()-1,A)
                                    ?Math.max(greatestConsecutive,ls+rs+1) : Math.max(greatestConsecutive,ls+rs);
                        }
                    }else{
                        greatestConsecutive =contains1(i,A.length()-1,A)
                                ?Math.max(greatestConsecutive,ls+rs+1) : Math.max(greatestConsecutive,ls+rs);
                    }
                    if(ls == 0){
                        if(contains1(0,i,A)){
                            greatestConsecutive = Math.max(greatestConsecutive,ls+rs+1);
                        }
                    }else{
                        greatestConsecutive = Math.max(greatestConsecutive,ls+rs);
                    }
                }
            }

        }
        return greatestConsecutive;
    }

    private static boolean containsZero(String a) {
        for(int i = 0 ; i < a.length();i++){
            if(a.charAt(i) == '0'){
                return true;
            }
        }
        return false;
    }

    static boolean contains1(int startIndex,int endIndex,String A){
        for(int i = endIndex;i>=startIndex;i--){
            if(A.charAt(i) == '1'){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String A = "1110111";

        System.out.println(solve(A));
    }
}
