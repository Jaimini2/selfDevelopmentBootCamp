package  src.ConceptRevision.BasicPrograms.Patterns;

public class Pattern1 {
    public static void main(String[] args) {

        System.out.println("***********Printing Normal Pattern ***************");
        for (int i = 0 ; i <=5;i++){
            for (int j =0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
