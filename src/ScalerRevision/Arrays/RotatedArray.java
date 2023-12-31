package ScalerRevision.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedArray {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        // Write your code here
        int n = arr.size();

        ArrayList<Integer> ans = new ArrayList<>();
        int modSize = 0;

        if(d > n){
            modSize = d % n;
        }

        if(modSize == 0){
           populateAns(ans,d,arr);
        }else {
          populateAns(ans,modSize,arr);
        }
        return ans;
    /*if(modSize == 0){
        while(count < d){
            shift(arr);
            count++;
        }
    }else{
        while(count < modSize){
            shift(arr);
            count++;
        }
    } */

    }

    private static void populateAns(List<Integer> ans,int num,List<Integer>arr){
        for (int i = num; i < arr.size(); i++) {
            ans.add(arr.get(i));
        }

        for (int i = 0; i < num; i++) {
            ans.add(arr.get(i));
        }
    }

    public static void shift(List<Integer> arr) {
        int temp = arr.get(0);
        for (int i = 0; i < arr.size() - 1; i++) {
            arr.add(i, arr.get(i + 1));
        }
        arr.add(arr.size() - 1, temp);
    }

    public static void main(String[] args) {
        int d = 4;
        List<Integer> a1 =  Arrays.asList(1,2,3,4,5);

        List<Integer> ans = RotatedArray.rotateLeft(d,a1);

        for (int i : ans){
            System.out.println(i);
        }
    }

}

