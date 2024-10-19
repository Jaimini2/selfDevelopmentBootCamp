package src.finalDSARevisionScaler.stringmanipulation;

import java.util.HashMap;

public class IsDictionary {

    public int solve(String[] A, String B) {


        HashMap hm = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            hm.put(B.charAt(i), i);
        }

        for (int i = 0; i < A.length - 1; i++) {
            int n = Math.min(A[i].length(), A[i + 1].length());
            int j = 0;
            while (j < n) {
                char k = A[i].charAt(j);
                char l = A[i + 1].charAt(j);
                if (compare((Integer) hm.get(k), (Integer) hm.get(l)) == 1) {
                    break;
                }else if(compare((Integer) hm.get(k), (Integer) hm.get(l)) == -1){
                    return 0;
                }else{
                    if(j == n-1 && A[i].length() > A[i+1].length()){
                        return 0;
                    }
                }
                j++;
            }
        }
        return 1;
    }


    int  compare(int a, int b) {
       if (a < b)return 1;
       else if(a > b) return -1;
       else return 0;
    }

    public static void main(String[] args) {
        String A[] = {"app", "apple"};

        String B = "abcdefghijklmnopqrstuvwxyz";

        IsDictionary id = new IsDictionary();

        System.out.println(id.solve(A,B));
    }
}


