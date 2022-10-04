package ConceptRevision.DSA.Lists.LinkedLists;

public class IntegerLinkedList {
    private int size;
    private IntegerNode head;

    public void addInSortedManner(int data){
        IntegerNode node = new IntegerNode(data);
        if(head == null || head.getData() >= node.getData()){
           addToFront(data);
        }
        else{
            IntegerNode current = head.getNext();
            IntegerNode  previous = head;
            while ( current!= null && current.getData() < node.getData()){
                previous = current;
                current = current.getNext();

            }
                node.setNext(current);
                previous.setNext(node);
                size++;
        }

    }

    public void addToFront(int data){
        IntegerNode node = new IntegerNode(data);
        if(head == null){
            head = node;
            size++;
        }else{
            node.setNext(head);
            head = node;
            size++;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printList(){
        if (isEmpty()) {
            System.out.println("Linked list is Empty");
        }
        else{
            IntegerNode node = head;
            System.out.print("Head ==>");
            while (node != null){
                System.out.print("----------->");
                System.out.print(node);
                node = node.getNext();
            }
        }

    }
}
