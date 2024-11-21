package src.finalDSARevisionScaler.Trees;

import java.util.*;

public class BinaryTree {
    TreeNode root;

    BinaryTree() {
        this.root = null;
    }

    public TreeNode insert(TreeNode root, int data) {

        TreeNode parent = null;
        TreeNode temp = root;

        while (temp != null) {
            parent = temp;
            if (temp.data > data) {
                temp = temp.left;
            } else if (temp.data < data) {
                temp = temp.right;

            }
        }
        TreeNode newNode = new TreeNode(data);
        if (newNode.data > parent.data) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }


       /* if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }*/
        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    /**
     * Q46)Level Order Traversal
     * used queue to perform the level Order traversal
     * we will add the root in queue first , then poll it and add the left and right of tree in the queue which will give us the level order traversal
     *
     * @param root
     */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            queue.poll();
            System.out.print(node.data + " ,");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> traverseLevelByLevel(TreeNode root, int idx) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        levelByLevel(root, ans, idx);

        return ans;
    }

    public void levelByLevel(TreeNode A, ArrayList<ArrayList<Integer>> ans, int idx) {

        if (A == null) {
            return;
        }
        if (ans.size() == idx) {
            ans.add(new ArrayList<Integer>());
            ans.get(idx).add(A.data);
        } else {
            ans.get(idx).add(A.data);
        }

        levelByLevel(A.left, ans, idx + 1);
        levelByLevel(A.right, ans, idx + 1);
    }

    /**
     * Q47) Deserialize Binary Tree
     * Deserializing Binary Tree from an Array by using queue
     *
     * @param A
     * @return
     */
    public TreeNode deserializeTree(int[] A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(A[0]));

        TreeNode head = queue.peek();
        int i = 1;
        while (!queue.isEmpty() && i < A.length) {
            TreeNode root = queue.poll();
            if (A[i] != -1) {
                root.left = new TreeNode(A[i]);
                queue.add(root.left);
            }
            i++;

            if (A[i] != -1) {
                root.right = new TreeNode(A[i]);
                queue.add(root.right);
            }
            i++;

        }
        return head;

    }

    /**
     * Q48) Build Binary Tree from Inorder and PreOrder
     * Build Binary Tree from Inorder and PreOrder
     *
     * @param inOrder
     * @param preOrder
     * @return
     */

    public TreeNode buildTreeFromInOrderAndPreOrder(int[] inOrder, int[] preOrder) {
        int n = inOrder.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            hm.put(inOrder[i], hm.getOrDefault(inOrder[i], 0) + i);
        }
        return constructBinaryTreeFromINorderAndPreOrder(inOrder, 0, n - 1, preOrder, 0, n - 1, hm);
    }


    /**
     * Construct Binary Tree from Inorder and PreOrder
     *
     * @param inOrder
     * @param st
     * @param en
     * @param preOrder
     * @param st2
     * @param en2
     * @param hm
     * @return
     */
    private TreeNode constructBinaryTreeFromINorderAndPreOrder(int[] inOrder, int st, int en, int[] preOrder, int st2, int en2, HashMap<Integer, Integer> hm) {
        if (st > en) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[st2]);
        int firstIdx = hm.get(preOrder[st2]);

        root.left =
                constructBinaryTreeFromINorderAndPreOrder(inOrder, st, firstIdx - 1, preOrder, st2 + 1, st2 + (firstIdx - st), hm);

        root.right =
                constructBinaryTreeFromINorderAndPreOrder(inOrder, firstIdx + 1, en, preOrder, st2 + (firstIdx - st) + 1, en2, hm);

        return root;


    }


    public int sizeOfTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int x = sizeOfTree(root.left);
        int y = sizeOfTree(root.right);

        return x + y + 1;
    }

    /**
     * /**
     * Q49)Least common Ancestor in a Binary Tree
     *
     * @param A
     * @return
     */
    public ArrayList<Integer> nodeToRootPath(TreeNode root, int A) {
        ArrayList<Integer> a1 = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        if (root.data == A) {
            a1.add(root.data);
            return a1;
        }

        //check the left node for the value  and store it in leftList

        ArrayList<Integer> leftList = nodeToRootPath(root.left, A);

        if (leftList.size() > 1) {
            leftList.add(root.data);
            return leftList;
        }

        //check the right node for the value  and store it in rightList
        ArrayList<Integer> rightList = nodeToRootPath(root.right, A);

        if (rightList.size() > 1) {
            rightList.add(root.data);
            return rightList;
        }

        //if nothing is founf then pass empty list
        return new ArrayList<>();

    }

    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> path1 = nodeToRootPath(A, B);
        ArrayList<Integer> path2 = nodeToRootPath(A, C);

        if (path1.size() == 0 || path2.size() == 0) {
            return -1;
        }

        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(i))) {
            i--;
            j--;
        }

        //i + 1 since this is the last place where both paths were identical
        return path1.get(i + 1);

    }

    /**
     * Q56)Least common Ancestor in a Binary Search Tree
     *
     * @param root
     * @param A
     * @param B
     * @return
     */

    public int findLCAinBST(TreeNode root, int A, int B) {
        TreeNode temp = root;
        while (temp != null) {
            if (A < root.data && B < root.data) {
                temp = temp.left;
            } else if (A > temp.data && B > temp.data) {
                temp = temp.right;
            } else {
                return temp.data;
            }
        }
        return -1;
    }

    /**
     * Q57)Morris Inorder Traversal
     */
    public void morrisInorderTraversal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // if left chile is null , we will print the data
            if (curr.left == null) {
                System.out.print(curr.data + " ,");
                curr = curr.right;
            } else {
                // else go to the  inorder predecessor of current node
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if (temp.right == null) {

                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    System.out.print(curr.data + " ,");
                    curr = curr.right;
                }
            }
        }
    }

    /**
     * Q58) Delete a node from a Binary Search Tree
     *
     * @return
     */
    public TreeNode deleteNodeFromABinarySearchTree(TreeNode root, int data) {

        TreeNode deletedNode = null;
        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr == null) {
                return null;
            }


            if (data < curr.data) {
                parent = curr;
                curr = curr.left;
            } else if (data > curr.data) {
                parent = curr;
                curr = curr.right;
            }else {

                // we found the node to be deleted and we check if the node has one  or 2 children, based on this we will call our delete node method
                //if node to be deleted has 2 children


                if (curr.left != null && curr.right != null) {

                    TreeNode temp = curr.left;
                    TreeNode prev = curr;

                    while (temp.right != null) {
                        prev = temp;
                        temp = temp.right;
                    }

                    deletedNode = deleteNode(prev, temp);

                    temp.left = curr.left;
                    temp.right = curr.right;

                    if (parent.left == curr) {
                        parent.left = temp;
                    } else {
                        parent.right = temp;
                    }
                    curr = null;
                }
                // if node to be deleted has one child
                if (curr.left != null || curr.right != null || curr != null) {
                    deletedNode = deleteNode(parent, curr);
                    curr = null;
                }

            }

        }


        return deletedNode;

    }


    public TreeNode deleteNode(TreeNode parent, TreeNode curr) {

        TreeNode child;

        if (curr.left != null) {
            child = curr.left;
        } else {
            child = curr.right;
        }

        if (parent.left == curr) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return curr;
    }

    public TreeNode deleteNode2(TreeNode parent,TreeNode curr){
        TreeNode child;
        if(curr.left != null){
            child = curr.left;
        }else{
            child = curr.right;
        }

        if(parent.left == curr){
            parent.left = child;
        }else {
            parent.right = child;
        }

        return curr;

    }

    public TreeNode deleteNodeFromABinarySearchTree2(TreeNode root,int data){
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode nodeToBeRemoved = null;
        while (curr != null){
            if (data < curr.data){
                parent = curr;
                curr = curr.left;
            }else if(data > curr.data){
                parent = curr;
                curr = curr.right;
            }else{
                //we found the node that needs to be deleted
                //now we need to delete it

                //node to be dceleted has 2 children

                if(curr.left != null && curr.right != null){
                    TreeNode temp =curr.left;

                    while (temp != null){
                        parent = temp;
                        temp = temp.right;
                    }

                    nodeToBeRemoved = deleteNode(parent,temp);

                    temp.left = curr.left;
                    temp.right = curr.right;

                    if (parent.left == curr){
                        parent.left = temp;
                    }else{
                        parent.right = temp;
                    }

                    curr = null;
                }
                //Node to be deleted can have 0,1 or 2 children , so we will handle all these cases

                // node to be deleted has 1 or 0 children
                else if(curr.left != null || curr.right !=null || curr != null){
                    nodeToBeRemoved = deleteNode(parent,curr);
                }

                curr = null;

            }
        }

        return nodeToBeRemoved;

    }


}
