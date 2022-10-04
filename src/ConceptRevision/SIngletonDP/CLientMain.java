package ConceptRevision.SIngletonDP;

public class CLientMain {
    public static void main(String[] args) {
        System.out.println("calling singleton instance multiple times ....");
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();
    }
}
