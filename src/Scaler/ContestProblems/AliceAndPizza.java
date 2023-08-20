package Scaler.ContestProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AliceAndPizza {
    public int solve(int[] A, int B) {

        int time = B;

        Arrays.sort(A);
        int count = 0;
        for(int i =0 ; i < A.length ;i++){
                time = time - A[i];
                if(time > 0){
                    count++;
                }else{
                    break;
                }

        }
        return count;
    }

    PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
            new Comparator<Integer>() {

                // Compare method for place element in
                // reverse order
                public int compare(Integer a, Integer b)
                {
                    if (a < b)
                        return 1;
                    if (a > b)
                        return -1;
                    return 0;
                }
            });



    public int solve2(int[]A,int B){

        Arrays.sort(A);
        int count = 0;

        int time = B;
        for(int i =0 ; i < A.length;i++){
            time = time - A[i];
            if(time > 0){
                count++;
            }else {
                break;
            }
        }

        return count;



    }

    public static void main(String[] args) {
        int A[] = {8 ,25, 24, 9, 6, 23, 20, 4, 10 };

        int B = 16;

        AliceAndPizza ap = new AliceAndPizza();
        int ans = ap.solve(A,B);
        System.out.println(ans);
    }
}
