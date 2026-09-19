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
    TreeNode head = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        solve(root, null);
        return head;
    }

    private void solve(TreeNode node, TreeNode prev){
        if(node == null){
            return;
        }

        solve(node.left, node);

        if(head == null){
            head = node;
        }

        node.right = prev;
        node.left = (prev == null ? null : prev.right);

    }
}
