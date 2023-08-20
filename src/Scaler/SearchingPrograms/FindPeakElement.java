package Scaler.SearchingPrograms;

public class FindPeakElement {
    public int solve(int[] A) {
        int startindex = 0;
        int endIndex = A.length - 1;
        int ans1 = -1;
        int ans2 = -1;
        while (startindex <= endIndex) {
            int mid = (startindex + endIndex) / 2;
            if (mid != startindex && mid != endIndex) {
                if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                    ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                }else{
                    if(A[mid -1] >= A[mid]){
                        endIndex = mid -1;
                    }
                }
            } else {
                if (mid == endIndex) {
                    if (A[mid] >= A[mid - 1]) {
                        ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                    }
                }
                else {
                    if (A[mid] >= A[mid - 1]) {
                        ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                    }
                }
            }
            startindex = mid + 1;
        }

        while (startindex <= endIndex) {
            int mid = startindex + endIndex / 2;
            if (mid != startindex && mid != endIndex) {
                if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                    ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                }
            } else {
                if (mid == startindex) {
                    if (A[mid] >= A[mid + 1]) {
                        ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                    }
                }
                else {
                    if (A[mid] >= A[mid - 1]) {
                        ans1 = A[mid] >= ans1 ? A[mid] : ans1;
                    }
                }
                }
                endIndex = mid - 1;
            }

            return ans1 >= ans2 ? ans1 : ans2;

        }

    public int solve2(int[] A){
        int start = 0;
        int end = A.length - 1;
        int startIndex = 0;
        int endIndex = A.length - 1;
        int ans1 = -1;
       // int ans2 = -1;

        if(A.length == 1){
            return A[0];
        }

        while (start <= end){
            int mid = (start + end)/2;
            // checking if mid is the peak element
            if(mid != startIndex && mid != endIndex) {
                if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                    return A[mid];
                }
            }else  if(mid == startIndex){
                if(A[mid] >= A[mid+1]){
                    ans1 = A[mid];
                    return ans1;
                }
            }else if (mid == endIndex){
                if(A[mid] >= A[mid - 1]){
                    ans1 = A[mid];
                    return ans1;
                }
            }
            if( mid != startIndex && A[mid] <= A[mid-1]){
                end = mid - 1;
            }else {
                if(mid != endIndex && A[mid] <= A[mid+1]){
                    start = mid+1;
                }
            }

        }
        return ans1;
    }
    public static void main(String[] args) {

        FindPeakElement findPeakElement = new FindPeakElement();
        int A[] = {1,2,3,4,5};
        int B[] = {18,33,100,135,203,270,292,310,356,392,400,429,436,461,427,403,399,375,251,245,173,130,43};
        System.out.println(findPeakElement.solve2(A));

    }

}
