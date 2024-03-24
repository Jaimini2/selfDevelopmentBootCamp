package  src.ConceptRevision.BasicPrograms.Patterns;

public class Pattern2 {
    public static void main(String[] args) {
        System.out.println("******************* Displaying Pattern2 Example *********************");

        for (int i = 0 ; i <= 5 ; i++){
            for (int j = 5; j >=i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
