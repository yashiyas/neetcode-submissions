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
    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        int left = fetchHeight(root.left);
        int right = fetchHeight(root.right);

        return Math.abs(left-right) <=1 && isBalanced(root.left) && isBalanced(root.right);

    
        
    }

    private int fetchHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }
        
        return 1+ Math.max(fetchHeight(node.left),fetchHeight(node.right));
    }
}
