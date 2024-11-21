package src.finalDSARevisionScaler.stack;

/**
 * Q38) Stack Implementation using Array
 */
public class StackMain {


    public static void main(String[] args) {

        Stack st = new Stack();
        System.out.println(st.peek());

        st.push(3);
        st.push(7);
        st.push(10);
        st.push(15);

        st.printStack();
        System.out.println();
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size());

    }
}
