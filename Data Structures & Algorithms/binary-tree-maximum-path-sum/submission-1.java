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
    public int maxPathSum(TreeNode root) {

        int[] ans = new int[]{Integer.MIN_VALUE};

        int sum = dfs(root, ans);

        return ans[0];
        
    }

    private int dfs(TreeNode curr, int[] ans){
        if(curr == null){
            return 0;
        }

        int left = Math.max(0,dfs(curr.left, ans));
        int right = Math.max(0,dfs(curr.right, ans));

        int currSum = left+right+curr.val;

        ans[0] = Math.max(ans[0], currSum);

        return curr.val + Math.max(left,right);

    }
}
