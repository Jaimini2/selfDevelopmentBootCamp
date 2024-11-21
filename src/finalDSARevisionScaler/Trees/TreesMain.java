package src.finalDSARevisionScaler.Trees;

import java.util.ArrayList;

public class TreesMain {

    public static void addLineBreaks(){
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void addDistinguishLineBreaks(){
        System.out.println();
        System.out.println("#########################################");
        System.out.println("#########################################");
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        BinaryTree tree2 = new BinaryTree();

        TreeNode root = new TreeNode(50);

       tree.insert(root,1);
       tree.insert(root,25);
       tree.insert(root,56);
       tree.insert(root,31);
       tree.insert(root,97);
       tree.insert(root,49);
       tree.insert(root,62);
       tree.insert(root,83);
       tree.insert(root,92);

       tree.inOrderTraversal(root);
       addLineBreaks();
        System.out.println(tree.sizeOfTree(root));
        addLineBreaks();
        tree.levelOrderTraversal(root);

        int A[] = {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1};
        addLineBreaks();

        tree.levelOrderTraversal(tree.deserializeTree(A));

        int[] preOrder = {8,6,5,15,19,9,18,25,4,7,41,30,39,48};
        int[] inOrder = {15,5,19,6,18,9,25,8,7,41,4,39,30,48};

       TreeNode ans =  tree.buildTreeFromInOrderAndPreOrder(inOrder,preOrder);


        addLineBreaks();
        System.out.println("############## Level Order traversal of a Tree built from an Inorder and PreOrder data ###########");
        System.out.println("#########################################");
        System.out.println("#########################################");
        ArrayList<ArrayList<Integer>> al = tree.traverseLevelByLevel(ans,0);

        for (ArrayList<Integer> a1 : al){
            for (int b1 : a1){
                System.out.print(b1 + " ,");
            }
            System.out.println();
        }


        addLineBreaks();

      int treeArr[] = {6,4,5,9,7,30,15,19,18,25,41,39,48};
      TreeNode root2  = new TreeNode(8);
      for (int i : treeArr){
          tree2.insert(root2,i);
      }

      tree2.inOrderTraversal(root2);
        addLineBreaks();
        tree2.preOrderTraversal(root2);
        addLineBreaks();
        int lca = tree.findLCAinBST(root2,25,41);
        System.out.println(lca);
        addLineBreaks();
        tree2.morrisInorderTraversal(root2);

        addDistinguishLineBreaks();
       TreeNode treeAns  =  tree.deleteNodeFromABinarySearchTree2(root,56);
        System.out.println(treeAns.data + " , This node has been deleted");
        System.out.println();
        tree.sizeOfTree(root);

        tree.inOrderTraversal(root);


    }
}
