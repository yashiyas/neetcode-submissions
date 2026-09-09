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

        Queue<PathNode> queue = new LinkedList();

        queue.offer(new PathNode(Integer.MAX_VALUE, Integer.MIN_VALUE, root.val, root));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                PathNode curr = queue.poll();
                if(!(curr.val > curr.min && curr.val < curr.max)){
                    return false;
                }
                TreeNode left = curr.node.left;
                TreeNode right = curr.node.right;

                if(left != null){
                    PathNode node = new PathNode(curr.val, curr.min, left.val, left);
                    queue.offer(node);
                }

                if(right != null){
                    PathNode node = new PathNode(curr.max, curr.val, right.val, right);
                    queue.offer(node);
                }
            }
        }

        return true;


        
    }

    class PathNode{
        int max;
        int min;
        int val;
        TreeNode node;

        PathNode(int max, int min, int val, TreeNode node){
            this.max = max;
            this.min = min;
            this.val = val;
            this.node = node;
        }
    }
}
