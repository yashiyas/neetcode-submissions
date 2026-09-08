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
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        if(root == null){
            return sum[0];
        }
        int curr = 0;
        sum(curr,root,sum);
        return sum[0];
    }

    private void sum(int curr, TreeNode node, int[] sum){
        curr = curr*10 + node.val;
        if(node.left == null && node.right == null){
            sum[0] = sum[0]+curr;
        }
        if(node.left != null){
            sum(curr,node.left,sum);
        }
        if(node.right != null){
            sum(curr,node.right,sum);
        }
    }
}