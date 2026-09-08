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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int curr = 0;   
        return hasSum(curr,root,targetSum);
        
    }

    private boolean hasSum(int currSum, TreeNode node, int target){
        if(node == null){
            return false;
        }
        currSum += node.val;
        if(isLeafNode(node)){
            if(currSum == target){
                return true;
            }

            return false;
        }
        boolean left = hasSum(currSum, node.left, target);
        if(left){
            return true;
        }
        return hasSum(currSum, node.right, target);
    }

    private boolean isLeafNode(TreeNode root){
        return root.left == null && root.right == null;
    }
}