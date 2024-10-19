package src.finalDSARevisionScaler.basics.InterviewProblems;


/* int ls = 0;
          int rs = 0;

          if(A.charAt(i) == '0'){
              int j = i -1;
              int k = i+1;
              while(j >=0 && A.charAt(j) == '1'){
                  ls++;
                  j--;
              }

              while (k < A.length() && A.charAt(k) == '1'){
                  rs++;
                  k++;
              }
              ans = Math.max(ans,ls + rs + 1);

          }*/
public class MaxConsecutiveOnes {

    public int solve(String A) {
        int ans = 0;
        int[] leftArr = new int[A.length()];
       if(A.charAt(0) == '1'){
           leftArr[0] = 1;
            }
       else {
           leftArr[0] = 0;
       }

        int[] rightArr = new int[A.length()];
        if(A.charAt(rightArr.length - 1) == '1'){
            rightArr[rightArr.length - 1] = 1;
        }
        else {
            rightArr[rightArr.length - 1] = 0;
        }

        int total_ones = leftArr[0];

        for (int i = 1; i < A.length(); i++) {

            if (A.charAt(i) == '1') {
                leftArr[i] = leftArr[i - 1] + 1;
                total_ones++;
            } else {
                leftArr[i] = 0;
            }
        }

        for (int i = A.length() - 2; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                rightArr[i] = rightArr[i + 1] + 1;
            } else {
                rightArr[i] = 0;
            }
        }

        int sum = 0;
        int cnt = 0;
        int max_cnt = 0;
        for (int j = 0; j < A.length(); j++) {
            max_cnt = Math.max(max_cnt, Math.max(leftArr[j], rightArr[j]));
            for (int i = 1; i < A.length() - 1; i++) {
                if (A.charAt(i) == '0') {
                    sum = leftArr[i - 1] + rightArr[i + 1];

                    if (sum < total_ones)
                        ans = sum + 1;
                    else
                        ans = sum;

                    max_cnt = Math.max(max_cnt, ans);
                    ans = 0;
                }
            }
        }

        return max_cnt;
    }

    public static void main(String[] args) {

        MaxConsecutiveOnes mn = new MaxConsecutiveOnes();
        String s = "11010110000000000";
        String s1 = "00000000000";
        System.out.println(mn.solve(s));

    }
}
