package ConceptRevision.OOPsCOncepts;


/*Note : Method overloading is not possible by changing the return type of the method alone */
public class MethodOverloading {

    //method Overloading by changing the number of Arguments
    private static int add(int a , int b){
        return a+b;
    }

    private static int add(int a, int b , int c ){
        return a+b+c;
    }

    public static void main(String[] args) {
        System.out.println( "Ans is " + add(20,20));

        System.out.println("Answer is "+ add(30,20,10));
    }
}


class MethodOverloading2{
    // By changing the datatype of the method
    public static int add(int a , int b , int c){
        return a+b+c;
    }

    //doing type promotion for 3rd argument int to double
    public static double add(long a, long b , double c ){
        return a+b+c;
    }

    public static void main(String[] args) {
        System.out.println("Answer is " +add(12,22,32));
        System.out.println("Answer is " +add(12,13,23));
    }

}

