package  src.ConceptRevision.DSA.Lists.LinkedLists;

import src.ConceptRevision.DSA.Lists.ArrayList.Employee;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1,"Jai","Science");
        Employee emp2 = new Employee(2,"Bhai","Physics");
        Employee emp3 = new Employee(3,"Mathews","Law");
        Employee emp4 = new Employee(4,"Raja","Chemistry");
        Employee emp5 = new Employee(5,"Dhamma","Maths");
        Employee emp6 = new Employee(6,"Rohan","Algebra");
        Employee emp7 = new Employee(7,"Pranay","Don");

        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        linkedList.addtoFront(emp1);
        linkedList.addtoFront(emp2);
        linkedList.addtoFront(emp3);
        linkedList.addtoFront(emp4);
        linkedList.addtoFront(emp5);
        linkedList.addtoFront(emp6);
        linkedList.addtoFront(emp7);


        linkedList.printList();

        System.out.println(linkedList.isEmpty());

       // linkedList.removeFromFront();

        System.out.println(linkedList.getSize());

        EmployeeNode removedNode = linkedList.removeNthNodeFromEnd(4);
        System.out.println("Node removed from the  3rd postion from end is ");
        System.out.println(removedNode);
        System.out.println("=========================================================");

     /*   EmployeeNode removeNode = linkedList.removeNthNodeFromEnd(4);
        System.out.println("Node removed from the 4th position from end is ");
        System.out.println(removedNode);*/

        System.out.println("After Revoming Nth Node from the End ");
        System.out.println("=========================================");
        System.out.println("==========================================");
        linkedList.printList();

        IntegerLinkedList intList = new IntegerLinkedList();
        intList.addInSortedManner(7);
        intList.addInSortedManner(3);
        intList.addInSortedManner(9);
        intList.addInSortedManner(21);
        intList.addInSortedManner(90);
        intList.addInSortedManner(23);
        intList.addInSortedManner(1);

        System.out.println("-----------------------------------INTEGER LINKED LIST ---------------------------------------");
        intList.printList();
    }
}
