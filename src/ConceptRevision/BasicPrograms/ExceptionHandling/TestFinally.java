package ConceptRevision.BasicPrograms.ExceptionHandling;

public class TestFinally {

    int x = 6;

    static int testFinally(int n){
        try{
            return n/0;
        }catch (ArithmeticException e){
            return n;
        }finally {
            System.out.println("This is always executed");
            return n;
        }
    }

    public static void main(String[] args) {
       /* try{
            int data = 50/0;
            System.out.println(data);
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }finally {
            System.out.println("Finally is always executed ");
        }
        System.out.println("Rest of the code ");

        System.out.println("This is the testing of the finally code in method");*/

        System.out.println(testFinally(5));

        TestFinally t = new TestFinally2();
        System.out.println(t.x);
    }

}

class TestFinally2 extends TestFinally{
    int x =8;


}
