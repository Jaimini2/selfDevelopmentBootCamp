package Scaler.TwoPointers;

import ConceptRevision.DSA.Arrays.MergeSort;

public class SubArrayWithGivenSum {
        public int[] solve(int[] A, int B) {
            int firstIndex = 0;
            int secondIndex = 1;
            int ans = 0;
            int n = A.length;


            if(A.length == 1){
                if(A[0] == B){
                    return A;
                }else{
                    int[] arr ={-1};
                    return arr;
                }
            }

            ans = A[0];
            while(secondIndex < n){
                if(secondIndex < n && ans + A[secondIndex] < B){
                    ans += A[secondIndex];
                    secondIndex++;

                }else if(ans + A[secondIndex] == B){
                    ans = ans + A[secondIndex];
                    break;
                }else if(ans + A[secondIndex] > B){
                    while(firstIndex < n && ans + A[secondIndex] > B){
                        ans = ans - A[firstIndex];
                        firstIndex++;
                        if(firstIndex < n && firstIndex == secondIndex){
                            secondIndex++;
                        }
                    }
                }

            }

            int[] ansArray = new int[secondIndex - firstIndex + 1];
            if(ans == B){
                int count =0;
                for(int i = firstIndex; i <= secondIndex;i++){
                    ansArray[count] = A[i];
                    count++;
                }
                return ansArray;
            }else{
                return  new int[-1];
            }

        }

    public static void main(String[] args) {
        SubArrayWithGivenSum sb = new SubArrayWithGivenSum();
        int A[] = {1,2,3,4,5};
        int[] ans = sb.solve(A,5);

        MergeSort.displaySortedArray(ans);
    }

}
