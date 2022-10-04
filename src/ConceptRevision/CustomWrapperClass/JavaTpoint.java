package ConceptRevision.CustomWrapperClass;

//creating the customer wrapper class for primitive type int
public class JavaTpoint {
    private int i;

    JavaTpoint(){}

    JavaTpoint(int i){
        this.i = i;
    }

    public int getValue(){
        return i;
    }

    public void setValue(int i){
        this.i = i;
    }

    //overriding toString is the main concept here in Customer Wrapper class
    @Override
    public String toString() {
        return Integer.toString(i);
    }

    public static void main(String[] args) {

        int i = 6;
        //This is AutoBoxing
        Integer f = Integer.valueOf(6);

        System.out.println(f);
        JavaTpoint j = new JavaTpoint(5);
        System.out.println(j);
    }

}
