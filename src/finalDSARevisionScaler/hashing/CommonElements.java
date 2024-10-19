package src.finalDSARevisionScaler.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElements {
        public int[] solve(int[] A, int[] B) {

            HashMap hm = new HashMap<Integer,Integer>();
            ArrayList<Integer> ans = new ArrayList();

            //create hashmap based on the first array

            for(int i = 0 ; i < A.length;i++){
                if(hm.containsKey(A[i])){
                    Integer j = (Integer) hm.get(A[i]);
                    hm.put(A[i],j+1);
                }else{
                    hm.put(A[i],1);
                }
            }

            //find common elements and the count of common elements and add it in an array
            for(int i = 0 ; i < B.length;i++){
                if(hm.containsKey(B[i])){
                    int j = (int) hm.get(B[i]);
                    ans.add(B[i]);
                    hm.put(B[i],j-1);

                    if((int)hm.get(B[i]) == 0){
                        hm.remove(B[i]);
                    }
                }else{
                    hm.put(B[i],1);
                }
            }


            //getting records from arraylist to an array
            int [] ansArr = new int[ans.size()];

            for(int i =0 ; i < ans.size();i++){
                ansArr[i] = ans.get(i);
            }

            return ansArr;

    }

    public static void main(String[] args) {
        CommonElements cm = new CommonElements();
        int A[] = {1, 2, 2, 1};
        int B[] = {2, 3, 1, 2};

       int [] ans = cm.solve(A,B);

       for(int i : ans){
           System.out.print(i + " ");
       }


    }

}
