package src.finalDSARevisionScaler.stack;

import java.util.Stack;

/**
 * Q40)Nearest Smaller Element
 * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * More formally,
 * G[i] for an element A[i] = an element A[j] such that
 * j is maximum possible AND
 * j < i AND
 * A[j] < A[i]
 * Elements for which no smaller element exist, consider the next smaller element as -1.
 */
public class NearestSmallerElement {



    public int[] solve(int A[]){
       Stack<Integer> st = new Stack<>();
        int[] ans = new int[A.length];
        st.push(A[0]);
        ans[0] = -1;
        for (int i =1; i < A.length;i++){
            while(!st.isEmpty() && (st.peek() >= A[i])){
                st.pop();
            }
           if(!st.isEmpty()){
               ans[i] = st.peek();
           }
            st.push(A[i]);

        }

        return ans;
    }

    public static void main(String[] args) {

        int A[] = {4, 5, 2, 10, 8};

        NearestSmallerElement nsm = new NearestSmallerElement();

        int [] ans = nsm.solve(A);

        for (int an : ans) {
            System.out.print(an + " ,");
        }

    }
}
