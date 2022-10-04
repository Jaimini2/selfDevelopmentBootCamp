package ConceptRevision.BasicPrograms.Patterns;

public class Pattern4 {
    public static void main(String[] args) {
        System.out.println("*****Pattern 4 Example ************");
        System.out.println();

        for (int i = 0; i<=5;i++){
            int temp = 0;
            int j;
            for (j = 5; j>i;j--){
                System.out.print("  ");
            }
            for (int k =j;k<=i + j;k++){
                System.out.print("* ");
            }
           // for(int k =0 ; )
            System.out.println("");
        }
    }
}
