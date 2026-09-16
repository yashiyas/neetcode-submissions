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

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int through = maxSum(root);
        return ans;
        
    }

    private int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int rightMax = maxSum(root.right);
        int leftMax = maxSum(root.left);

        int split = root.val+rightMax+leftMax;

        int through = Math.max(root.val, root.val + Math.max(rightMax, leftMax));

        ans = Math.max(ans, split);
        ans = Math.max(ans, through);

        return through;

    }
}
