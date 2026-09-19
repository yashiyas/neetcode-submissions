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
    int ans = 0;
    public int longestConsecutive(TreeNode root) {

        if(root == null){
            return 0;
        }
        
        solve(root);

        return ans;
    }

    private int solve(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = solve(node.left);
        int right = solve(node.right);

        int curr = 0;

        if(node.left != null && node.left.val == node.val+1){
            curr = Math.max(curr, left);
        }

        if(node.right != null && node.right.val == node.val+1){
            curr = Math.max(curr, right);
        }

        ans = Math.max(ans, 1+curr);

        return 1+curr;
    }
}
