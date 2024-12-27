package src.finalDSARevisionScaler.backTracking;

import java.util.ArrayList;

/**
 * Q64)Given a set of distinct integers A, return all possible subsets.
 * NOTE:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The initial list is not necessarily sorted.
 */
public class Subset {

    int count = 0;

    public ArrayList<ArrayList<Integer>> solve(int[] A) {

       // int[][] ansArr = new int[(int) Math.pow(2, A.length)][A.length];
        ArrayList<ArrayList<Integer>> ansArr = new ArrayList<>();
        int idx = 0;

        ArrayList<Integer> tempArr = new ArrayList<>();
        findSubSet(tempArr,A, idx, ansArr);

        return ansArr;

    }

    private void findSubSet(ArrayList<Integer> tempArr, int[] a, int idx, ArrayList<ArrayList<Integer>> ansArr) {

        if (idx == a.length) {
            ansArr.add(new ArrayList<>(tempArr));

            count++;
            return;

        }
        //ansArr.add(new ArrayList<>(tempArr));

        tempArr.add(a[idx]);
        findSubSet(tempArr,a, idx + 1, ansArr);
      tempArr.remove(tempArr.size()-1);
        findSubSet(tempArr, a,idx + 1, ansArr);

      /*  for (int i =idx ; i < a.length;i++){
            tempArr.add(a[i]);
            findSubSet(tempArr,a,i + 1,ansArr);
            tempArr.remove(tempArr.size()-1);
        }*/

    }


    public static void main(String[] args) {

        int A[] = {1, 2, 3};

        Subset ss = new Subset();
        ArrayList<ArrayList<Integer>> ans = ss.solve(A);



        for (ArrayList<Integer> s : ans) {
            for (int i : s) {
                System.out.print(i + " ,");
            }
            System.out.println();
        }

    }
}
