package ConceptRevision.DSA.Lists.LinkedLists;

import ConceptRevision.DSA.Lists.ArrayList.Employee;

public class EmployeeLinkedList {

    private int size ;
    private EmployeeNode head;

    public void addtoFront(Employee emp){
        EmployeeNode node = new EmployeeNode(emp);
        node.setNext(head);
        head = node;
        size++;
    }

    public int getSize(){
        return size;
    }

    public void printList(){
        EmployeeNode current = head;
        while (current != null){
            System.out.println(current);
            System.out.print(" ->");
            current = current.getNext();
        }
    }

    public boolean isEmpty(){
        return head==null;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removeNode = head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeNode removeNthNodeFromEnd(int num){
        int count = 0;
        EmployeeNode current = head;
        while(current != null && count!= num){
            current = current.getNext();
            count++;
        }
  /*      int nodeToBeRemoved = count - num;
        EmployeeNode removeNode = head;
        EmployeeNode previousNode = removeNode.getNext();
        while(nodeToBeRemoved != 0){
            removeNode = removeNode.getNext();
            previousNode = removeNode;
            nodeToBeRemoved--;
        }
        previousNode.setNext(removeNode.getNext().getNext());
        removeNode.setNext(null);
        return  removeNode;*/
        EmployeeNode removeNode = head;
        EmployeeNode previousNode = removeNode;
        while(current !=null){
            current = current.getNext();
            previousNode = removeNode;
            removeNode = removeNode.getNext();

        }

        previousNode.setNext(removeNode.getNext());

        System.out.println("Previous Node ====================="+
                previousNode);
        System.out.println("Removed NOde ===========================" + removeNode);
        return removeNode;
    }

}
