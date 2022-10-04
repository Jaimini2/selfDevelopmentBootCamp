package ConceptRevision.DSA.Lists.DoublyLinkedList;

import ConceptRevision.DSA.Lists.ArrayList.Employee;

public class EmployeeLinkedList {

    private int size ;
    private EmployeeNode head;
    private EmployeeNode tail;

    //Doubly linked list add to front
   public void addtoFront(Employee emp){
       EmployeeNode node = new EmployeeNode(emp);
       if(head == null){
           head = node;
           tail = node;
           node.setNext(null);
           size++;
       }
       else{
           node.setNext(head);
           head.setPrevious(node);
           head = node;
           size++;
       }

   }

    public int getSize(){
        return size;
    }

    public void printList(){
        EmployeeNode current = head;
        while (current != null){
            System.out.print(current);
            System.out.print(" <===>");
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
        head.getNext().setPrevious(head);
        size--;
        removeNode.setNext(null);
        return removeNode;
    }


    public void addToEnd(Employee emp){
       EmployeeNode node = new EmployeeNode(emp);
       if(tail == null){
           tail = node;
           node.setNext(null);
           size++;
       }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            size++;
       }

    }

    public EmployeeNode removeFromEnd(){
       if(head == null)
           return null;

       if(head.getNext() == null){
           EmployeeNode removeNode = head;
           head = null;
           size--;
           return removeNode;
       }
       EmployeeNode removeNode = tail;
       tail = removeNode.getPrevious();
       tail.setNext(null);
        size--;
       return removeNode;
    }

    public EmployeeNode removeNthNodeFromEnd(int num){
        int count = 0;
        EmployeeNode current = head;
        while(current != null && count!= num){
            current = current.getNext();
            count++;
        }

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

    public void addBefore(Employee emp1,Employee emp2) {
        if (isEmpty()) return;

        EmployeeNode nodeTobeAdded = new EmployeeNode(emp1);

        EmployeeNode current = head;
        while (current != null && !current.getEmployee().equals(emp2)) {
            current = current.getNext();
        }
        if (current != null) {
            nodeTobeAdded.setNext(current);
            nodeTobeAdded.setPrevious(current.getPrevious());
            current.getPrevious().setNext(nodeTobeAdded);
            current.setPrevious(nodeTobeAdded);
            size++;
        }

    }

}
