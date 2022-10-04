package ConceptRevision.BasicPrograms.Patterns;

public class Pattern3 {
    public static void main(String[] args) {
        System.out.println("********printing pattern As Below *************");
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= 1; j--) {
                if (j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }

            }
            System.out.println();
        }
    }
}
