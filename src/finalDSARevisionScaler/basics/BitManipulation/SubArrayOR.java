package src.finalDSARevisionScaler.basics.BitManipulation;

/**
 * Q30)You are given an array of integers A of size N.
 *The value of a subarray is defined as BITWISE OR of all elements in it.
 * Return the sum of value of all subarrays of A % 109 + 7.
 */
public class SubArrayOR {

    public int solve2(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }

    public int solve(int[] A){
       // int ans = 0;
        int idx[] = new int[32];
        int n = A.length;
        long ans = 0;

        for (int i =1 ; i <= n;i++){
            int temp1 = A[i-1];

            for (int j =0 ; j < 32;j++){
                long pw = 1 << j;

                //if ith bit is set in the A[i-1],
                //then add its contribution in the ans for all subarrays ending at index i
                if((temp1 & pw) != 0){
                    ans = ans + pw*i;
                    idx[j] = i;  //store the index for next elements
                }else if(idx[j] != 0){  // if jth bit is not set
                    ans = ans + pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using
                }// the information of last element having jth bit set
            }
        }

        return (int)(ans % 1000000007);
    }

    public static void main(String[] args) {

        int A[] = {1, 2, 3, 4, 5};

        SubArrayOR sao = new SubArrayOR();

       int ans =  sao.solve(A);
        System.out.println(ans);
    }
}
