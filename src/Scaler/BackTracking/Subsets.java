package Scaler.BackTracking;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {
        ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            Collections.sort(A);
            findSubsets(A, new ArrayList<Integer>(), 0);
            return finalAns;
        }

        public void findSubsets(ArrayList<Integer> A, ArrayList<Integer> temp, int index) {
            finalAns.add(new ArrayList<>(temp));

            for (int i = index; i < A.size(); i++) {
                temp.add(A.get(i));
                findSubsets(A, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

        static void display2DArrayList(ArrayList<ArrayList<Integer>> in){
            for(int i =0; i < in.size();i++){
              //  if(in.get(i).isEmpty()){
                    System.out.print("[");
               // }
                for(int j =0; j < in.get(i).size();j++){
                    System.out.print(in.get(i).get(j)+" ");
                }
                System.out.print("]");
                System.out.println();
            }
        }

    public static void main(String[] args) {
            int [] Arr = new int[]{1, 2, 3};

        ArrayList<Integer> A = new ArrayList<>();
            for(int i: Arr){
                A.add(Arr[i-1]);
        }

            Subsets sb = new Subsets();
            sb.finalAns = sb.subsets(A);

            Subsets.display2DArrayList(sb.finalAns);



    }
}
