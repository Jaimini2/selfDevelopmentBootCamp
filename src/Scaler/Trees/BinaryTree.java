package src.Scaler.Trees;

public class BinaryTree {

   static int countNodesWithGreaterValThanAncestor(TreeNode A){
        int count = 0;
        if(A == null){
            return 0;
        }

        if(A.left != null && A.val < A.left.val){
            count++;
        }
        if(A.right != null && A.val < A.right.val){
            count++;
        }
       int x =  countNodesWithGreaterValThanAncestor(A.left);
        int y =  countNodesWithGreaterValThanAncestor(A.right);

        return count + x + y;
    }

    static int countNodesWithGreaterValThanAncestor2(TreeNode A){
       int count = 0;

       TreeNode temp = A;
        int x = countAncestors(temp.left,count);
        int y = countAncestors(temp.right,count);
      /* if(A == null){
           return 0;
       }
       if(A.left != null){
           if(A.left.val > A.val){
               count++;
           }
       }
       if(A.right != null){
           if(A.right.val > A.val){
               count++;
           }
       }*/
        return 1 + x + y;
    }

    static int countAncestors(TreeNode temp,int count){
        while (temp.left != null && temp.val < temp.left.val){
            temp = temp.left;
        }
        if(temp.left == null){
            count++;
        }

        while (temp.right != null && temp.val < temp.right.val){
            temp = temp.right;
        }

        if(temp.right == null){
            count++;
        }
       return count;
    }

    public static void main(String[] args) {
            TreeNode A = new TreeNode(4);
            A.left = new TreeNode( 5);
            A.right = new TreeNode(2) ;

            A.right.left = new TreeNode(3);
            A.right.right = new TreeNode(6);

            int nodesCount = countNodesWithGreaterValThanAncestor2(A);
        System.out.println(nodesCount);

    }
}
