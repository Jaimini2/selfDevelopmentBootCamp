package src.Scaler.Trees;

public class BST {
    TreeNode root;

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode( 5);
        A.right = new TreeNode(2) ;

        A.right.left = new TreeNode(3);
        A.right.right = new TreeNode(6);
        bst.insert(4);
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);

        System.out.println(" IN ORDER TRAVERSAL");
        bst.inorderTraversal(bst.root);
        System.out.println();
        System.out.println(" PRE ORDER TRAVERSAL");
        bst.preOrderTraversal(bst.root);
    }

    void insert(int data){
        if(root == null){
             root = new TreeNode(data);
        }else{
            root.insert(data);
        }

    }

    void inorderTraversal(TreeNode A){
        if(A == null){
            return;
        }

        inorderTraversal(A.left);
        System.out.print(A.val + " ");
        inorderTraversal(A.right);

    }

    void preOrderTraversal(TreeNode A){
        if(A == null){
            return;
        }
        System.out.print(A.val + " ");
        preOrderTraversal(A.left);
        preOrderTraversal(A.right);
    }

   /* public TreeNode solve(TreeNode A, int B) {
        TreeNode parent = null;
        deleteNode(A,B);

        return A;
    }

    void deleteNode(TreeNode A,int B){
        TreeNode prev = null;
        TreeNode curr = A;
        TreeNode parent = null;

        if(curr == null){
            return;
        }

        if(curr.val > B){
            parent = curr;
            deleteNode(curr.left,B);
        }
        else if(curr.val < B){
            parent = curr;
            deleteNode(curr.right,B);
        }
        else{
            TreeNode temp = null;
            if(curr.left != null && curr.right != null){

                prev = curr;
                temp = curr.left;


                while(temp != null){
                    prev = temp;
                    temp = temp.right;
                }
                TreeNode replaceNode = deletion(temp,prev);

                if(parent.left == curr){
                    parent.left = replaceNode;
                }else{
                    parent.right = replaceNode;
                }
            }else{
                deletion(temp,prev);
            }

        }
    }

    TreeNode deletion(TreeNode temp,TreeNode prev){
        TreeNode child = null;

        if(temp.left != null){
            child = temp.left;
        }else{
            child = temp.right;
        }
        if(prev.left == temp){
            prev.left = child;
        }else{
            prev.right = child;
        }

        return child;
    }*/
}
