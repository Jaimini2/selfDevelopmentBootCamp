package src.finalDSARevisionScaler.sorting;

/**
 * Q35)Merge Sort Algorithm Implementation
 */
public class MergeSort {

    public void mergeSort(int[] A,int start,int end){
        if(end - start < 2){
            return;
        }
        int mid = (start + end)/2;

        mergeSort(A,start,mid);
        mergeSort(A,mid,end);

        merge(A,start,mid,end);

    }

    public void merge(int [] A,int start,int mid,int end){

        if(A[mid-1] <= A[mid]){
            return;
        }
        int i = start;
        int j = mid;
        int tempArr[] = new int[end - start];
        int tempIdx = 0;

        while (i < mid && j < end){
            tempArr[tempIdx++] = A[i]<= A[j] ? A[i++] : A[j++];
        }

        System.arraycopy(A,i,A,tempIdx+start,mid-i);
        System.arraycopy(tempArr,0,A,start,tempIdx);

      /*  if(A[mid-1] <= A[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempArr[] = new int[end - start];
        int tempIdx = 0;

        while (i < mid && j < end){
            tempArr[tempIdx++] = A[i] <= A[j] ? A[i++] : A[j++];
        }

        System.arraycopy(A,i,A,tempIdx+start,mid-i);
        System.arraycopy(tempArr,0,A,start,tempIdx);*/
    }

    public static void main(String[] args) {

        int[] A = {1, 4, 10, 2, 1, 5};

        MergeSort ms = new MergeSort();

        ms.mergeSort(A,0,A.length);

        for (int a : A){
            System.out.print(a + " ");
        }

    }
}
