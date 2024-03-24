package  src.ConceptRevision.DSA.Trees;

public class Tree {
    private TreeNode root;

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }
        else{
            root.insert(value);
        }
    }

    public void traverseInorder(){
        if(root != null){
            root.traverseInorder();
        }
    }

    public void traversePreOrder(){
        if (root!= null){
            root.traverserPreOrder();
        }
    }

    public void traversePostOrder(){
        if(root != null){
            root.traversePostOrder();
        }
    }

    public Integer get(int value){
        if(root != null){
            return root.get(value);
        }
        return null;
    }

    public void delete(int value){
        root = delete(root,value);

    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        //if node to be deleted is a leaf node i.e. with no children
        // or Node to be deleted has one child
        if(subTreeRoot == null){
            return subTreeRoot;
        }
        if(value < subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        }
        else if(value > subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),value));
        }
        else{
            //cases 1 and 2 : Node to delete has 0 or 1 child(ren)
            if(subTreeRoot.getLeftChild() == null){
               return subTreeRoot.getRightChild();
            }
            else if(subTreeRoot.getRightChild() == null){
                return subTreeRoot.getLeftChild();
            }

            //case 3 : Node to delete has 2 children
            // Replace the value in the subtreeRoot node with the smallest value from the Right Child
            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            //Delete the node that has the smallest value in the right Subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));

        }
        return subTreeRoot;
    }

    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        }else {
          return  root.min();
        }
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }else{
            return root.max();
        }
    }

    @Override
    public String toString() {
        return "Data=" + root;
    }
}
