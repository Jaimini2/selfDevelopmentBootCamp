package  src.ConceptRevision.BasicPrograms.ExceptionHandling;

public class NestedTryBlock {
    public static void main(String[] args) {
        try{
            try{
                try{
                    int i = 50;
                    int data = i/0;
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println(e);
            }
        }catch (ArithmeticException e){
            System.out.println(e);
        }
    }

}
