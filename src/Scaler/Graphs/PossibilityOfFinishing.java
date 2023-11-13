package Scaler.Graphs;

import java.util.PriorityQueue;

public class PossibilityOfFinishing {
        public int solve(int A, int[] B, int[] C) {
            int [] adjArray = new int[A + 1];
            int[] indegree = new int[A + 1];

            for(int i =0 ; i < B.length;i++){
                adjArray[B[i]] = C[i];
                indegree[C[i]]++;
            }

            PriorityQueue<Integer> pq = new PriorityQueue();
            int count = 0;
            for(int i =1 ; i <= A;i++){
                if(indegree[i] == 0){
                    pq.add(i);
                }
            }

            while(pq.size() > 0){
                int item = pq.remove();
                int val = adjArray[item];
                indegree[val]--;
                count++;

                if(indegree[val] == 0){
                    pq.add(val);
                }
            }

            if(count == A){
                return 1;
            }else{
                return 0;
            }

        }

    public static void main(String[] args) {
        PossibilityOfFinishing pf = new PossibilityOfFinishing();
        int a = 5;
        int A[] = {1,3,4,5};
        int B[] = {2,1,5,3};

       int ans = pf.solve(a,A,B);
        System.out.println(ans);
    }

}
