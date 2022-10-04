package ConceptRevision.DSA.Stack;

import ConceptRevision.DSA.Lists.ArrayList.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedStack {
    private LinkedList<Employee>stack ;

    public LinkedStack(){
        stack = new LinkedList<Employee>();
    }

    public void push(Employee emp){
        stack.push(emp);
    }

    public Employee pop(){
        return stack.pop();
    }
    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printLinkedStack(){
        Iterator it = stack.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
