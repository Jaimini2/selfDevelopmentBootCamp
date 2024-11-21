package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q13) Construct Binary Number
 * Construct a binary number having A 1's followed by B 0's .
 * Return the decimal value of that Binary number
 */
public class ConstructBinary {

    public int solve(int A, int B) {
        int[] arr = new int[A+B];

        int counter = 0;
        for(int i =0; i < arr.length;i++){
            if(counter < A){
                arr[i]=1;
                counter++;
            }
        }

        for(int i =0; i < B;i++){
            arr[counter+i]=0;
        }

        int ans = 0;
        int n = arr.length-1;
        for(int i = arr.length-1; i >= 0; i--){
            ans = ans + (int) (arr[i] * Math.pow(2,n-i));
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructBinary cb = new ConstructBinary();

       int ans =  cb.solve(5,4);
        System.out.println(ans);
    }
}
