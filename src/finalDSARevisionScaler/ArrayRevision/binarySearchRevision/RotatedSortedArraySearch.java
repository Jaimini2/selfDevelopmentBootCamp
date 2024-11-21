package src.finalDSARevisionScaler.ArrayRevision.binarySearchRevision;

/**
 * Q33) Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 * You can assume that no duplicates exist in the array.
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 */
public class RotatedSortedArraySearch {
    public int search(final int[] A, int B) {

        int start = 0;
        int end = A.length-1;

        while (start <= end){
            int mid = (start + end)/2;
            if(A[mid] == B){
                return mid;
            }
            //my approach which is slightly wrong
           /* else if(A[mid] > B && A[start] <= B){
                end = mid-1;
            }else if (A[mid] > B && A[start] > B){
                start = mid + 1;
            }
            else if(A[mid] < B && A[end] > B){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }*/
            else if(A[mid] >= A[0]){
                if(B >= A[0] && B <= A[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(A[mid] < A[0]){
                if(B >= A[mid] && B <= A[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        RotatedSortedArraySearch rs = new RotatedSortedArraySearch();
        int A[] = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int B = 202;

       int ans =  rs.search(A,B);
        System.out.println(ans);
    }
}
