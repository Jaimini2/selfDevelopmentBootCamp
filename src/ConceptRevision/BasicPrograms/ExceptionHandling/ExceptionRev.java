package  src.ConceptRevision.BasicPrograms.ExceptionHandling;


import java.io.IOException;

class MM{

    void method()throws IOException {
        throw new IOException("Exception is thrown");
    }

}
public class ExceptionRev {

    public static void main(String[] args) throws Exception{

        MM m = new MM();
        try{
            m.method();
        }finally {
            System.out.println("Code flow executed successfully");
        }



    }
}
