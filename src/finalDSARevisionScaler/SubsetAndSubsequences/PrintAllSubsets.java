package src.finalDSARevisionScaler.SubsetAndSubsequences;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Q10 Given a set of distinct integers A, return all possible subsets.
 * NOTE:
 * <p>
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The initial list is not necessarily sorted.
 */
public class PrintAllSubsets {


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        func(0, temp, A, result);
        return result;

    }

    private void func(int ind, ArrayList<Integer> temp, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = ind; i < A.size(); i++) {
            temp.add(A.get(i));
            func(i + 1, temp, A, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        PrintAllSubsets ps = new PrintAllSubsets();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<ArrayList<Integer>> ans = ps.subsets(A);

        for (ArrayList<Integer> i : ans) {
            System.out.print("[");
            i.forEach(j -> System.out.print(" " + j + " "));
            System.out.print("]");
            System.out.println();
        }
    }
}
