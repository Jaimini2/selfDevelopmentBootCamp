package src.Scaler.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

        class Pair{
            TreeNode A;
            int level;

            Pair(TreeNode A,int level){
                this.A = A;
                this.level = level;
            }
        }
        public int[][] verticalOrderTraversal(TreeNode A) {
            int minVal = 0; // Initialize with 0 for vertical levels
            int maxVal = 0; // Initialize with 0 for vertical levels
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            Queue<Pair> pq = new LinkedList<>();
            TreeNode node = A;
            if(A == null){
                return new int[0][0];
            }
            Pair p = new Pair(A,0);
            pq.add(p);
            while(!pq.isEmpty()){
                Pair x = pq.remove();
                node = x.A;
                int level = x.level;
                ArrayList<Integer> lst = hm.getOrDefault(level,new ArrayList<>());
                lst.add(node.val);
                minVal = Math.min(minVal,level);
                maxVal = Math.max(maxVal,level);

                hm.put(level,lst);

                if(node.left != null){
                    pq.add(new Pair(node.left,level-1));
                }

                if(node.right != null){
                    pq.add(new Pair(node.right,level + 1));
                }
            }
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            for(int i = minVal; i <= maxVal;i++){
                ArrayList<Integer> list = hm.getOrDefault(i, new ArrayList<>());

                ans.add(list);

            }
            int[][] finalAns = new int[ans.size()][];
            for(int i =0 ; i < ans.size();i++){
                finalAns[i] = new int[ans.get(i).size()];
                for(int j =0 ; j < ans.get(i).size();j++){
                    finalAns[i][j] = ans.get(i).get(j);
                }
            }

            return finalAns;

        }

    public static void main(String[] args) {
        VerticalOrderTraversal vt = new VerticalOrderTraversal();

        TreeNode A = new TreeNode(4);
        A.left = new TreeNode( 5);
        A.right = new TreeNode(2) ;

        A.right.left = new TreeNode(3);
        A.right.right = new TreeNode(6);

        A.left.left = new TreeNode(40);
        A.left.right = new TreeNode(45);

        A.left.left.left = new TreeNode(62);

        int[][] ans = vt.verticalOrderTraversal(A);

            for (int i = 0; i < ans.length;i++){
                for(int j =0 ; j < ans[i].length;j++){
                    System.out.println(ans[i][j]);
                }
            }

    }
    }
