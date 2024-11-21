package src.finalDSARevisionScaler.LinkedList;

public class LinkedList {
    LinkedNode head;


    LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        LinkedNode node = new LinkedNode(data);
        if (this.head == null) {
            head = node;
            head.next = null;
            return;
        }

        LinkedNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

    }


    public LinkedNode deleteFromEnd(){
        if(head == null){
            return null;
        }

        LinkedNode temp = head;
        LinkedNode prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;

        }
        prev.next = null;
        LinkedNode nodeToBEDeleted = temp;

        return nodeToBEDeleted;
    }

    public LinkedNode deleteAtPosition(int pos){
        int i = 1;
        LinkedNode temp = head;
        if(head == null){
            return null;
        }
        LinkedNode prev = null;
        while(temp.next != null && i < pos){
            prev = temp;
            temp = temp.next;
            i++;
        }

        if(i == pos){
            if(temp.next == null){
               return deleteFromEnd();
            }else{
                //handling edge cases .. in this case , if the position is head position
                if(prev == null){
                    LinkedNode nodeToBeDeleted = head;
                    head = head.next;
                    return nodeToBeDeleted;
                }
                prev.next = temp.next;
                LinkedNode nodeToBeDeleted = temp;
                return temp;
            }
        }
       return null;
    }

    public void insertAtPosition(int pos,int data){
        LinkedNode node = new LinkedNode(data);
        int i = 1;
        LinkedNode temp = head;
        if(head == null){
            return ;
        }
        LinkedNode prev = null;
        while(temp != null && i < pos){
            prev = temp;
            temp = temp.next;
            i++;
        }

        //since i is the last element here so if we want to insert after last element then the position will be i+1
        if (i == pos) {
            prev.next = node;
            node.next = temp;
        }else if(temp == null){
            insert(data);
        }
    }

    public void traverseAndDisplay(){
        LinkedNode temp = head;
        while (temp != null){
            System.out.print(temp.data + "==>");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printReverse(LinkedNode node){
        if(node == null){
            return ;
        }

        printReverse(node.next);
        System.out.print(node.data + "==>");
    }

    public void displayLines(){
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
        System.out.println("##################################################");
    }
}
