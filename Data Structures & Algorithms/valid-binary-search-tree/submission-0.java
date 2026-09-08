/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        Queue<Pair> queue = new LinkedList();

        Pair p = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, root);

        queue.offer(p);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair top = queue.poll();
                TreeNode curr = top.node;

                if(curr.val >= top.max || curr.val <= top.min){
                    return false;
                }

                if(curr.left != null){
                    Pair left = new Pair(curr.val, top.min, curr.left);
                    queue.offer(left);
                }

                if(curr.right != null){
                    Pair right = new Pair(top.max, curr.val, curr.right);
                    queue.offer(right);
                }


            }
        }

        return true;

        
    }


    class Pair {
        
        int max;
        int min;
        TreeNode node;

        Pair(int max, int min, TreeNode node){
            this.max = max;
            this.min = min;
            this.node = node;
        }

    }
}
