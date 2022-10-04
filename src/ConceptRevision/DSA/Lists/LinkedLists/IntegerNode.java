package ConceptRevision.DSA.Lists.LinkedLists;

public class IntegerNode {
    private int data;
    private IntegerNode next;


    IntegerNode(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
