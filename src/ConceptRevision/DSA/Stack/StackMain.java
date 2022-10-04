package ConceptRevision.DSA.Stack;

import ConceptRevision.DSA.Lists.ArrayList.Employee;

public class StackMain {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee(1,"John","Doe"));
        stack.push(new Employee(2,"Jessica","Bella"));
        stack.push(new Employee(3,"New","Ton"));
        stack.push(new Employee(4,"Charles","Olievera"));
        stack.push(new Employee(5,"Christian","Coleman"));
        stack.push(new Employee(6,"Nate","Diaz"));

        System.out.println("========================Print stack=================");
        stack.printStack();

        System.out.println("Size of stack is " +stack.size());

        System.out.println("++++++++++++++++++++++++++++++Popping out ++++++++++++++++++++++++");
        stack.peek();
        System.out.println(stack.pop());

        System.out.println("Size of stack is " +stack.size());
        stack.printStack();
        System.out.println();
        System.out.println(stack.peek());

    }
}
