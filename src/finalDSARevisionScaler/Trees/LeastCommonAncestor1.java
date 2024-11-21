package src.finalDSARevisionScaler.Trees;

/**
 * Q56)Least common Ancestor in a Binary Search Tree
 */
public class LeastCommonAncestor1 {

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

}
