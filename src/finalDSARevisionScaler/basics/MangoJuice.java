package src.finalDSARevisionScaler.basics;

public class MangoJuice {
    public int solve(int A, int B) {

        if (A == 1 && B == 0) {
            return 1;
        }
        int mangoGlass = 0;
        int mangoSlice = 0;

        mangoSlice = A * 3 + B;
        mangoGlass =  mangoSlice/ 2;


       return mangoGlass;
    }

    public static void main(String[] args) {
        MangoJuice mn = new MangoJuice();
        System.out.println(mn.solve(19,0));
    }
}


