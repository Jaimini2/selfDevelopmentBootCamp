package src.Scaler.Trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        val = data;
        this.left = this.right = null;
    }

    void insert(int data) {
        if (val == data) {
            return;
        }
        if (data < val) {
            if (left == null) {
                left = new TreeNode(data);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new TreeNode(data);
            } else {
                right.insert(data);
            }
        }

    }
}

