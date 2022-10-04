package ConceptRevision.BasicPrograms.ExceptionHandling;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

class M{
    void method() throws IOException {
       throw new IOException("Device error occurred");
    }
}
public class TestThrowsKeyword {
    public static void main(String[] args) throws IOException {
        M m = new M();
        try{
            m.method();
        }catch(IOException io){
            System.out.println("IO Exception caught "+io);
//            throw new IOException("Retrhowing IOException");
        }


        System.out.println("THis is now the normal Flow");
    }
}
