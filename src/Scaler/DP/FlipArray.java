package Scaler.DP;

import java.util.Comparator;

public class FlipArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {

        // since we need to find the min positive number , after flipping the sign of some of its elements ,
        //we need to make sure that we should flip only the elements whose addition will be as close to the half
        // or equal to half of the current sum , since going past that will give us the negative answer.
        // so we take the capacity as totalsum/2 (so that we can consider it as 0-1 knapsack)

        int sum = 0;
        for(int num : A){
            sum+=num;
        }
        int cap = sum/2;
        Pair[][]dp = new Pair[A.length + 1][cap + 1];
        for(int i =0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = new Pair(0,0);
                }
                else if(A[i-1] <= j){
                    int newSum = A[i-1] + dp[i-1][j - A[i -1]].sum;
                    Pair previous = dp[i-1][j];
                    int newFlips = dp[i-1][j - A[i-1]].flip + 1;

                    if(Math.abs(newSum - j) < Math.abs(previous.sum - j)){
                        dp[i][j] = new Pair(newSum,newFlips);
                    }else if(Math.abs(newSum - j) > Math.abs(previous.sum - j)){
                        dp[i][j] = new Pair(previous.sum,previous.flip);
                    }else{
                        if(previous.flip < newFlips){
                            dp[i][j] = new Pair(previous.sum,previous.flip);
                        }else{
                            dp[i][j] = new Pair(newSum,newFlips);
                        }
                    }
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        Comparator<Integer> comp = ((a, b) ->{
            return a - b;
        });


        return dp[A.length][cap].flip;

    }

    class Pair{
        int sum;
        int flip;

        Pair(int sum,int flip){
            this.sum = sum;
            this.flip = flip;
        }
    }

    public static void main(String[] args) {
        FlipArray fp = new FlipArray();

        int A[] = {15,10,6};
        int ans = fp.solve(A);
    }

}

