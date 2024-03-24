package  src.ConceptRevision.DSA.Lists.DoublyLinkedList;

import src.ConceptRevision.DSA.Lists.ArrayList.Employee;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Jai", "Science");
        Employee emp2 = new Employee(2, "Bhai", "Physics");
        Employee emp3 = new Employee(3, "Mathews", "Law");
        Employee emp4 = new Employee(4, "Raja", "Chemistry");
        Employee emp5 = new Employee(5, "Dhamma", "Maths");
        Employee emp6 = new Employee(6, "Rohan", "Algebra");
        Employee emp7 = new Employee(7, "Pranay", "Don");

        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        linkedList.addtoFront(emp1);
        linkedList.addtoFront(emp2);
        linkedList.addtoFront(emp3);
        linkedList.addtoFront(emp4);
        linkedList.addtoFront(emp5);
        linkedList.addtoFront(emp6);
        linkedList.addtoFront(emp7);
        linkedList.addToEnd(new Employee(8, "Amit","Biology"));




        linkedList.printList();

        System.out.println(linkedList.isEmpty());

        // linkedList.removeFromFront();

        System.out.println(linkedList.getSize());

        System.out.println("=====================================Removing Node==========================");

        linkedList.removeFromFront();
        linkedList.removeFromFront();

        linkedList.printList();
        System.out.println();
        System.out.println(linkedList.getSize());

        System.out.println("=====================================Removing Node from End ==========================");
        linkedList.removeFromEnd();
        linkedList.printList();
        System.out.println();
        System.out.println(linkedList.getSize());
        System.out.println("========================Adding employee Before Specific Employee=============================");
        linkedList.addBefore(new Employee(9, "Amit Khairnar","System Designs"),emp3);

        linkedList.printList();
        System.out.println();
        System.out.println(linkedList.getSize());

    }
}
