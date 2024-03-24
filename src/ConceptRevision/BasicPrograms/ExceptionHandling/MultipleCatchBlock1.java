package  src.ConceptRevision.BasicPrograms.ExceptionHandling;

public class MultipleCatchBlock1 {

    public static void main(String[] args) {

        try{
            int [] intarray=new int[5];
            intarray[5] = 30/0;
        }

        catch (IndexOutOfBoundsException ie){
            System.out.println("IndexOutOfBounds exception caught " + ie.toString());
        }
        catch (ArithmeticException ae){
            System.out.println("Arithmathic exception caught " + ae.toString());
        }
        catch (Exception e){
            System.out.println("Parent Exception caught  : "+e);
        }

        System.out.println("Rest of the code ");
    }
}
