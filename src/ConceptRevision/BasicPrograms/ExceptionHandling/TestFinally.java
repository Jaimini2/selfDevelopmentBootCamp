package ConceptRevision.BasicPrograms.ExceptionHandling;

public class TestFinally {
    public static void main(String[] args) {
        try{
            int data = 50/0;
            System.out.println(data);
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }finally {
            System.out.println("Finally is always executed ");
        }
        System.out.println("Rest of the code ");
    }
}
