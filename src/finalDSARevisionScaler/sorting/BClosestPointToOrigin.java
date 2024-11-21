package src.finalDSARevisionScaler.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Q36) B closest point to Origin
 */
public class BClosestPointToOrigin {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

      A.sort((ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
          int distance1 = (int) (Math.pow(o1.get(0),2) + Math.pow(o1.get(1),2));
          int distance2 = (int) (Math.pow(o2.get(0),2) + Math.pow(o2.get(1),2));

          return distance1 - distance2;
      });

       for (int i =0 ; i < B;i++){
           ans.add(A.get(i));
       }

       return ans;
    }

    public static void main(String[] args) {
        BClosestPointToOrigin bc = new BClosestPointToOrigin();

    }
}
