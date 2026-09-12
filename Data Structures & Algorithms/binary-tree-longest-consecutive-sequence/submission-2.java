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
    public int longestConsecutive(TreeNode root) {

        if(root == null){
            return 0;
        }

        int[] ans = new int[1];
        ans[0] = 1;

        Integer prev = null;

        dfs(root, ans, prev, 0);

        return ans[0];
        
    }

    private void dfs(TreeNode node, int[] ans, Integer prev, int curr){
        if(node == null){
            ans[0] = Math.max(ans[0], curr);
            return;
        }

        if(prev == null || node.val != prev + 1){
            ans[0] = Math.max(ans[0], curr);
            curr = 1;
        }
        else{
            curr = curr+1;
        }

        dfs(node.left, ans, node.val, curr);
        dfs(node.right, ans, node.val, curr);

    }
}
