package Scaler.SearchingPrograms;

public class SearchForARange {

    public int[] searchRange(final int[] A, int B) {

        int startIndex = 0;
        int endIndex = A.length-1;
        int start = 0;
        int end = A.length-1;
        int firstIndex = -1;
        int lastIndex = -1;
        int[] ans = new int[2];

            if(A.length == 1) {
                if (A[0] == B) {
                    ans[0] = 0;
                    ans[1] = 0;
                    return ans;
                }
            }
                    ans[0] = firstIndex;
                    ans[1] = lastIndex;


        while (start <= end){
            int mid = (start + end)/2;

            if(mid != startIndex && mid != endIndex) {
                if (A[mid] > B) {
                    end = mid - 1;
                } else if (A[mid] < B) {
                    start = mid + 1;
                }else if(A[mid] == B){
                    firstIndex = mid;
                    lastIndex = mid;
                    while (firstIndex-1 >= startIndex && A[firstIndex-1] == B){
                        firstIndex--;
                    }
                    while (lastIndex+1 <= endIndex && A[lastIndex+1] == B ){
                        lastIndex++;
                    }
                    ans[0] = firstIndex;
                    ans[1]=lastIndex;
                    return ans;
                }
            } if(mid == startIndex){
                if(end - mid > 0) {
                    int count = 0;
                    while (count <= end) {
                        if (A[count] == B) {
                            firstIndex = count;
                            lastIndex = count;
                        }
                        count++;
                    }

//                if(A[mid] == B){
//                    firstIndex = mid;
//                    ans[0] = firstIndex;
//                    ans[1] = lastIndex;
//                }
                    ans[0] = firstIndex;
                    ans[1] = firstIndex;
                }
                else{
                    ans[0] = -1;
                    ans[1] = lastIndex;
                }
                end = mid-1;
            }if(mid == endIndex){
                if(end - mid > 0) {
                    int count = endIndex;
                    while (count >= mid) {
                        if (A[count] == B) {
                            lastIndex = count;
                            firstIndex = count;
                        }
                        count--;
                    }

//                if(A[mid] == B){
//                    lastIndex = mid;
                    ans[0] = firstIndex;
                    ans[1] = lastIndex;
                }
//                }
                else {
                    ans[0] = firstIndex;
                    ans[1] = -1;
                }
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int B = 4;
        int A[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6,
                6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10};
        int C[] = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };
        SearchForARange sr = new SearchForARange();
       int[] ans =  sr.searchRange(C,B);

        System.out.println(ans[0] + " " + ans[1]);

    }

}
