package  src.ConceptRevision.BasicPrograms.StringPrograms;

/**
 * Performance test of String , String Buffer and StringBuilder
 */
public class ConcatTest {

    public static String concatWithString(){
        String t = "java";
        for (int i = 0; i < 10000; i++){
            t = t + "Tpoint";
        }
        return t;
    }

    public static String concatWithStringBuffer(){
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++){
            sb = sb.append("Tpoint");
        }
        return sb.toString();
    }

    public static String concatWithStringBuilder(){
        StringBuilder sb = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++){
            sb = sb.append("Tpoint");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        concatWithString();

        System.out.println("Time taken by concating with String : " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        concatWithStringBuffer();
        System.out.println("Time taken by concating with StringBuffer : " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        concatWithStringBuilder();
        System.out.println("Time taken by concating with StringBuilder : " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
