package src.finalDSARevisionScaler.recurrsion1;

/**
 * Q8) Recurrsion -- power Function
 */
public class PowerFunction {


    public int pow(int A,int B,int C){

        if(B == 0){
            return 1;
        }
        else if(B == 1){
            return A;
        }

        long x = pow(A,B/2,C) % C ;

        if(B%2 == 0){
            return (int) ((x%C * x%C)%C + C)%C;
        }else{
            return (int)(((((x%C* x%C)%C) * A%C)%C)+C)%C;
        }
    }

    public static void main(String[] args) {

        PowerFunction f1 = new PowerFunction();
        int c = 100000009 + 7;
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;
       int ans =  f1.pow(A,B,C);
        System.out.println(ans);
    }

}
