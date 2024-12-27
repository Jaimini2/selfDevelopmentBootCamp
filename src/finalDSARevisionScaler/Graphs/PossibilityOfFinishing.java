package src.finalDSARevisionScaler.Graphs;

import java.util.*;

/**
 * Q86) Possibility of Finishing
 *There are a total of A courses you have to take, labeled from 1 to A.
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 * So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 */
public class PossibilityOfFinishing {

    public int solve(int A, int[] B, int[] C) {

        //create adjacency List

        List<Integer> adjlist[] = new ArrayList[A+1];

        //create and fill up adjacency list and indegree array as well

        for (int i =0;i <= A;i++){
           ArrayList<Integer> al = new ArrayList<>();
           adjlist[i] = al;
        }

        int[] indegree = new int[A+1];
        for (int i =0 ; i < B.length;i++){
            adjlist[B[i]].add(C[i]);
            indegree[C[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i =1 ; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int val = queue.remove();
            List<Integer> al = adjlist[val];
            for (int i : al){
              indegree[i]--;

              if(indegree[i] == 0){
                  queue.add(i);
              }
            }
            count++;

        }

        if (count == A){
            return 1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {

        int A = 3;

        int[] B = {1, 2};

        int[] C = {2, 3};


        PossibilityOfFinishing pf = new PossibilityOfFinishing();
        int ans = pf.solve(A,B,C);
        System.out.println(ans);
    }
}
