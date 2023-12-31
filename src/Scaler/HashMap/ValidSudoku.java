package Scaler.HashMap;

import java.util.HashMap;

public class ValidSudoku {

    public int isValidSudoku(final String[] A) {
        HashMap<Integer,Integer>[] hmArr = new HashMap [9];

        for(int i =0 ; i < hmArr.length;i++){
            hmArr[i] = new HashMap<Integer,Integer>();
        }

        String[] s = A[0].split(",");

        for(int i =0; i < s.length;i++){
            for(int j = 0; j < s[i].length();j++){
                if(s[i].charAt(j) == '.'){
                    hmArr[i].put(j,0);
                }else{
                    int num = Integer.parseInt(String.valueOf(s[i].charAt(j)));

                    if(hmArr[i].containsKey(num)){
                        if(hmArr[i].get(num) > 1){
                            return 0;
                        }
                        else{
                            int val = hmArr[i].get(num);
                            hmArr[i].put(num,val + 1);
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String [] s = new String[1];
        //String s1= ["....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"];
    }

}
