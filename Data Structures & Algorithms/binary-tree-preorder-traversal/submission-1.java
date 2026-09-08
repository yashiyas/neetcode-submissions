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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList();

        recursionPreOrder(root, ans);
        return ans;
    }

    public void recursionPreOrder(TreeNode curr, List<Integer> ans){
        if(curr == null){
            return;
        }
        ans.add(curr.val);
        recursionPreOrder(curr.left, ans);
        recursionPreOrder(curr.right, ans);
    }
}