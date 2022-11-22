package ConceptRevision.DSA.Trees;

public class TreeMain {
    public static void main(String[] args) {
        Tree intTree = new Tree();
       // intTree.insert(34);
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(7);

        System.out.println("Traversal ");
        intTree.traverseInorder();
        System.out.println("Traversal .....");
        System.out.println(intTree.get(27));



        System.out.println(intTree.get(17));
        System.out.println();
        System.out.println();

        System.out.println("Minimum value in this tree is " + intTree.min());
        System.out.println("Maximum value in this tree is "+ intTree.max());

        System.out.println();
//        intTree.delete(26);
//        intTree.delete(25);

        intTree.traverseInorder();

        System.out.println();
        System.out.println(".......................Pre Order Traversal ..............");
        System.out.println();
        intTree.traversePreOrder();
        System.out.println();
        System.out.println(".......................Post Order Traversal ..............");

        System.out.println();
        intTree.traversePostOrder();

    }
}
